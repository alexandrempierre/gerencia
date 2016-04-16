package br.ufrj.dcc.gerencia.business.businessObjects;

import br.ufrj.dcc.gerencia.domain.auxiliar.GerenciaDefaultConstraint;
import br.ufrj.dcc.gerencia.domain.entities.ShadowObj;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by fausto on 4/10/16.
 */

@Component
public class ShadowObjBO {

  public static ShadowObj create(boolean changePassword){
    ShadowObj shadowObj = new ShadowObj();

    shadowObj.setShadowFlag(GerenciaDefaultConstraint.SHADOW_FLAG);
    shadowObj.setShadowInactive(GerenciaDefaultConstraint.SHADOW_INACTIVE);
    shadowObj.setShadowMax(GerenciaDefaultConstraint.SHADOW_MAX);
    shadowObj.setShadowMin(GerenciaDefaultConstraint.SHADOW_MIN);
    shadowObj.setShadowWarning(GerenciaDefaultConstraint.SHADOW_WARNING);

    Calendar now = GregorianCalendar.getInstance();

    shadowObj.setShadowLastChange(changePassword ? 0 : now.getTime().getTime() /  ( 60 * 60 * 24 )); // DSE stands for Days Since Epoch

    now.add(Calendar.DAY_OF_YEAR, GerenciaDefaultConstraint.SHADOW_NUMBERS_DAY_TO_EXPIRE);
    shadowObj.setShadowExpire(now.getTime().getTime());

    return shadowObj;
  }

}
