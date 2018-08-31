package com.elan.cursomc.services;

import com.elan.cursomc.domain.Estado;
import com.elan.cursomc.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository repo;

    public List<Estado> findAll(){
        return repo.findAllByOrderByNome();
    }
}
