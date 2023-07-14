package br.com.banco.controllers;

import br.com.banco.models.Transferencia;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(value = "/transferencias")
public class TransferenciaController {
    @Autowired
    private TransferenciaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transferencia> findById(@PathVariable Long id) {
        Transferencia obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/buscarporconta/{idConta}")
    public ResponseEntity<List<Transferencia>> getTransferenciasByContaId(@PathVariable Long idConta) {
        List<Transferencia> obj = service.getTransferenciasByContaId(idConta);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public List<Transferencia> getTransferenciasByFilters(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate
    ) {
        if (nome != null && startDate != null && endDate != null) {
            LocalDateTime startDateTime = startDate.atStartOfDay();
            LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);
            return service.getTransferenciasByNomeAndPeriodo(nome, startDateTime, endDateTime);
        } else if (nome != null) {
            return service.getTransferenciasByNomeOperadorTransacao(nome);
        } else if (startDate != null && endDate != null) {
            LocalDateTime startDateTime = startDate.atStartOfDay();
            LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);
            return service.getTransferenciasByPeriodo(startDateTime, endDateTime);
        } else {
            return service.getAll();
        }
    }

}
