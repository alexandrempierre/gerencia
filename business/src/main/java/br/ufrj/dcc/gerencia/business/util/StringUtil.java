package br.ufrj.dcc.gerencia.business.util;

import java.text.Normalizer;

/**
 * Created by fausto on 4/10/16.
 */
public class StringUtil {

  public static String removeAccent(String str){
    str = Normalizer.normalize(str, Normalizer.Form.NFD);
    str = str.replaceAll("[^\\p{ASCII}]", "");
    return str;
  }

}
