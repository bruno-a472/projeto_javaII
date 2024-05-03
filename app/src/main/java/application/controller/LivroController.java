package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "/livros/insert";
   }

   @RequestMapping(value= "/insert", method = RequestMethod.POST)
   public String insert(
      @RequestParam("titulo") String titulo,
      @RequestParam("genero") String genero) {

      Livro livro = new Livro();
      livro.setTitulo(titulo);
      livro.getGenero().setNome(genero);

      livroRepo.save(livro); //não sei o que esse comando faz
      
      return "redirect:/livros/list"; //redirect?
   }

   @RequestMapping("/update/{id}")
   public String update(Model ui, @PathVariable long id) {
      Optional<Livro> resultado = livroRepo.findById(id);
      
      if (resultado.isPresent()){
         ui.addAttribute("livro", resultado.get());
         return "/livros/update";
      }
      
      return "redirect:/livros/list";
   }
   
   @RequestMapping(value = "/update", method = RequestMethod.POST)
   public String update(
      @RequestParam("id") long id, 
      @RequestParam("titulo") String titulo, 
      @RequestParam("genero") String genero) {

      Optional<Livro> resultado = livroRepo.findById(id);

      if(resultado.isPresent()) {
         resultado.get().setTitulo(titulo);
         resultado.get().getGenero().setNome(genero);
      }

      livroRepo.save(resultado.get());

      return "redirect:/livros/list";
   }
    
   
   @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
   public String delete(Model ui, @RequestParam("id") long id) {

      Optional<Livro> resultado = livroRepo.findById(id);

      if(resultado.isPresent()) {
         ui.addAttribute("livro", resultado.get());
         
         return "/livros/delete";
      }

      return "redirect:/livros/list";
   }

   @RequestMapping(value = "/delete", method = RequestMethod.POST)
   public String delete(@RequestParam("id") long id) {
      livroRepo.deleteById(id);
      
      return "redirect:/livros/list";
   }
}