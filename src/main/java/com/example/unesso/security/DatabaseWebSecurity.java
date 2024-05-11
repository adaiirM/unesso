package com.example.unesso.security;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {
	@Bean
	UserDetailsManager userCustom(DataSource dataSource) {
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		users.setUsersByUsernameQuery("select correo, contrasenia, estatus from usuario where correo = BINARY ?");
		users.setAuthoritiesByUsernameQuery("select u.correo, r.nombrerol from usuario as u, catrol as r where u.idCatRol = r.idCatRol and u.correo = BINARY ?");
		return users;
	}
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/css/", "/img/").permitAll()
                //.requestMatchers("/").permitAll()
                //.requestMatchers("/admin/").hasAnyAuthority("ADMINISTRADOR") 
                .anyRequest().authenticated());

        http.formLogin(form -> form.loginPage("/login").permitAll());

        return http.build();

	}
}