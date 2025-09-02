package edu.dows.lab.agilismo.Reto3;

public class HistoriaUsuario {
    private final String id;
    private final String descripcion;
    private int estimacionFinal = -1;

    public HistoriaUsuario(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEstimacionFinal() {
        return estimacionFinal;
    }

    public void setEstimacionFinal(int estimacionFinal) {
        this.estimacionFinal = estimacionFinal;
    }

    @Override
    public String toString() {
        return id + " - " + descripcion + " -> " + (estimacionFinal >= 0 ? estimacionFinal + " puntos" : "Sin estimar");
    }


}
