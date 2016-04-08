package br.ufrj.dcc.gerencia.contract.entities;

import br.ufrj.dcc.gerencia.contract.base.CrudRestAPIContract;
import br.ufrj.dcc.gerencia.domain.entities.Example;
import br.ufrj.dcc.gerencia.domain.specification.ExampleSpecification;
import br.ufrj.dcc.gerencia.domain.vo.ExampleVO;

/**
 * Created by fausto on 4/4/16.
 */
public interface ExampleContract extends CrudRestAPIContract<ExampleVO,ExampleSpecification>{
}
