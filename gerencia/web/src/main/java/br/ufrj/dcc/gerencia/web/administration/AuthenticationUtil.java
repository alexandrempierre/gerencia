package br.ufrj.dcc.gerencia.web.administration;

import br.ufrj.dcc.gerencia.business.entities.UserFacade;
import org.springframework.ldap.AuthenticationException;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Created by fausto on 5/4/16.
 */

public class AuthenticationUtil {

  private class AuthorizationRegister {
    private String login;
    private String password;

    public AuthorizationRegister() {}

    public AuthorizationRegister(String login, String password) {
      this.login = login;
      this.password = password;
    }

    public String getLogin() {
      return login;
    }

    public void setLogin(String login) {
      this.login = login;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }
  }

  private UserFacade userFacade;

  public AuthenticationUtil(UserFacade userFacade) {
    this.userFacade = userFacade;
  }

  private AuthorizationRegister decodeAuthorizationHeaderHash(final String authorizationHash){
    if (authorizationHash != null && authorizationHash.startsWith("Basic")) {
      // Authorization: Basic base64credentials
      String base64Credentials = authorizationHash.substring("Basic".length()).trim();
      String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
      // credentials = username:password
      final String[] values = credentials.split(":", 2);
      return new AuthorizationRegister(values[0], values[1]);
    }
    return null;
  }

  private void authentication(AuthorizationRegister register){
    if(register != null) {
      authentication(register.getLogin(), register.getPassword());
    }else{
      throw new AuthenticationException();
    }
  }

  public void authentication(String login, String password){
    userFacade.authenticate(login,password);
  }

  public void authentication(String authorizationHashHeader){
    AuthorizationRegister authorizationRegister = decodeAuthorizationHeaderHash(authorizationHashHeader);
    authentication(authorizationRegister);
  }

}
