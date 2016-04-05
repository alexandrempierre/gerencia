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
    registry.addResourceHandler("/dist/**").addResourceLocations("classpath:/dist/");
  }
}
