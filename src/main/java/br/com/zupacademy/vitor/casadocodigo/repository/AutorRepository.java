package br.com.zupacademy.vitor.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.vitor.casadocodigo.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
	

}
