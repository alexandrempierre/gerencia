package br.ufrj.dcc.gerencia.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Created by fausto on 4/2/16.
 */

@Configuration
@EnableWebMvc
@ComponentScan("br.ufrj.dcc.gerencia.web")
public class WebConfig extends WebMvcConfigurerAdapter{

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/assets/dist/**").addResourceLocations("classpath:/dist/");
    registry.addResourceHandler("/assets/css/**").addResourceLocations("classpath:/dist/css/");
    registry.addResourceHandler("/assets/js/**").addResourceLocations("classpath:/dist/js/");
    registry.addResourceHandler("/assets/view/**").addResourceLocations("classpath:/dist/view/");
    registry.addResourceHandler("/assets/img/**").addResourceLocations("classpath:/dist/img/");
    registry.addResourceHandler("/assets/fonts/**").addResourceLocations("classpath:/dist/fonts/");
  }
}
