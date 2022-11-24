package com.senai.projeto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.senai.projeto.models.Material;
import com.senai.projeto.repositorio.MateriaisRepo;

@Controller
public class MateriaisController {

    @Autowired
    private MateriaisRepo repo;

    @GetMapping("/materiais")
    public String index(Model model){
        List<Material> materiais = (List<Material>)repo.findAll();
        model.addAttribute("materiais", materiais);
        return "materiais/index";
    }

    @GetMapping("/consultarRelatorio.html")
    public String consultarRelatorio(Model model){
        List<Material> materiais = (List<Material>)repo.findAll();
        model.addAttribute("materiais", materiais);
        return "relatorios/index";
    }

    @PostMapping("/materiais/cadastrar")
    public String cadastrar(Material material){
        repo.save(material);
        return "redirect:/materiaisMenu.html";
    }

    @GetMapping("/materiais/{id}")
    public String busca(@PathVariable int id, Model model){
        Optional<Material> mat = repo.findById(id);
        model.addAttribute("material", mat.get());
        return "/materiais/editar";
    }

    @PostMapping("/materiais/{id}/atualizar")
    public String atualizar(@PathVariable int id, Material material){
        if(!repo.exist( id )){
        return "redirect:/materiais";
        }
        repo.save(material);
        return "redirect:/materiais";
    }

    @GetMapping("/materiais/{id}/excluir")
    public String excluir(@PathVariable int id){
        repo.deleteById(id);
        return "redirect:/materiais";
    }
    
    @GetMapping("/materiais/{id}/procurar")
    public String procurar(@PathVariable int id, Model model){
        Optional<Material> materiais = (Optional<Material>)repo.findById(id);
        model.addAttribute("materiais", materiais);
        return "/materiais";
    }

    @PostMapping("/materiais/{id}/saida")
    public String saida(@PathVariable int id, Material material){
        repo.save(material);
        return "/saidaMaterial.html";
    }
}