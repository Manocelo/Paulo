package br.senai.service;

import br.senai.model.Resultado;

import java.util.List;

public interface ResultadoService {
    public List<Resultado> findAll();
    public Resultado findById(Long id);
    public Resultado save(Resultado resultado);
    public void deleteById(Long id);
}
