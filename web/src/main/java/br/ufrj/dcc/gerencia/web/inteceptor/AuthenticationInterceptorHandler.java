package br.ufrj.dcc.gerencia.web.inteceptor;

import br.ufrj.dcc.gerencia.web.administration.AuthenticationUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fausto on 5/4/16.
 */

@Component
public class AuthenticationInterceptorHandler extends HandlerInterceptorAdapter {

  private AuthenticationUtil authenticationUtil;

  public AuthenticationInterceptorHandler(AuthenticationUtil authenticationUtil) {
    this.authenticationUtil = authenticationUtil;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    authenticationUtil.authentication(request.getHeader("Authorization"));
    return true;
  }

}
