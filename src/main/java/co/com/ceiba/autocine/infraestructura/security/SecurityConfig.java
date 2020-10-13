package co.com.ceiba.autocine.infraestructura.security;

import co.com.ceiba.autocine.infraestructura.security.jwt.AuthEntryPointJwt;
import co.com.ceiba.autocine.infraestructura.security.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().disable()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/funcion/comprar").hasRole("USER")
                .antMatchers("/api/usuario/acceso").permitAll()
                .antMatchers("/console/**").permitAll();
                //.and()
                //.formLogin()
                //.loginPage("/inicio")
                //.defaultSuccessUrl("/funciones", true);

                // to test
                //.antMatchers("/admin/**").hasRole("ADMIN")
                //.antMatchers("/anonymous*").anonymous()
                //.antMatchers("/login*").permitAll()
                //.anyRequest().authenticated()

                //.loginProcessingUrl("/api/usuario/acceso")

                //.failureUrl("/login.html?error=true")
                //.failureHandler(authenticationFailureHandler())
                //.and()
                //.logout()
                //.logoutUrl("/perform_logout")
                //.deleteCookies("JSESSIONID");
                //.logoutSuccessHandler(logoutSuccessHandler());
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().disable().and()
                .cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .authorizeRequests()
                .antMatchers("/api/usuario/**").permitAll()
                .antMatchers("/api/funcion/**").permitAll()
                .antMatchers("/console/**").permitAll()
                .antMatchers("/h2/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }
}
