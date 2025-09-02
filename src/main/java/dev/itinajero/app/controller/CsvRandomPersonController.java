package dev.itinajero.app.controller;

import dev.itinajero.app.dto.CsvGenerationMetadata;
import dev.itinajero.app.service.CsvRandomPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/csv")
public class CsvRandomPersonController {

    @Autowired
    private CsvRandomPersonService csvRandomPersonService;

    @PostMapping("/personas")
    public CsvGenerationMetadata generarCsv(@RequestParam(defaultValue = "10000") Long cantidad) throws Exception {
        return csvRandomPersonService.generarCsvPersonas(cantidad);
    }

}
