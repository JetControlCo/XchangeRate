package service;

public enum Moneda {
    USD("USD"),
    ARS("ARS"),
    BRL("BRL"),
    COP("COP"),
    MXN("MXN");

    private final String codigo;

    Moneda(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return codigo;
    }
}