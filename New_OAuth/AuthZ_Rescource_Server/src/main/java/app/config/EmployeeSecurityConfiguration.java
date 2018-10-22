package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/*
TO provide HTTP intercept rules
*/
@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*
	 * Ignores HTTP requests having pattern like /resources/**
	*/
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/user/getEmployeesList").hasAnyRole("ADMIN").anyRequest().authenticated()
        .and()
        .formLogin().permitAll().and().logout().permitAll();

        http.csrf().disable();
    }
    
    
    @Bean(name = "dataSource")
	public DriverManagerDataSource oauthDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/oauth_schema?useSSL=false");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("Reboot_20");	
		return driverManagerDataSource;
	}

    @Override
    public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        //authenticationMgr.inMemoryAuthentication().withUser("admin").password("admin").authorities("ROLE_ADMIN");
    	
    	authenticationMgr.jdbcAuthentication().dataSource(oauthDataSource())
		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    	
    }
}
