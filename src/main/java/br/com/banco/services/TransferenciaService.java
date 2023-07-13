package br.com.banco.services;

import br.com.banco.models.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.services.exceptions.DatabaseException;
import br.com.banco.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService {
    @Autowired
    private TransferenciaRepository repo;
    public List<Transferencia> getAll() {
        return repo.findAll();
    }

    public Transferencia findById(Long id) {
        Optional<Transferencia> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
