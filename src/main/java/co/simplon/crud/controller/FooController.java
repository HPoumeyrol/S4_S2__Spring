package co.simplon.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import co.simplon.crud.model.Foo;


@Controller
@RequestMapping("/foos")
class FooController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Foo> findAll() {
		ArrayList<Foo> myList = new ArrayList<Foo>();
		myList.add(new Foo("Test1"));
		myList.add(new Foo("Test2"));
		myList.add(new Foo("Test3"));
		myList.add(new Foo("Test4"));
		myList.add(new Foo("Test5"));
		
		
	    return myList;
	}

	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody

	// annotation sur les paramètres de la  méthode	
//	@requestBody --> envoi au format json
//	@modelAttribute --> envoi au format natif formulaire
	//public Long create(@RequestBody Foo resource) {
	public Long create(@ModelAttribute Foo resource) {

	    return 1L;
	}
	
}