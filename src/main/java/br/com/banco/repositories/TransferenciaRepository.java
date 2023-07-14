package br.com.banco.repositories;

import br.com.banco.models.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query(value = "SELECT * FROM TRANSFERENCIA WHERE CONTA_ID = ?1", nativeQuery = true)
    List<Transferencia> getTransferenciasByContaId(Long id);

    @Query(value = "SELECT * FROM TRANSFERENCIA WHERE nome_operador_transacao LIKE %?1%", nativeQuery = true)
    List<Transferencia> findAllByNomeOperadorTransacao(String nomeOperadorTransacao);

    @Query(value = "SELECT * FROM transferencia WHERE data_transferencia BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Transferencia> findAllByDataTransferenciaBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query(value = "SELECT * FROM transferencia WHERE nome_operador_transacao LIKE %?1% AND data_transferencia BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Transferencia> findAllByNomeAndDataTransferenciaBetween(String nome, LocalDateTime startDate, LocalDateTime endDate);
}
