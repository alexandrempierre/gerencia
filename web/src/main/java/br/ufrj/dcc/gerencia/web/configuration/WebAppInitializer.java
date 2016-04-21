package br.ufrj.dcc.gerencia.web.configuration;

import br.ufrj.dcc.gerencia.business.BusinessConfiguration;
import br.ufrj.dcc.gerencia.dataaccess.DataAccessConfig;
import br.ufrj.dcc.gerencia.service.ServiceConfig;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * Created by fausto on 4/5/16.
 */

@Order(2) // Quando colocar o security, passar para 2 e colocar o @Order(1) no security
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{
      ServiceConfig.class,
      BusinessConfiguration.class,
      DataAccessConfig.class
//      SecurityConfig.class,
//      ServiceConfig.class,
//      DatabaseConfig.class
    };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[]{WebConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
}
