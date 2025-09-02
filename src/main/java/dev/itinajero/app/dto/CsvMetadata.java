package dev.itinajero.app.dto;

public class CsvMetadata {

    private String archivo;
    private long totalRegistros;
    private long tiempoGeneracionMs;
    private long tamanoArchivoBytes;

    public CsvMetadata(String archivo, long totalRegistros, long tiempoGeneracionMs, long tamanoArchivoBytes) {
        this.archivo = archivo;
        this.totalRegistros = totalRegistros;
        this.tiempoGeneracionMs = tiempoGeneracionMs;
        this.tamanoArchivoBytes = tamanoArchivoBytes;
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

    public long getTamanoArchivoBytes() {
        return tamanoArchivoBytes;
    }

    public void setTamanoArchivoBytes(long tamanoArchivoBytes) {
        this.tamanoArchivoBytes = tamanoArchivoBytes;
    }

    public String getTamanoArchivoAmigable() {
        long bytes = tamanoArchivoBytes;
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        String pre = "KMGTPE".charAt(exp - 1) + "B";
        return String.format("%.2f %s", bytes / Math.pow(1024, exp), pre);
    }

}
