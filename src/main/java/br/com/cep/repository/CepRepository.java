package br.com.cep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;

@Repository
public interface CepRepository extends JpaRepository<Cep, String> {

	@Query("Select t From Cep t where t.cep = ?1")
	Cep findByCep(String cep);
	
	@Query("Select t From Cep t where t.cidade = ?1")
	List<Cep> findByIbge(Cidade cidade);
}
