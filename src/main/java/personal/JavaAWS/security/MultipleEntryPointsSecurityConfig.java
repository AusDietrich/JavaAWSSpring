package personal.JavaAWS.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class MultipleEntryPointsSecurityConfig {

	@Value("${usersName}")
	public String userName;
	@Value("${adminName}")
	public String adminName;
	@Value("${userPass}")
	public String userPass;
	@Value("${adminPass}")
	public String adminPass;
	
	@Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
          .withUsername(userName)
          .password(encoder().encode(userPass))
          .roles("USER").build());
        manager.createUser(User
          .withUsername(adminName)
          .password(encoder().encode(adminPass))
          .roles("ADMIN").build());
        return manager;
    }
    
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
