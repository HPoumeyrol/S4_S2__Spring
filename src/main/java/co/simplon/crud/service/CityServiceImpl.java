package co.simplon.crud.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import co.simplon.crud.model.City;
import co.simplon.crud.repository.CityRepository;

@Named
public class CityServiceImpl implements CityService {

    @Inject
    CityRepository cityRepository;
	
    
    public City save(City city) {
	  cityRepository.save(city);
	  return city;
    }

    
    
    public List<City> getAll() {
	  return cityRepository.findAll();  
    }
    
    
    
    public Optional<City> findbyId(Long id) {
	  return cityRepository.findById(id);
    }

}