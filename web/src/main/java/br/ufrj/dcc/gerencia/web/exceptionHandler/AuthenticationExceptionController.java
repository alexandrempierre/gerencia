package br.ufrj.dcc.gerencia.web.exceptionHandler;

import br.ufrj.dcc.gerencia.domain.to.ExceptionTO;
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
  public ResponseEntity<ExceptionTO> ResponseEntityauthenticationExceptionHandler(HttpServletRequest req, Exception ex){
    ExceptionTO exceptionTO = new ExceptionTO(null, HttpStatus.UNAUTHORIZED.getReasonPhrase());
    String ajaxSending = req.getHeader("X-Requested-With");
    if(ajaxSending != null && !ajaxSending.equals("XMLHttpRequest")){
      MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>(1);
      header.add("WWW-Authenticate", String.format("Basic realm=\"%s\"", ERROR_MESSAGE));
      return new ResponseEntity<ExceptionTO>(exceptionTO, header, HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<ExceptionTO>(exceptionTO , HttpStatus.UNAUTHORIZED);
  }

}
