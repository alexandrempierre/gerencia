package br.ufrj.dcc.gerencia.business;

import br.ufrj.dcc.gerencia.business.entities.DirectoryFacade;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * Created by fausto on 4/5/16.
 */

@Configuration
@ComponentScan
public class BusinessConfiguration {

  @Value("${path.base.student}")
  private String studentBasePath;

  @Value("${path.base.teacher}")
  private String teacherBasePath;

  @Bean
  DirectoryFacade directoryFacade(){
    return new DirectoryFacade(studentBasePath, teacherBasePath);
  }

}
