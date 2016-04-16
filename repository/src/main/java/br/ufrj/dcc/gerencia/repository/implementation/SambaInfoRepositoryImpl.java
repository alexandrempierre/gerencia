package br.ufrj.dcc.gerencia.repository.implementation;

import br.ufrj.dcc.gerencia.dataaccess.entities.SambaInfoLDAPDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.mapper.SambaInfoLdapMapper;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.entities.SambaInfo;
import br.ufrj.dcc.gerencia.repository.base.RepositoryImpl;
import br.ufrj.dcc.gerencia.repository.contract.SambaInfoRepository;

/**
 * Created by fausto on 4/14/16.
 */
public class SambaInfoRepositoryImpl
  extends RepositoryImpl<SambaInfo, SambaInfoLdapMapper, SambaInfoLDAPDataAccess, LciLdapSpecification>
  implements SambaInfoRepository {

}
