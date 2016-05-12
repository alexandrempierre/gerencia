package br.ufrj.dcc.gerencia.application.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by fausto on 4/2/16.
 */

@Configuration
@ComponentScan(basePackages = {"br.ufrj.dcc.gerencia"},
  excludeFilters = {
    @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
  }
)
public class RootConfig {
}
