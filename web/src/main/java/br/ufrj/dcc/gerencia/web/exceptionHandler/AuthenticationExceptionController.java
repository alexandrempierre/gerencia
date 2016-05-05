package br.ufrj.dcc.gerencia.web.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ldap.AuthenticationException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by fausto on 5/4/16.
 */

@ControllerAdvice
public class AuthenticationExceptionController {

  private final String ERROR_MESSAGE = "Usuário não autorizado. Efetue login para prosseguir";

  @ExceptionHandler(AuthenticationException.class)
  @ResponseBody
  public ResponseEntity<String> ResponseEntityauthenticationExceptionHandler(HttpServletRequest req, Exception ex){
    MultiValueMap<String, String> header = new LinkedMultiValueMap<String,String>(1);
    header.add("WWW-Authenticate", String.format("Basic realm=\"%s\"", ERROR_MESSAGE));
    return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED.getReasonPhrase() ,header, HttpStatus.UNAUTHORIZED);
  }

}
