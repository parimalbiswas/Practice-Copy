package com.parimal.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class AppConfig
{

	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception
	{

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable()
				.authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/customers").permitAll().anyRequest()
				.authenticated().and().addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
				.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class).formLogin().and()
				.httpBasic();

		return http.build();

	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean("mapbean")
	public Map<Integer, List<String>> mapbean()
	{

		Map<Integer, List<String>> map = new HashMap<>();
		map.put(1, Arrays.asList("Parimal", "Java"));
		map.put(2, Arrays.asList("Lalu", "BlockChain"));
		map.put(3, Arrays.asList("Kalu", "Python"));
		map.put(4, Arrays.asList("Bulu", "Dot Net"));

		return map;
	}

}
