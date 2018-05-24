package poubelle;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Foo read(@PathVariable("id") String idString) {
	Long id = 0L;
	 try {
		id = Long.parseLong(idString);
	 }
	 catch (Exception e)
	 {
		 
	 }
	 return new Foo(id, "fake read");
	}

	
	@RequestMapping(value = "/demoCookieLecture", method = RequestMethod.GET)
	@ResponseBody
	public String demoCookieRead(@CookieValue(value= "SCREEN_NAME", defaultValue = "") String cookie,
			@CookieValue(value= "cookieHUG", defaultValue = "") String cookieHug,
			@CookieValue(value= "lastVisit", defaultValue = "") String cookieLastVisit,
			HttpServletResponse response
			) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		response.addCookie(new Cookie("lastVisit", timeStamp));
		return "Valeur cookie = " + cookie + "<br>Valeur CookieHug=" + cookieHug + "<br>Derniere visite : " + cookieLastVisit;
	}
	

	
	@RequestMapping(value = "/demoCookieSet", method = RequestMethod.GET)
	@ResponseBody
	public String demoCookieSet(HttpServletResponse response) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		response.addCookie(new Cookie("cookieHUG", "Hugues"));
		response.addCookie(new Cookie("lastVisit", timeStamp));
		return "Cookies definis";
	}
	
	
	@RequestMapping(value = "/demoParamsRead", method = RequestMethod.GET)
	@ResponseBody
	public String demoParamsRead(
				@RequestParam(name="P1", defaultValue ="") String param1,
				@RequestParam(name="P2", defaultValue ="") String param2
			) {
		return "Mes paramètres : P1=" + param1 + " P2=" + param2;
	}
	
	
	@RequestMapping(value = "/demoParamsReadAll", method = RequestMethod.GET)
	@ResponseBody
	public String demoParamsReadAll(
				@RequestParam() Map<String, String> params) {
		Double result= 0.0;
		//result = params.get("P1") + 1.0;
		return "Mes paramètres : " + params + "<br>" + "result = " + result;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody

	// annotation sur les paramètres de la méthode
	// @requestBody --> envoi au format json
	// @modelAttribute --> envoi au format natif formulaire
	// public Long create(@RequestBody Foo resource) {
	public Long create(@ModelAttribute Foo resource) {

		return 1L;
	}

}