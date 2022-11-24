package com.senai.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.senai.projeto.models.Usuario;
import com.senai.projeto.repositorio.UsuariosRepo;

@Controller
public class LoginController {

    @Autowired
    private UsuariosRepo repo;

    @GetMapping("/login")
    public String index(){
        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, Usuario usuParam, String lembrar){
        Usuario usu = this.repo.Login(usuParam.getId(), usuParam.getSenha());
        if(usu != null) {
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/index";
    }
}
