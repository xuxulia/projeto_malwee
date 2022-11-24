package com.senai.projeto.repositorio;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.senai.projeto.models.Material;

public interface MateriaisRepo extends CrudRepository<Material, Integer> {
    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END from materiais where id = :id", nativeQuery = true)
    public boolean exist(int id);

    @Query(value="select * from materiais where id = :id", nativeQuery = true)
    public boolean existe(int id);
}
