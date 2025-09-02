package dev.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.itinajero.app.dto.CsvMetadata;
import dev.itinajero.app.service.CsvRandomPersonService;

@RestController
@RequestMapping("/api/csv")
public class CsvRandomPersonController {

    @Autowired
    private CsvRandomPersonService csvRandomPersonService;

    @PostMapping("/personas")
    public CsvMetadata generarCsv(@RequestParam(defaultValue = "100000") Long cantidad) throws Exception {
        return csvRandomPersonService.generarCsvPersonas(cantidad);
    }

    @GetMapping("/descargar/{archivo}")
    public org.springframework.http.ResponseEntity<org.springframework.core.io.Resource> descargarCsv(@PathVariable String archivo) throws Exception {
        java.nio.file.Path path = java.nio.file.Paths.get(System.getProperty("user.dir"), "csv", archivo);
        org.springframework.core.io.Resource resource = new org.springframework.core.io.UrlResource(path.toUri());
        if (!resource.exists()) {
            return org.springframework.http.ResponseEntity.notFound().build();
        }
        return org.springframework.http.ResponseEntity.ok()
                .header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + archivo + "\"")
                .body(resource);
    }

}
