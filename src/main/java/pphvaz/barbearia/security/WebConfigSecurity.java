package pphvaz.barbearia.security;

import javax.servlet.http.HttpSessionListener;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebConfigSecurity extends WebSecurityConfigurerAdapter implements HttpSessionListener {

	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// Ignorando UTL no momento para não autenticar
		
		web.ignoring()
			.antMatchers(HttpMethod.GET, "/barbearia", "/roles")
			.antMatchers(HttpMethod.POST, "/barbearia", "/{id}")
			.antMatchers(HttpMethod.DELETE, "/barbearia", "/roles/{id}", "/{id}");
	}
	
}
