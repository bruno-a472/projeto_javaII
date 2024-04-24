package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Livro;
import application.repository.LivroRepository;

@Controller
@RequestMapping("/livros")
public class LivroController {
   @Autowired
   private LivroRepository livroRepo;

   @RequestMapping("/list")
   public String list(Model ui) {

   ui.addAttribute("livros", livroRepo.findAll());

   return "/livros/list";
   }


   @RequestMapping("/insert")
   public String insert(){
        return"/livros/insert";
   }

   @RequestMapping(value= "/insert", method = RequestMethod.POST)
   public String insert(
      @RequestParam("titulo") String titulo,
      @RequestParam("genero") String genero) {

      Livro livro = new Livro();
      livro.setTitulo(titulo);
      livro.setGenero(genero);

      livroRepo.save(livro);
      
      return "redirect:/livros/list";
   }


   
     
     
}