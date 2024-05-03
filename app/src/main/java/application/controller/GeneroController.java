package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.repository.GeneroRepository;


@Controller
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
   private GeneroRepository generoRepo;

   @RequestMapping("/list")
   public String list(Model ui) {

   ui.addAttribute("generos", generoRepo.findAll());

   return "/list";
   }

   @RequestMapping("/insert")
   public String insert(){
        return "/generos/insert";
   }

   @RequestMapping(value= "/insert", method = RequestMethod.POST)
   public String insert(
      @RequestParam("nome") String nome) {

      Genero genero = new Genero();
      genero.setNome(nome);

      generoRepo.save(genero); //não sei o que esse comando faz
      
      return "redirect:/generos/list"; //redirect?
   }
}
