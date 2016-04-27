//package br.ufrj.dcc.gerencia.web.configuration;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.stereotype.Component;
//
///**
// * Created by fausto on 4/26/16.
// */
//
//@Component
//public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
//
//  @Override
//  public void init(AuthenticationManagerBuilder auth) throws Exception {
//    auth
//      .ldapAuthentication()
//      .userSearchFilter("(&(uid={0})(monitor=1))")
//      .groupSearchBase("ou=usuarios,dc=dcc,dc=ufrj,dc=br")
//      .contextSource()
//        .managerDn("cn=root,dc=dcc,dc=ufrj,dc=br")
//        .managerPassword("senha")
//        .url("ldap://localhost:389/");
//  }
//}