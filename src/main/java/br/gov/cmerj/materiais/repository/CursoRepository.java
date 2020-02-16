package br.gov.cmerj.materiais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.cmerj.materiais.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}
