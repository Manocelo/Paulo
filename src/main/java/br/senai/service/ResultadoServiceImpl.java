package br.senai.service;

import br.senai.model.Resultado;
import br.senai.repository.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoServiceImpl implements ResultadoService{
    @Autowired
    ResultadoRepository resultadoRepository;

    @Override
    public List<Resultado> findAll(){
        return resultadoRepository.findAll();
    }

    @Override
    public Resultado findById(Long id){
        Resultado findResultado = resultadoRepository.findById(id).get();
        return findResultado != null ? findResultado : new Resultado();
    }

    @Override
    public Resultado save(Resultado resultado){
        try{
            return resultadoRepository.save(resultado);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try{
            resultadoRepository.deleteById(id);
        }catch (Exception e){
            throw e;
        }
    }
}
