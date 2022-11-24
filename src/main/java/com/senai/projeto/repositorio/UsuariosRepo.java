package com.senai.projeto.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.senai.projeto.models.Usuario;

public interface UsuariosRepo extends CrudRepository<Usuario, Integer> {
    @Query(value="select * from usuarios where id = :id AND senha = :senha", nativeQuery = true)
    public Usuario Login(int id, String senha);

    @Query(value="select * from usuarios where id = :id", nativeQuery = true)
    public boolean existe(int id);
}
