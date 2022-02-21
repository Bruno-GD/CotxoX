package edu.poniperro.cotxox.conductores;

import java.util.List;
import java.util.Optional;

public class PoolConductores {
    private final List<Conductor> poolConductores;

    public PoolConductores(List<Conductor> conductores) {
        poolConductores = conductores;
    }

    public List<Conductor> getPoolConductores() {
        return poolConductores;
    }

    public Optional<Conductor> asignarConductor() {
        Optional<Conductor> any = getPoolConductores().stream()
                .filter(conductor -> !conductor.isOcupado())
                .findAny();
        any.ifPresent(conductor -> conductor.setOcupado(true));
        return any;
    }
}
