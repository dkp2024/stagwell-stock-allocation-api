package com.stagwell.stagwellapp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;
import java.util.Collection;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeHttpRequests ->
                                authorizeHttpRequests
                                        .requestMatchers("/**").authenticated() // Secure your API endpoint
                        //.requestMatchers("/**").authenticated()
                        //.anyRequest().permitAll() // Allow other endpoints
                ).

                oauth2ResourceServer((oauth2) -> oauth2
                        .jwt(Customizer.withDefaults())
                );
        return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:4200"));  // Your frontend URL
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));  // Allowed methods
        corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept"));
        corsConfig.setAllowCredentials(true);  // Allow credentials

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);  // Apply to all paths

        return source;
    }
  /*  @Bean("UsersAuthorities")
    public String usersAuthorities(@AuthenticationPrincipal Authentication authentication) {
        // Get roles from Authentication object
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

            // Convert authorities to a readable string or process them
            StringBuilder roles = new StringBuilder("Roles: ");
            for (GrantedAuthority authority : authorities) {
                roles.append(authority.getAuthority()).append(" ");
            }

            return roles.toString();
    }*/
 /* @Bean
  public JwtDecoder jwtDecoder() {
      // Use NimbusJwtDecoder to decode the JWT token and verify its signature
      return NimbusJwtDecoder.withJwkSetUri("https://dev-94284605.okta.com/oauth2/default/v1/keys").build();
  }*/

//    @Bean
//    public JwtAuthenticationConverter jwtAuthenticationConverter() {
//        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
//        JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
//        authoritiesConverter.setAuthorityPrefix("ROLE_");
//        authoritiesConverter.setAuthoritiesClaimName("groups");  // or "roles" if that's where Okta stores roles
//        converter.setJwtGrantedAuthoritiesConverter(authoritiesConverter);
//        return converter;
//    }
}
