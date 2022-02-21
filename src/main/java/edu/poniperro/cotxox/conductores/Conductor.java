package edu.poniperro.cotxox.conductores;

import java.util.ArrayList;
import java.util.List;

public class Conductor {
    private final String nombre;
    private String modelo;
    private String matricula;
    private double valoracionMedia;
    private boolean ocupado;
    private final List<Byte> valoraciones = new ArrayList<Byte>();

    public Conductor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getValoracionMedia() {
        return valoracionMedia;
    }

    private void setValoracionMedia(double valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }

    public int getNumeroValoraciones() {
        return valoraciones.size();
    }

    public void addValoracion(byte valoracion) {
        valoraciones.add(valoracion);
        setValoracionMedia(calcularValoracionMedia());
    }

    private double calcularValoracionMedia() {
        int totalValoracion = valoraciones.stream()
                .mapToInt(valoracion -> valoracion)
                .sum();
        return (double) totalValoracion / getNumeroValoraciones();
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isOcupado() {
        return ocupado;
    }
}
