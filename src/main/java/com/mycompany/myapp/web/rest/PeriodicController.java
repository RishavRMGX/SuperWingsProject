package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.PeriodicTableService;
import com.mycompany.myapp.service.dto.PeriodicTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/periodic")
public class PeriodicController {

    @Autowired
    PeriodicTableService periodicTableService;

    @GetMapping("/all")
    ResponseEntity<Object> getAllElement(Pageable pageable) {
        Page<PeriodicTableDTO> periodicTableDTO = periodicTableService.getPeriodicTable(pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("result", periodicTableDTO);
        response.put("msg", "Successful");

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add")
    ResponseEntity<Object> addElement(@RequestBody PeriodicTableDTO periodicTableDTO) {
        Map<String, Object> response = new HashMap<>();
        if (periodicTableDTO == null) {
            return ResponseEntity.notFound().build();
        } else {
            PeriodicTableDTO savedData = periodicTableService.addElement(periodicTableDTO);
            if (savedData == null) ResponseEntity.badRequest();
            response.put("result", savedData);
            response.put("msg", "Successful");
            return ResponseEntity.ok().body(response);
        }
    }
}
