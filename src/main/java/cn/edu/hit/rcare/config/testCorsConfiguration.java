package cn.edu.hit.rcare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Title: 跨域
 * @author: Fly
 * @date: 2020/5/3 - 3:38
 */
@Configuration
public class testCorsConfiguration {

    @Bean
    public CorsFilter corsFilter(){
        //初始化cors配置对象
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        //允许跨域的域名，如果要携带cookie，不能写*，*代表所有域名都可以跨域访问
        corsConfiguration.addAllowedOrigin("*");
        //corsConfiguration.setAllowCredentials(true);//允许携带cookie
        corsConfiguration.addAllowedMethod("*");//代表所有请求方法：get、post、put、delete
        corsConfiguration.addAllowedHeader("*");//允许携带任何头信息

        //初始化cors配置源对象
        UrlBasedCorsConfigurationSource corsConfigurationSource=new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);

        //返回corsFilter实例，参数：cors配置源对象
        return new CorsFilter(corsConfigurationSource);
    }
}