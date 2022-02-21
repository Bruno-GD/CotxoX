package edu.poniperro.cotxox.carrera;

import edu.poniperro.cotxox.tarifas.Tarifa;
import edu.poniperro.cotxox.conductores.Conductor;
import edu.poniperro.cotxox.conductores.PoolConductores;

import java.util.Optional;

public class Carrera {
    private final String tarjetaCredito;
    private String origen;
    private String destino;
    private double distancia;
    private int tiempoEsperado;
    private int tiempoCarrera;
    private double costeTotal;
    private int propina;
    private Conductor conductor;

    public Carrera(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getCosteEsperado() {
        return Tarifa.getCosteTotalEsperado(this);
    }

    public int getTiempoEsperado() {
        return tiempoEsperado;
    }

    public void setTiempoEsperado(int tiempoEsperado) {
        this.tiempoEsperado = tiempoEsperado;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public void realizarPago(double costeTotal) {
        this.costeTotal = costeTotal;
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public void recibirPropina(int propina) {
        this.propina = propina;
    }

    public int getPropina() {
        return propina;
    }

    public void liberarConductor() {
        getConductor().setOcupado(false);
    }

    public void asignarConductor(PoolConductores conductores) {
        Optional<Conductor> conductor = conductores.asignarConductor();
        conductor.ifPresent(this::setConductor);
    }
}
