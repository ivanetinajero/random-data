package dev.itinajero.app.dto;

public class CsvGenerationMetadata {
    
    private String archivo;
    private long totalRegistros;
    private long tiempoGeneracionMs;

    public CsvGenerationMetadata(String archivo, long totalRegistros, long tiempoGeneracionMs) {
        this.archivo = archivo;
        this.totalRegistros = totalRegistros;
        this.tiempoGeneracionMs = tiempoGeneracionMs;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public long getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(long totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    public long getTiempoGeneracionMs() {
        return tiempoGeneracionMs;
    }

    public void setTiempoGeneracionMs(long tiempoGeneracionMs) {
        this.tiempoGeneracionMs = tiempoGeneracionMs;
    }

}
