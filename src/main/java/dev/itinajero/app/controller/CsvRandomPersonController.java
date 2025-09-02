package dev.itinajero.app.controller;

import dev.itinajero.app.dto.CsvMetadata;
import dev.itinajero.app.service.CsvRandomPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/csv")
public class CsvRandomPersonController {

    @Autowired
    private CsvRandomPersonService csvRandomPersonService;

    @PostMapping("/personas")
    public CsvMetadata generarCsv(@RequestParam(defaultValue = "100000") Long cantidad) throws Exception {
        return csvRandomPersonService.generarCsvPersonas(cantidad);
    }

}
