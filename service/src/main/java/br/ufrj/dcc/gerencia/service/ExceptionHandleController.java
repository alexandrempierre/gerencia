package br.ufrj.dcc.gerencia.service;

import br.ufrj.dcc.gerencia.domain.entities.Example;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fausto on 4/8/16.
 */

@ControllerAdvice
public class ExceptionHandleController {

  @ExceptionHandler(NullPointerException.class)
  public @ResponseBody Integer NullPointerExceptionHandler(){
    return 0;
  }

}
