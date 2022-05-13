package com.empresa.biblioteca.domain.repository;

import com.empresa.biblioteca.domain.models.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {

    @Query(nativeQuery = true, value = "SELECT f.cep, count(f.cep) FROM tb_funcionario f group by f.cep order by 2 desc")
    List<Object> listarconsultas();

    @Query(value = "SELECT u from FuncionarioModel u")
    List<FuncionarioModel> listarfuncionarios();

}