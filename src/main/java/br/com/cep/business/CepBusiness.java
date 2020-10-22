package br.com.cep.business;

public interface CepBusiness {
	
	public String findCep(String cep);
	
	public String findAllCeps(String ibge, String uf);

}
