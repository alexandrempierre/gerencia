package br.ufrj.dcc.gerencia.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fausto on 4/2/16.
 */

@Controller
public class HomeController {

  @RequestMapping("/")
  public String greeting() {
    return "index";
  }

}