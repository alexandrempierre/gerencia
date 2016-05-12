package br.ufrj.dcc.gerencia.domain.to;

/**
 * Created by fausto on 5/5/16.
 */
public class ExceptionTO {
  private Exception ex;
  private String message;

  public ExceptionTO(Exception ex, String message) {
    this.ex = ex;
    this.message = message;
  }

  public ExceptionTO() {
  }

  public Exception getEx() {
    return ex;
  }

  public void setEx(Exception ex) {
    this.ex = ex;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
