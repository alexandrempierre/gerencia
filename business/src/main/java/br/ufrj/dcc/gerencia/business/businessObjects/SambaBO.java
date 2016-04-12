package br.ufrj.dcc.gerencia.business.businessObjects;

import br.ufrj.dcc.gerencia.business.util.PasswordUtil;
import br.ufrj.dcc.gerencia.domain.auxiliar.GerenciaDefaultConstraint;
import br.ufrj.dcc.gerencia.domain.entities.SambaObj;
import br.ufrj.dcc.gerencia.domain.entities.User;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.GregorianCalendar;

/**
 * Created by fausto on 4/10/16.
 */

@Component
public class SambaBO {

  public static SambaObj create(User user){
    Long timeNow = GregorianCalendar.getInstance().getTime().getTime();
    SambaObj sambaObj = new SambaObj();

    sambaObj.setSambaAcctFlags(GerenciaDefaultConstraint.SAMBA_ACCT_FLAGS);
    sambaObj.setSambaPwdCanChange(timeNow);
    sambaObj.setSambaPwdLastSet(timeNow);
    sambaObj.setSambaKickoffTime(timeNow+3*31+15); // a conta é legada do gerencia antigo: 3 meses e 15 dias
    sambaObj.setSambaNTPassword(PasswordUtil.ntPasswordHash(user.getPassword()));
    sambaObj.setSambaLMPassword(PasswordUtil.lmPasswordHash(user.getPassword()));

    //TODO: sambaObj.setSambaSID();
    //TODO: sambaObj.setSambaPrimaryGroupSID();



    return sambaObj;
  }

}
