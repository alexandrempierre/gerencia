package br.ufrj.dcc.gerencia.application;

import br.ufrj.dcc.gerencia.web.controller.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by fausto on 4/2/16.
 */

@SpringBootApplication
@ComponentScan("br.ufrj.dcc.gerencia")
public class Application {
  public static void main(String[] args){
    HomeController controller = new HomeController();
    SpringApplication.run(Application.class, args);
  }
}

