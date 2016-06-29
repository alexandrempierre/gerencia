package br.ufrj.dcc.gerencia.dataaccess.mapper;

import br.ufrj.dcc.gerencia.dataaccess.base.LCIUserAbstractContextMapper;
import br.ufrj.dcc.gerencia.domain.entities.Teacher;
import org.springframework.ldap.core.DirContextOperations;
import static br.ufrj.dcc.gerencia.domain.auxiliar.ObjectClassLdap.*;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/17/16.
 */

@Component
public class TeacherLdapMapper extends LCIUserAbstractContextMapper<Teacher>{
  @Override
  public void mapperResult(Teacher teacher, DirContextOperations ctx) {
    teacher.getUser().setLimitHDSpace(new Integer(ctx.getStringAttribute("cota")));
    teacher.getUser().setLogin(ctx.getStringAttribute("uid"));
    teacher.getPerson().setName(ctx.getStringAttribute("cn"));
    teacher.getPerson().setSurname(ctx.getStringAttribute("sn"));
    teacher.getPerson().setExternMail(ctx.getStringAttribute("emailExterno"));
    teacher.getPerson().setPhoneNumber(ctx.getStringAttribute("telephoneNumber"));
    teacher.getPerson().setDisplayName(ctx.getStringAttribute("displayName"));
    teacher.getServerData().setHomeDirectory(ctx.getStringAttribute("homeDirectory"));
    teacher.getServerData().setLoginShellApplication(ctx.getStringAttribute("loginShell"));
    teacher.getServerData().setGidNumber(new Integer(ctx.getStringAttribute("gidNumber")));
    teacher.getServerData().setUidNumber(new Integer(ctx.getStringAttribute("uidNumber")));
    teacher.getServerData().setGecos(ctx.getStringAttribute("gecos"));
    teacher.getSamba().setSambaSID(ctx.getStringAttribute("sambaSID"));
    teacher.getSamba().setSambaAcctFlags(ctx.getStringAttribute("sambaAcctFlags"));
    teacher.getSamba().setSambaKickoffTime(new Long(ctx.getStringAttribute("sambaKickoffTime")));
    teacher.getSamba().setSambaLMPassword(ctx.getStringAttribute("sambaLMPassword"));
    teacher.getSamba().setSambaNTPassword(ctx.getStringAttribute("sambaNTPassword"));
    teacher.getSamba().setSambaPrimaryGroupSID(ctx.getStringAttribute("sambaPrimaryGroupSID"));
    teacher.getSamba().setSambaPwdCanChange(new Long(ctx.getStringAttribute("sambaPwdCanChange")));
    teacher.getSamba().setSambaPwdLastSet(new Long(ctx.getStringAttribute("sambaPwdLastSet")));
    teacher.getSamba().setSambaPwdMustChange(new Long(ctx.getStringAttribute("sambaPwdMustChange")));
    teacher.getShadow().setShadowExpire(new Long(ctx.getStringAttribute("shadowExpire")));
    teacher.getShadow().setShadowFlag(new Integer(ctx.getStringAttribute("shadowFlag")));
    teacher.getShadow().setShadowInactive(new Integer(ctx.getStringAttribute("shadowInactive")));
    teacher.getShadow().setShadowLastChange(new Long(ctx.getStringAttribute("shadowLastChange")));
    teacher.getShadow().setShadowMax(new Integer(ctx.getStringAttribute("shadowMax")));
    teacher.getShadow().setShadowMin(new Integer(ctx.getStringAttribute("shadowMin")));
    teacher.getShadow().setShadowWarning(new Integer(ctx.getStringAttribute("shadowWarning")));
    teacher.setId(teacher.getUser().getLogin());
    teacher.getUser().setOperator(ctx.getStringAttribute("monitor").equals("1"));
  }

  @Override
  public void mapToContext(Teacher register, DirContextOperations ctx) {
    ctx.setAttributeValues("objectclass", TEACHER_OBJECT_CLASS);

    setAttributeValue("cota", ctx, Integer.toString(register.getUser().getLimitHDSpace()));
    setAttributeValue("uid", ctx, register.getUser().getLogin());
    setAttributeValue("cn", ctx, register.getPerson().getName());
    setAttributeValue("sn", ctx, register.getPerson().getSurname());
    setAttributeValue("emailExterno", ctx, register.getPerson().getExternMail());
    setAttributeValue("telephoneNumber", ctx, register.getPerson().getPhoneNumber());
    setAttributeValue("displayName", ctx, register.getPerson().getDisplayName());
    setAttributeValue("homeDirectory", ctx, register.getServerData().getHomeDirectory());
    setAttributeValue("loginShell", ctx, register.getServerData().getLoginShellApplication());
    setAttributeValue("gidNumber", ctx, Integer.toString(register.getServerData().getGidNumber()));
    setAttributeValue("uidNumber", ctx, Integer.toString(register.getServerData().getUidNumber()));
    setAttributeValue("gecos", ctx, register.getServerData().getGecos());
    setAttributeValue("sambaSID", ctx, register.getSamba().getSambaSID());
    setAttributeValue("sambaAcctFlags", ctx, register.getSamba().getSambaAcctFlags());
    setAttributeValue("sambaKickoffTime", ctx, Long.toString(register.getSamba().getSambaKickoffTime()));
    setAttributeValue("sambaLMPassword", ctx, register.getSamba().getSambaLMPassword());
    setAttributeValue("sambaNTPassword", ctx, register.getSamba().getSambaNTPassword());
    setAttributeValue("sambaPrimaryGroupSID", ctx, register.getSamba().getSambaPrimaryGroupSID());
    setAttributeValue("sambaPwdCanChange", ctx, Long.toString(register.getSamba().getSambaPwdCanChange()));
    setAttributeValue("sambaPwdLastSet", ctx, Long.toString(register.getSamba().getSambaPwdLastSet()));
    setAttributeValue("sambaPwdMustChange", ctx, Long.toString(register.getSamba().getSambaPwdMustChange()));
    setAttributeValue("shadowExpire", ctx, Long.toString(register.getShadow().getShadowExpire()));
    setAttributeValue("shadowFlag", ctx, Integer.toString(register.getShadow().getShadowFlag()));
    setAttributeValue("shadowInactive", ctx, Integer.toString(register.getShadow().getShadowInactive()));
    setAttributeValue("shadowLastChange", ctx, Long.toString(register.getShadow().getShadowLastChange()));
    setAttributeValue("shadowMax", ctx, Integer.toString(register.getShadow().getShadowMax()));
    setAttributeValue("shadowMin", ctx, Integer.toString(register.getShadow().getShadowMin()));
    setAttributeValue("shadowWarning", ctx, Integer.toString(register.getShadow().getShadowWarning()));
    setAttributeValue("userPassword", ctx, register.getUser().getPassword());
    setAttributeValue("departamento", ctx, register.getDepartment());
    setAttributeValue("monitor", ctx, register.getUser().isOperator() ? "1" : "0");
  }
}
