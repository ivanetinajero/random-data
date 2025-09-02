package dev.itinajero.app.service;

import dev.itinajero.app.dto.CsvGenerationMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CsvRandomPersonService {

    @Value("${csv.output.dir}")
    private String outputDir;

    private final Random random = new Random();

    public CsvGenerationMetadata generarCsvPersonas(Long cantidad) throws IOException {
        long start = System.currentTimeMillis();
        // Leer datos
        List<String> nombres = leerArchivo("data/nombres.txt");
        List<String> apellidos = leerArchivo("data/apellidos.txt");
        List<String> dominios = leerArchivo("data/dominios.txt");
        List<String> profesiones = leerArchivo("data/profesiones.txt");
        List<String> paises = leerArchivo("data/paises.txt");

        // Generar nombre de archivo
        String fileName = generarNombreArchivo();
        String filePath = outputDir + File.separator + fileName;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Nombre,Apellido,Email,Edad,Profesion,Salario,Pais");
            writer.newLine();
            for (long i = 0; i < cantidad; i++) {
                String nombre = randomDeLista(nombres);
                String apellido = randomDeLista(apellidos);
                String profesion = randomDeLista(profesiones);
                int edad = random.nextInt(43) + 18; // 18-60 años
                int salario = generarSalario();
                String email = generarEmail(nombre, apellido, dominios);
                String pais = randomDeLista(paises);
                writer.write(
                        String.format("%s,%s,%s,%d,%s,%d,%s", nombre, apellido, email, edad, profesion, salario, pais));
                writer.newLine();
            }
        }
        long end = System.currentTimeMillis();
        return new CsvGenerationMetadata(fileName, cantidad, end - start);
    }

    private List<String> leerArchivo(String path) throws IOException {
        return Files.readAllLines(Paths.get(path)).stream()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    private String randomDeLista(List<String> lista) {
        return lista.get(random.nextInt(lista.size()));
    }

    private String generarNombreArchivo() {
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        String fechaHora = now.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmm"));
        String randomStr = random.ints(48, 123)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(5)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return fechaHora + "-" + randomStr + ".csv";
    }

    private String generarEmail(String nombre, String apellido, List<String> dominios) {
        String n = nombre.toLowerCase().replaceAll("\\s+", "");
        String a = apellido.toLowerCase().replaceAll("\\s+", "");
        String dominio = randomDeLista(dominios);
        int tipo = random.nextInt(11);
        String username;
        int num = random.nextInt(10, 100); // número de 2 dígitos
        switch (tipo) {
            case 0:
                username = n + "." + a; // nombre.apellido
                break;
            case 1:
                username = n.charAt(0) + "." + a; // inicialNombre.apellido
                break;
            case 2:
                username = n + "." + a.charAt(0); // nombre.inicialApellido
                break;
            case 3:
                username = n + a; // nombreapellido
                break;
            case 4:
                username = a + "." + n; // apellido.nombre
                break;
            case 5:
                username = n + "_" + a; // nombre_apellido
                break;
            case 6:
                username = n + num; // nombre + número
                break;
            case 7:
                username = a + num; // apellido + número
                break;
            case 8:
                username = n.charAt(0) + a; // inicialNombreapellido
                break;
            case 9:
                username = n + a.charAt(0) + num; // nombre + inicialApellido + número
                break;
            case 10:
                username = n.charAt(0) + a + num; // inicialNombre + apellido + número
                break;
            default:
                username = n + a; // fallback
        }
        return username + "@" + dominio;
    }

    private int generarSalario() {
        int base = (random.nextInt(50) + 20) * 100; // 2000 - 6900
        int decenas = (random.nextInt(10)) * 10; // 0, 10, ..., 90
        return base + decenas;
    }

    // ...
}
