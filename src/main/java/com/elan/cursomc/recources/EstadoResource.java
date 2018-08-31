package com.elan.cursomc.recources;

import com.elan.cursomc.domain.Cidade;
import com.elan.cursomc.domain.Estado;
import com.elan.cursomc.dto.CidadeDTO;
import com.elan.cursomc.dto.EstadoDTO;
import com.elan.cursomc.services.CidadeService;
import com.elan.cursomc.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

    @Autowired
    EstadoService service;

    @Autowired
    CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> findAll(){
        List<Estado> list = service.findAll();
        List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/estados/{estado_id}/cidades)")
    public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoid){
        List<Cidade> list = cidadeService.findByEstado(estadoid);
        List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);

    }


}
