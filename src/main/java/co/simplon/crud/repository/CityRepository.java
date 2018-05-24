package co.simplon.crud.repository;

import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import co.simplon.crud.model.City;

@Named
public interface CityRepository extends JpaRepository<City, Long> {
	List<City> findByName(String name);
	Optional<City> findById(Long Id);
	public List<City> findByNameLike(@Param("name") String name);
}