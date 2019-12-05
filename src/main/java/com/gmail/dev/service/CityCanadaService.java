package com.gmail.dev.service;

import com.gmail.dev.domain.CityCanada;
import com.gmail.dev.repository.CityCanadaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityCanadaService {
    private final CityCanadaRepository cityCanadaRepository;

    public CityCanadaService(CityCanadaRepository cityCanadaRepository) {
        this.cityCanadaRepository = cityCanadaRepository;
    }

    public List<CityCanada> findAllCityCanada() {
        return cityCanadaRepository.findAll();
    }
}
