package com.elan.cursomc.services;

import com.elan.cursomc.domain.Cidade;
import com.elan.cursomc.domain.Cliente;
import com.elan.cursomc.domain.Endereco;
import com.elan.cursomc.domain.enums.Perfil;
import com.elan.cursomc.domain.enums.TipoCliente;
import com.elan.cursomc.dto.ClienteDTO;
import com.elan.cursomc.dto.ClienteNewDTO;
import com.elan.cursomc.repositories.ClienteRepository;
import com.elan.cursomc.repositories.EnderecoRepository;
import com.elan.cursomc.security.UserSS;
import com.elan.cursomc.services.exceptions.AutorizationException;
import com.elan.cursomc.services.exceptions.DataIntegrityException;
import com.elan.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repo;
    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    public Cliente find(Integer id){

        UserSS user  = UserService.autenticated();
        if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())){
            throw new AutorizationException("Acesso negado");
        }

        Optional<Cliente> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

    }

    @Transactional
    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj = repo.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }

    public Cliente update(Cliente obj) {
        Cliente newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível cliente com pedidos");
        }
    }

    public List<Cliente> findAll() {
        return repo.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDto){
        return  new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null, null);
    }

    public Cliente fromDTO(ClienteNewDTO objDto){
        Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()), pe.encode(objDto.getSenha()));
        Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
        Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
        cli.getEnderecos().add(end);
        cli.getTelefones().add(objDto.getTelefone1());
        if (objDto.getTelefone2()!=null) {
            cli.getTelefones().add(objDto.getTelefone2());
        }
        if (objDto.getTelefone3()!=null) {
            cli.getTelefones().add(objDto.getTelefone3());

        }

        return cli;

    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }
}