package com.niit.Song;
import com.niit.Song.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class SongApplication {

	public static void main(String[] args) throws UnknownHostException {

		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println("\nIP Address:- " + inetAddress.getHostAddress());
		System.out.println("\nHost Name:- " + inetAddress.getHostName());
		SpringApplication.run(SongApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtfilter(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new JwtFilter());
		frb.addUrlPatterns("/music/song/*");
		return frb;
	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		final CorsConfiguration config= new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:4200");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);

		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
