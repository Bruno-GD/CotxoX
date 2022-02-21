package edu.poniperro.cotxox.tarifas;

import edu.poniperro.cotxox.carrera.Carrera;

public class Tarifa {
    final static double COSTE_MILLA = 1.35;
    final static double COSTE_MINUTO = 0.35;
    final static double COSTE_MINIMO = 5.0;

    public static double getCosteDistancia(double distancia) {
        return distancia * COSTE_MILLA;
    }

    public static double getCosteTiempo(double minutos) {
        return minutos * COSTE_MINUTO;
    }

    public static double getCosteTotalEsperado(Carrera carrera) {
        double costeTotal = getCosteDistancia(carrera.getDistancia()) + getCosteTiempo(carrera.getTiempoEsperado());
        return Math.max(costeTotal, COSTE_MINIMO);
    }
}
