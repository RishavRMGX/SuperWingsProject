package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.PeriodicTable;
import com.mycompany.myapp.service.dto.PeriodicTableDTO;
import org.springframework.stereotype.Service;

@Service
public class PeriodicTableMapper {

    public PeriodicTableDTO toDTO(PeriodicTable periodicTable) {
        if (periodicTable == null) {
            return null;
        } else {
            PeriodicTableDTO periodicTableDTO = new PeriodicTableDTO();
            periodicTableDTO.setId(periodicTable.getId());
            periodicTableDTO.setChemicalSymbol(periodicTable.getChemicalSymbol());
            periodicTableDTO.setChemicalName(periodicTable.getChemicalName());
            periodicTableDTO.setAtomicWeight(periodicTable.getAtomicWeight());
            return periodicTableDTO;
        }
    }

    public PeriodicTable toEntity(PeriodicTableDTO periodicTableDTO) {
        if (periodicTableDTO == null) {
            return null;
        } else {
            PeriodicTable periodicTable = new PeriodicTable();
            periodicTable.setId(periodicTableDTO.getId());
            periodicTable.setChemicalSymbol(periodicTableDTO.getChemicalSymbol());
            periodicTable.setChemicalName(periodicTableDTO.getChemicalName());
            periodicTable.setAtomicWeight(periodicTableDTO.getAtomicWeight());
            return periodicTable;
        }
    }
}
