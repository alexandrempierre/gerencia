package br.ufrj.dcc.gerencia.application.configuration;

import br.ufrj.dcc.gerencia.web.configuration.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by fausto on 4/2/16.
 */


public class GerenciaWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { RootConfig.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { WebConfig.class };
  }
}
