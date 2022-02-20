package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.PeriodicTable;
import com.mycompany.myapp.repository.PeriodicTableRepository;
import com.mycompany.myapp.service.PeriodicTableService;
import com.mycompany.myapp.service.dto.PeriodicTableDTO;
import com.mycompany.myapp.service.mapper.PeriodicTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Optional;

@Service
public class PeriodicTableServiceImpl implements PeriodicTableService {

    @Autowired
    PeriodicTableRepository periodicTableRepository;

    @Autowired
    PeriodicTableMapper periodicTableMapper;

    @Override
    public Page<PeriodicTableDTO> getPeriodicTable(Pageable pageable) {
        Page<PeriodicTable> periodicTables = periodicTableRepository.findAll(pageable);
        return periodicTables.map(periodicTableMapper::toDTO);
    }

    @Override
    public PeriodicTableDTO getElement(Long atomicNumber) {
        Optional<PeriodicTable> periodicTable = periodicTableRepository.findById(atomicNumber);
        if (periodicTable.isPresent()) {
            return periodicTableMapper.toDTO(periodicTableRepository.findById(atomicNumber).orElse(null));
        }
        throw new RuntimeException("Element Not Found");
    }

    @Override
    public PeriodicTableDTO addElement(PeriodicTableDTO periodicTableDTO) {
        DecimalFormat df = new DecimalFormat("###.####");
        periodicTableDTO.setAtomicWeight(Double.valueOf(df.format(periodicTableDTO.getAtomicWeight())));
        return periodicTableMapper.toDTO(periodicTableRepository.save(periodicTableMapper.toEntity(periodicTableDTO)));
    }
}
