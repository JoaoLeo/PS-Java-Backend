package br.com.banco.models.enums;

public enum TipoEnum {
    DEPOSITO("DEPOSITO"),
    SAQUE("SAQUE"),
    TRANSFERENCIA("TRANSFERENCIA");

    private String valor;

    TipoEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
