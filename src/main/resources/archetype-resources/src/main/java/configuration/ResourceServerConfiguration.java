package ${package}.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    public static final String REST_RESOURCE_ID = "restservice";

    @Override
	public void configure(ResourceServerSecurityConfigurer resources) {
        // @formatter:off
		resources
			.resourceId(REST_RESOURCE_ID);
		// @formatter:on
    }

    @Override
	public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
		http
			.authorizeRequests()
				.antMatchers("/api/**").authenticated();
		// @formatter:on
    }

}