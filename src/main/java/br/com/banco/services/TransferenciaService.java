package br.com.banco.services;

import br.com.banco.models.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public List<Transferencia> getTransferenciasByContaId(Long id){
        return repo.getTransferenciasByContaId(id);
    }


    public List<Transferencia> getTransferenciasByNomeOperadorTransacao(String nomeOperadorTransacao) {
        return repo.findAllByNomeOperadorTransacao(nomeOperadorTransacao);
    }

    public List<Transferencia> getTransferenciasByPeriodo(LocalDateTime startDate, LocalDateTime endDate) {
        return repo.findAllByDataTransferenciaBetween(startDate, endDate);
    }

    public List<Transferencia> getTransferenciasByNomeAndPeriodo(String nome, LocalDateTime startDate, LocalDateTime endDate) {
        return repo.findAllByNomeAndDataTransferenciaBetween(nome, startDate, endDate);
    }
}
