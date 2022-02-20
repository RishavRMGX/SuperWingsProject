package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.PeriodicTableDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PeriodicTableService {
    Page<PeriodicTableDTO> getPeriodicTable(Pageable pageable);

    PeriodicTableDTO getElement(Long atomicNumber);

    PeriodicTableDTO addElement(PeriodicTableDTO periodicTableDTO);
}
