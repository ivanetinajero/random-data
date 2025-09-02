package dev.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.itinajero.app.dto.CsvMetadata;
import dev.itinajero.app.service.RandomDataService;

@RestController
@RequestMapping("/api/csv")
public class RandomDataController {

    @Autowired
    private RandomDataService csvRandomPersonService;

    @PostMapping("/personas")
    public CsvMetadata generarCsv(@RequestParam(defaultValue = "100000") Long cantidad) throws Exception {
        return csvRandomPersonService.generarCsvPersonas(cantidad);
    }
    
}
