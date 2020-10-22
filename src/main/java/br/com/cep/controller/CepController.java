package br.com.cep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cep.business.CepBusiness;

@RestController
public class CepController {
	
	@Autowired
	private CepBusiness cepBusiness;

	@GetMapping("/cep/{cep}")
	public String findCep(@PathVariable(value = "cep") String cep) {
		
		return cepBusiness.findCep(cep);
	}
	
	@GetMapping("/ceps")
	public String findAllCep(@RequestParam String ibge, @RequestParam String uf) {
		
		return cepBusiness.findAllCeps(ibge, uf);
	}

}
