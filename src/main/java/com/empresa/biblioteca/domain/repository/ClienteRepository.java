package com.empresa.biblioteca.domain.repository;

import com.empresa.biblioteca.domain.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    ClienteModel findById(long id);

}
