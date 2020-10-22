package br.com.cep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cep.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, String> {

	@Query("Select t From Cidade t where t.ibge = ?1")
	Cidade findByIbge(String ibge);
	
	@Query("Select t From Cidade t where t.ibge = ?1 and t.uf = ?2")
	Cidade findByIbgeUf(String ibge, String uf);
}
