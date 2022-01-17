package com.algaworks.algafood.auth.core;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtKeyStoreProperties jwtKeyStoreProperties;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
			.inMemory()
				.withClient("algafood-web")
					.secret(passwordEncoder.encode("web123"))
					.authorizedGrantTypes("password", "refresh_token")
					.scopes("WRITE", "READ")
					.accessTokenValiditySeconds(60 * 60 * 6) // 6 horas
					.refreshTokenValiditySeconds(60 * 60 * 24) // 1 dia
			.and()
				.withClient("foodanalytics")
					.secret(passwordEncoder.encode("ana123"))
//					.secret(passwordEncoder.encode(""))
					.authorizedGrantTypes("authorization_code")
					.scopes("WRITE", "READ")
					.redirectUris("http://aplicacao-cliente", "http://localhost:8082")
					
			.and()
				.withClient("webadmin")
					.authorizedGrantTypes("implicit")
					.scopes("WRITE", "READ")
					.redirectUris("http://aplicacao-cliente")
			.and()
				.withClient("faturamento")
					.secret(passwordEncoder.encode("fat123"))
					.authorizedGrantTypes("client_credentials")
					.scopes("WRITE", "READ")
			.and()
				.withClient("checktoken")
					.secret(passwordEncoder.encode("check123"));
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.checkTokenAccess("isAuthenticated()")
			.tokenKeyAccess("permitAll()")
			.allowFormAuthenticationForClients();
//		security.checkTokenAccess("permitAll()");
	}
	
	@Override // necessário para o fluxo de autenticação Password Credentials
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		var enhancerChain = new TokenEnhancerChain();
		enhancerChain.setTokenEnhancers(Arrays.asList(
				new JwtCustomClaimsTokenEnhancer(), jwtAccessTokenConverter()));
		
		endpoints
			.authenticationManager(authenticationManager)
			.userDetailsService(userDetailsService) // necessário para o fluxo de autenticação de refresh token
			.reuseRefreshTokens(false)
			.accessTokenConverter(jwtAccessTokenConverter())
			.approvalStore(approvalStore(endpoints.getTokenStore())) // tem que ser após accessTokenConverter, mais info vide método approvalStore
			.tokenEnhancer(enhancerChain)
			.tokenGranter(tokenGranter(endpoints)); // suporte a PKCE com o fluxo Authorization Code
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		var jwtAccessTokenConverter = new JwtAccessTokenConverter();
//		jwtAccessTokenConverter.setSigningKey("OEYuAy7esZ~.MPYgC9d_wVOlrUV0BUZFyzglS_T9d.TfwI3Bms3pQtztzqQ8GELCigb-uT-Rb0zseQQ91P51AxPvT0xsq-ExgwnusdoHjhgw8TQBEOFASShf.hBa442X"); // chave simples para didática apenas
		
		var jksResource = new ClassPathResource(jwtKeyStoreProperties.getPath());
		var keyStorePass = jwtKeyStoreProperties.getPassword();
		var keyPairAlias = jwtKeyStoreProperties.getKeypairAlias();
		
		var keyStoreKeyFactory = new KeyStoreKeyFactory(jksResource, keyStorePass.toCharArray());
		var keyPair = keyStoreKeyFactory.getKeyPair(keyPairAlias);
		
		jwtAccessTokenConverter.setKeyPair(keyPair);
		
		return jwtAccessTokenConverter;
	}
	
	// para voltar a aparecer os escopos na tela de autorização
	private ApprovalStore approvalStore(TokenStore tokenStore) {
		var approvalStore = new TokenApprovalStore();
		approvalStore.setTokenStore(tokenStore);
		
		return approvalStore;
	}
	
	// suporte a PKCE com o fluxo Authorization Code
	private TokenGranter tokenGranter(AuthorizationServerEndpointsConfigurer endpoints) {
		var pkceAuthorizationCodeTokenGranter = new PkceAuthorizationCodeTokenGranter(endpoints.getTokenServices(),
				endpoints.getAuthorizationCodeServices(), endpoints.getClientDetailsService(),
				endpoints.getOAuth2RequestFactory());
		
		var granters = Arrays.asList(
				pkceAuthorizationCodeTokenGranter, endpoints.getTokenGranter());
		
		return new CompositeTokenGranter(granters);
	}
	
}
