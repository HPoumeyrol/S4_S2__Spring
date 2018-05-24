package co.simplon.crud.service;

import javax.inject.Named;

import co.simplon.crud.model.City;

import java.util.List;
import java.util.Optional;


@Named
public interface CityService {
	
	
	public City save(City city);
	
	public List<City> getAll();
	
	public Optional<City> findbyId(Long id);
	
	// TODO ajouter les autres méthodes
	
}