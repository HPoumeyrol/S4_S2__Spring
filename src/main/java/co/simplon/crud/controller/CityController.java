package co.simplon.crud.controller;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.simplon.crud.model.City;
import co.simplon.crud.service.CityService;


@Controller
@RequestMapping("/city")
class CityController {
	
	@Inject
	CityService cityService;

	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   public ResponseEntity<City> getCityById(@PathVariable(value = "id" ) String strCityId) {
		try {
			Long cityId = Long.parseLong(strCityId);
			Optional<City> city = cityService.findbyId(cityId);
			return city.isPresent() 
			    ? ResponseEntity.ok().body(city.get())
			    : ResponseEntity.notFound().build();
		 }
		 catch (Exception e)
		 {
			 e.printStackTrace();
			 return ResponseEntity.badRequest().build();
		 }
	
	   }
	    
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody

	public City create(@ModelAttribute City city) {
		return cityService.save(city);
	}	
	
	
	
//	@RequestMapping(method = RequestMethod.PUT)
//	@ResponseBody
//	public String createCity(@ModelAttribute City cityToCreate) {
//		String responseBody = errStdMsg;
//			//TODO appel au service
//		
//			return responseBody;
//	}
//	
//	
//	
//	
//	
//	
//	@RequestMapping(method = RequestMethod.POST)
//	@ResponseBody
//	public String updateCity(@ModelAttribute City cityToCreate) {
//		String responseBody = errStdMsg;
//			//TODO appel au service
//		
//			return responseBody;
//	}
//	
//	
//	
//	
//	
//	
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	@ResponseBody
//	public String deleteCity(@PathVariable("id") String idString) {
//	Long id = 0L;
//	String responseBody= errStdMsg;
//	 try {
//		id = Long.parseLong(idString);
//		response = ""; // TODO appel au service
//	 }
//	 catch (Exception e)
//	 {
//		 e.printStackTrace();
//	 }
//	 return responseBody;
//	}
//	
	
}