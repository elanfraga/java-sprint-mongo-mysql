package com.elan.cursomc.services;

import com.elan.cursomc.domain.Cidade;
import com.elan.cursomc.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository repo;

    public List<Cidade> findByEstado(Integer estadoId){
        return repo.findCidades(estadoId);
    }
}
