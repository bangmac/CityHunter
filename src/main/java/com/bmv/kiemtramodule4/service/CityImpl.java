package com.bmv.kiemtramodule4.service;

import com.bmv.kiemtramodule4.model.City;
import com.bmv.kiemtramodule4.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityImpl implements CityService{
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
