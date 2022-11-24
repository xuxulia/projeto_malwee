package com.senai.projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.senai.projeto.models.Usuario;
import com.senai.projeto.repositorio.UsuariosRepo;

@Controller
public class UsuariosController {

    @Autowired
    private UsuariosRepo repo;

    @GetMapping("/relatorioUsuarios.html")
    public String relatorioUsuarios(Model model){
        List<Usuario> usuarios = (List<Usuario>)repo.findAll();
        model.addAttribute("usuarios", usuarios);
        return "/relatorios/relatorioUsuarios";
    }

    @GetMapping("/usuarios")
    public String index(Model model){
        List<Usuario> usuarios = (List<Usuario>)repo.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/index";
    }

    @PostMapping("/usuarios/cadastrar")
    public String cadastrar(Usuario usuario){
        repo.save(usuario);
        return "redirect:/telaLogin.html";
    }
}
