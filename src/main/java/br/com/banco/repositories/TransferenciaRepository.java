package br.com.banco.repositories;

import br.com.banco.models.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query(value = "SELECT * FROM TRANSFERENCIA WHERE CONTA_ID = ?1", nativeQuery = true)
    List<Transferencia> getTransferenciasByContaId(Long id);
}
