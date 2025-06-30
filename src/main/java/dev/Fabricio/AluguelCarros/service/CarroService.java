package dev.Fabricio.AluguelCarros.service;

import dev.Fabricio.AluguelCarros.model.entity.Carro;
import dev.Fabricio.AluguelCarros.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private final CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    public Carro cadastrar(Carro carro){
        return repository.save(carro);
    }

    public List<Carro> listar(){
        return repository.findAll();
    }

    public Carro listarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public Carro alterar(Long id, Carro carroNovo){
        Optional<Carro> carro = repository.findById(id);
        if(carro.isPresent()){
            carroNovo.setId(id);
            return repository.save(carroNovo);
        }
        return null;
    }

}
