package br.com.banco.services;

import br.com.banco.models.Conta;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.services.exceptions.DatabaseException;
import br.com.banco.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repo;
    public List<Conta> getAll() {
        return repo.findAll();
    }

    public Conta findById(Long id) {
        Optional<Conta> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Conta insert(Conta obj){
        return repo.save(obj);
    }

    public void delete(Long id){
        try {
            if(repo.existsById(id)) {
                repo.deleteById(id);
            }
            else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException err){
            throw new DatabaseException(err.getMessage());
        }

    }
    public Conta update(Long id, Conta obj){
        try {
            Conta entity = repo.getById(id);
            entity.setNomeResponsavel(obj.getNomeResponsavel());
            return repo.save(entity);
        } catch (EntityNotFoundException err){
            throw new ResourceNotFoundException(err);
        }

    }
}
