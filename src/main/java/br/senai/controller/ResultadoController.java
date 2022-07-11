package br.senai.controller;

import br.senai.model.Funcionario;
import br.senai.model.Resultado;
import br.senai.service.FuncionarioService;
import br.senai.service.FuncionarioServiceImpl;
import br.senai.service.ProjetoServiceImpl;
import br.senai.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResultadoController {

    @Autowired
    ResultadoService resultadoService;

    @Autowired
    FuncionarioServiceImpl funcionarioService;

    @GetMapping("/resultado/list")
    public String findAll(Model model){
        model.addAttribute("resultados", resultadoService.findAll());
        return "resultado/list";
    }

    @GetMapping("/resultado/add")
    public String add(Model model){
        model.addAttribute("resultado", new Resultado());
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "resultado/add";
    }

    @GetMapping("/resultado/edit/{id}")
    public String edit(Model model, @PathVariable long id){
        model.addAttribute("resultado",resultadoService.findById(id));
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "resultado/edit";
    }

    @PostMapping("/resultado/save")
    public String save(Resultado resultado, Model model){
        try{
            Resultado saveResultado = resultadoService.save(resultado);
            model.addAttribute("resultado", resultado);
            model.addAttribute("funcionarios", funcionarioService.findAll());
            model.addAttribute("isSaved",true);
            return "resultado/add";
        } catch (Exception e){
            model.addAttribute("resultado", resultado);
            model.addAttribute("funcionarios", funcionarioService.findAll());
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());
            return "resultado/add";
        }
    }
    @GetMapping("/resultado/delete/{id}")
    public String delete(@PathVariable long id){
        try{
            resultadoService.deleteById(id);
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return "redirect:/resultado/list";
    }
}
