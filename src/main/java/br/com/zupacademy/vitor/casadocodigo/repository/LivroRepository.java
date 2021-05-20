package br.com.zupacademy.vitor.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.vitor.casadocodigo.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
