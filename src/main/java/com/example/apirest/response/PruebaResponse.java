package com.example.apirest.response;

public class PruebaResponse {
    private String codigo;
    private String mensaje;

    public PruebaResponse(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "PruebaResponse{" +
                "codigo='" + codigo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
