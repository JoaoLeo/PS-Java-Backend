package br.com.banco.controllers;

import br.com.banco.models.Transferencia;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/transferencias")
public class TransferenciaController {
    @Autowired
    private TransferenciaService service;

    @GetMapping
    public ResponseEntity<List<Transferencia>> getAll() {
        List<Transferencia> Transferencias = service.getAll();
        return ResponseEntity.ok().body(Transferencias);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transferencia> findById(@PathVariable Long id) {
        Transferencia obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
