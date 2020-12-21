package fr.massi.wipw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class WipwApplication {

	public static void main(String[] args) {
		SpringApplication.run(WipwApplication.class, args);
	}



	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.GET, "/api/equipes").permitAll()
					.antMatchers(HttpMethod.POST, "/api/equipes").hasRole("ADMIN")
					.antMatchers(HttpMethod.DELETE, "/api/equipes").hasRole("ADMIN")
					.antMatchers(HttpMethod.PUT, "/api/equipes").hasRole("ADMIN")
					.antMatchers(HttpMethod.POST, "/api/admin/connexion").permitAll()
					.antMatchers(HttpMethod.GET, "/api/admin/connexion").hasRole("ADMIN")
					.antMatchers(HttpMethod.GET, "/api/squestions").permitAll()
					.antMatchers(HttpMethod.POST, "/api/squestions").hasRole("ADMIN")
					.antMatchers(HttpMethod.PUT, "/api/squestions").hasRole("ADMIN")
					.antMatchers(HttpMethod.DELETE, "/api/squestions").hasRole("ADMIN")
					.antMatchers(HttpMethod.GET, "/api/joueurs").permitAll()
					.antMatchers(HttpMethod.POST, "/api/joueurs").hasRole("ADMIN")
					.antMatchers(HttpMethod.PUT, "/api/joueurs").hasRole("ADMIN")
					.antMatchers(HttpMethod.DELETE, "/api/joueurs").hasRole("ADMIN")
					.antMatchers(HttpMethod.GET, "/api/joues").permitAll()
					.antMatchers(HttpMethod.POST, "/api/joues").hasRole("ADMIN")
					.antMatchers(HttpMethod.PUT, "/api/joues").hasRole("ADMIN")
					.antMatchers(HttpMethod.DELETE, "/api/joues").hasRole("ADMIN")
					.anyRequest().authenticated();
		}
	}

}
