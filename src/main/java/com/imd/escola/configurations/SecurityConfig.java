package com.imd.escola.configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UsuarioAuthenticatorFilter usuarioAuthenticationFilter;

    public static final String [] ROTAS_ABERTAS = {
            "/usuarios/login",
            "/usuarios"
    };

    public static final String [] ROTAS_ADMIN = {
            "/professores",
            "/turmas"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, ROTAS_ABERTAS).permitAll()
                //.requestMatchers("/**").authenticated()
                .requestMatchers(HttpMethod.GET, "/**").hasAnyRole("ALUNO", "ADMINISTRADOR")
                .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.PUT, "/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.PATCH, "/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMINISTRADOR")
                .anyRequest().denyAll()
                .and().addFilterBefore(usuarioAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
