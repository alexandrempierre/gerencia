package br.ufrj.dcc.gerencia.domain.base;

/**
 * Created by fausto on 4/5/16.
 */
public abstract class LciSpecification<TReturn> {

  public abstract TReturn toSpecification();

}
