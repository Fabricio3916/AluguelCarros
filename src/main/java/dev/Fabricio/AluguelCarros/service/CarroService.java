package dev.Fabricio.AluguelCarros.service;

import dev.Fabricio.AluguelCarros.model.dto.CarroDTO;
import dev.Fabricio.AluguelCarros.model.entity.Carro;
import dev.Fabricio.AluguelCarros.model.mapper.CarroMapper;
import dev.Fabricio.AluguelCarros.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {


    private CarroRepository repository;
    private CarroMapper mapper;

    public CarroService(CarroRepository repository, CarroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CarroDTO cadastrar(CarroDTO carroDTO){
        Carro carro = mapper.map(carroDTO);
        return mapper.map(repository.save(carro));

    }

    public List<CarroDTO> listar(){
        List<Carro> carros = repository.findAll();
        return carros.stream()
                .map(mapper::map)
                .toList();

    }

    public CarroDTO listarPorId(Long id){
        Optional<Carro> carroPorId = repository.findById(id);
        return carroPorId.map(mapper::map).orElse(null);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public CarroDTO alterar(Long id, CarroDTO carroAtualizado){
        Optional<Carro> carro = repository.findById(id);
        if(carro.isPresent()){
            Carro carroAlterado = mapper.map(carroAtualizado);
            carroAlterado.setId(id);
            return mapper.map(repository.save(carroAlterado));
        }
        return null;
    }

}
