package com.bmv.kiemtramodule4.service;

import com.bmv.kiemtramodule4.model.City;

import java.util.List;

public interface CityService {
    Iterable<City> findAll();

    City findById(Long id);

    void save(City city);

    void delete(Long id);
}
