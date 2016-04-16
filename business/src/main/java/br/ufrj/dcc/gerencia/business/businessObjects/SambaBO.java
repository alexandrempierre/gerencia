package br.ufrj.dcc.gerencia.business.businessObjects;

import br.ufrj.dcc.gerencia.business.entities.SambaInfoFacade;
import br.ufrj.dcc.gerencia.business.util.PasswordUtil;
import br.ufrj.dcc.gerencia.domain.auxiliar.GerenciaDefaultConstraint;
import br.ufrj.dcc.gerencia.domain.entities.SambaInfo;
import br.ufrj.dcc.gerencia.domain.entities.SambaObj;
import br.ufrj.dcc.gerencia.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.GregorianCalendar;

/**
 * Created by fausto on 4/10/16.
 */

@Component
public class SambaBO {

  @Autowired
  private SambaInfoFacade sambaInfoFacade;

  public SambaObj create(User user, boolean changePassword){
    SambaObj sambaObj = new SambaObj();
    SambaInfo sambaInfo = sambaInfoFacade.getStats();
    Long timeNow = GregorianCalendar.getInstance().getTime().getTime();

    sambaObj.setSambaInfo(sambaInfo);
    sambaObj.setSambaAcctFlags(GerenciaDefaultConstraint.SAMBA_ACCT_FLAGS);
    sambaObj.setSambaPwdCanChange(timeNow);
    sambaObj.setSambaPwdLastSet(timeNow);
    sambaObj.setSambaKickoffTime(timeNow+3*31+15); // a conta é legada do gerencia antigo: 3 meses e 15 dias
    sambaObj.setSambaNTPassword(PasswordUtil.ntPasswordHash(user.getPassword()));
    sambaObj.setSambaLMPassword(PasswordUtil.lmPasswordHash(user.getPassword()));
    sambaObj.setSambaSID(sambaInfo.getSambaSID(), sambaInfo.getSambaNextRid());
    sambaObj.setSambaPrimaryGroupSID(String.format(GerenciaDefaultConstraint.SAMBA_PRIMARY_GROUP_SID_TEMPLATE, sambaInfo.getSambaSID()));

    sambaObj.setSambaPwdMustChange(changePassword ? 0 : timeNow + GerenciaDefaultConstraint.SAMBA_PWD_MUST_CHANGE);

    return sambaObj;
  }
}
