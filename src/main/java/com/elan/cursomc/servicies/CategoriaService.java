package com.elan.cursomc.servicies;

import com.elan.cursomc.domain.Categoria;
import com.elan.cursomc.repositories.CategoriaRepository;
import com.elan.cursomc.servicies.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id){
        Optional<Categoria> obj =  repo.findById(id);
//        return obj.orElse(null);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
