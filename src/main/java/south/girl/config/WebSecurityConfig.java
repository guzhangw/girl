package south.girl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import south.girl.service.CustomUserService;

/**
 * Created by zhang_w on 2018/2/4.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("此处设置了所有请求都需要登录才能访问");
        System.out.println("此处设置了所有请求都需要登录才能访问");
        System.out.println("此处设置了所有请求都需要登录才能访问");

        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //参考教程地址：http://blog.csdn.net/u012702547/article/details/54319508
        http.authorizeRequests()
                .anyRequest().authenticated()       //此处设置了所有请求都需要登录才能访问
                .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()           //我们设置了登录页面，而且登录页面任何人都可以访问，然后设置了登录失败地址
                .and().logout().permitAll();        //注销请求也是任何人都可以访问的。
    }
}
