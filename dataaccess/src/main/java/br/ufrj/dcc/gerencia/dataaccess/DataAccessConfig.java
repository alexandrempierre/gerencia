package br.ufrj.dcc.gerencia.dataaccess;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

/**
 * Created by fausto on 4/7/16.
 */

@Configuration
@PropertySource("classpath:ldap.yml")
public class DataAccessConfig {

  @Value("${sample.ldap.url}")
  private String url;
  @Value("${sample.ldap.userDn}")
  private String userDn;
  @Value("${sample.ldap.password}")
  private String password;
  @Value("${sample.ldap.base}")
  private String base;

  @Bean
  public LdapContextSource ldapContextSource(){
    LdapContextSource ldapContextSource = new LdapContextSource();
    ldapContextSource.setUrl(url);
    ldapContextSource.setUserDn(userDn);
    ldapContextSource.setPassword(password);
    ldapContextSource.setBase(base);
    return ldapContextSource;
  }

  @Bean
  public LdapTemplate ldapTemplate(){
    return new LdapTemplate(ldapContextSource());
  }

}
