package br.com.cep.business.impl;

import java.util.List;
import java.util.Properties;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.cep.business.CepBusiness;
import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;
import br.com.cep.repository.CepRepository;
import br.com.cep.repository.CidadeRepository;

@Service
public class CepBusinessImpl implements CepBusiness {
	
	private static final String IBGE2 = "ibge";

	private static final String JSON = "/json/";

	private static final String HTTP_VIACEP_COM_BR_WS = "http://viacep.com.br/ws/";

	@Autowired
	private CepRepository cepRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public String findCep(String cepString) {
		
		Cidade cidade;
		Cep cep = new Cep();
		Gson gson = new Gson();

		try {
			
			cep = cepRepository.findByCep(cepString);
			
			if(cep == null) {
				final String uri = HTTP_VIACEP_COM_BR_WS.concat(cepString).concat(JSON);
				
				RestTemplate restTemplate = new RestTemplate();
				String result = restTemplate.getForObject(uri, String.class);
				
				Properties data = gson.fromJson(result, Properties.class);
				
				String ibge = data.getProperty(IBGE2);
				
				cep = gson.fromJson(result, Cep.class);
				
				cidade = cidadeRepository.findByIbge(ibge);
				
				if(cidade == null) {
					cidade = gson.fromJson(result, Cidade.class);
						
					cidadeRepository.saveAndFlush(cidade);
				}
				
				cep.setCidade(cidade);
				
				cepRepository.save(cep);
			}
		} catch (Exception e) {
			new Exception(e.getCause());
		}

		return gson.toJson(cep);
	}

	@Override
	@Transactional
	public String findAllCeps(String ibge, String uf) {
		
		Cidade cidade;
		Gson gson = new Gson();
		List<Cep> ceps = null;
		
		try {
			
			cidade = cidadeRepository.findByIbgeUf(ibge, uf);
			
			if(cidade != null) {
				ceps = cepRepository.findByIbge(cidade);
			}
			
		} catch (Exception e) {
			new Exception(e.getCause());
		}
		
		return gson.toJson(ceps);
	}

}
