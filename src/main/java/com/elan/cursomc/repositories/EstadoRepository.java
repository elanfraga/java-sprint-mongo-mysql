package com.elan.cursomc.repositories;

import com.elan.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    public List<Estado>  findAllByOrderByNome();
}
