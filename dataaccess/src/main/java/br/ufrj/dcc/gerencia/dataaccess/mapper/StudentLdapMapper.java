package br.ufrj.dcc.gerencia.dataaccess.mapper;

import br.ufrj.dcc.gerencia.dataaccess.base.LCIAbstractContextMapper;
import br.ufrj.dcc.gerencia.domain.entities.Student;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/10/16.
 */

@Component
public class StudentLdapMapper extends LCIAbstractContextMapper<Student> {

  @Override
  public void mapperResult(Student student,DirContextOperations ctx) {
    student.getUser().setLimitHDSpace(new Integer(ctx.getStringAttribute("cota")));
    student.getUser().setLogin(ctx.getStringAttribute("uid"));
    student.getUser().setMail(ctx.getStringAttribute("mail"));
    student.getPerson().setName(ctx.getStringAttribute("cn"));
    student.getPerson().setSurname(ctx.getStringAttribute("sn"));
    student.getPerson().setExternMail(ctx.getStringAttribute("emailExterno"));
    student.getPerson().setPhoneNumber(ctx.getStringAttribute("telephoneNumber"));
    student.getPerson().setDisplayName(ctx.getStringAttribute("displayName"));
    student.getServerData().setHomeDirectory(ctx.getStringAttribute("homeDirectory"));
    student.getServerData().setLoginShellApplication(ctx.getStringAttribute("loginShell"));
    student.getServerData().setGidNumber(new Integer(ctx.getStringAttribute("gidNumber")));
    student.getServerData().setUidNumber(new Integer(ctx.getStringAttribute("uidNumber")));
    student.getServerData().setGecos(ctx.getStringAttribute("gecos"));
    student.getSamba().setSambaSID(ctx.getStringAttribute("sambaSID"));
    student.getSamba().setSambaAcctFlags(ctx.getStringAttribute("sambaAcctFlags"));
    student.getSamba().setSambaKickoffTime(ctx.getStringAttribute("sambaKickoffTime"));
    student.getSamba().setSambaLMPassword(ctx.getStringAttribute("sambaLMPassword"));
    student.getSamba().setSambaNTPassword(ctx.getStringAttribute("sambaNTPassword"));
    student.getSamba().setSambaPrimaryGroupSID(ctx.getStringAttribute("sambaPrimaryGroupSID"));
    student.getSamba().setSambaPwdCanChange(ctx.getStringAttribute("sambaPwdCanChange"));
    student.getSamba().setSambaPwdLastSet(ctx.getStringAttribute("sambaPwdLastSet"));
    student.getSamba().setSambaPwdMustChange(ctx.getStringAttribute("sambaPwdMustChange"));
    student.getShadow().setShadowExpire(new Integer(ctx.getStringAttribute("shadowExpire")));
    student.getShadow().setShadowFlag(new Integer(ctx.getStringAttribute("shadowFlag")));
    student.getShadow().setShadowInactive(new Integer(ctx.getStringAttribute("shadowInactive")));
    student.getShadow().setShadowLastChange(new Integer(ctx.getStringAttribute("shadowLastChange")));
    student.getShadow().setShadowMax(new Integer(ctx.getStringAttribute("shadowMax")));
    student.getShadow().setShadowMin(new Integer(ctx.getStringAttribute("shadowMin")));
    student.getShadow().setShadowWarning(new Integer(ctx.getStringAttribute("shadowWarning")));

    student.setId(student.getUser().getLogin());
    student.setDRE(ctx.getStringAttribute("DRE"));
    student.setOperator(ctx.getStringAttribute("monitor").equals("1"));
  }


}
