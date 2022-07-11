package br.senai.repository;

import br.senai.model.Projeto;
import br.senai.model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository  extends JpaRepository<Resultado, Long> {
}
