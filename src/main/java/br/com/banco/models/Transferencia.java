package br.com.banco.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_transferencia", nullable = false)
    private LocalDateTime dataTransferencia;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "nome_operador_transacao")
    private String nome_operador_transacao;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta_id;

    public Transferencia() {
    }

    public Transferencia(Long id, LocalDateTime dataTransferencia, BigDecimal valor, String tipo, String nome_operador_transacao, Conta conta_id) {
        this.id = id;
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nome_operador_transacao = nome_operador_transacao;
        this.conta_id = conta_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDateTime dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome_operador_transacao() {
        return nome_operador_transacao;
    }

    public void setNome_operador_transacao(String nome_operador_transacao) {
        this.nome_operador_transacao = nome_operador_transacao;
    }

    public Conta getConta_id() {
        return conta_id;
    }

    public void setConta_id(Conta conta_id) {
        this.conta_id = conta_id;
    }
}
