package dev.itinajero.app.dto;

public record CsvMetadata(String archivo, long totalRegistros, long tiempoGeneracionMs, long tamanoArchivoBytes) {

    public String getTamanoArchivoAmigable() {
        long bytes = tamanoArchivoBytes;
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        String pre = "KMGTPE".charAt(exp - 1) + "B";
        return String.format("%.2f %s", bytes / Math.pow(1024, exp), pre);
    }
    
}
