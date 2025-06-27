package dev.Fabricio.AluguelCarros.service;

import dev.Fabricio.AluguelCarros.model.entity.Cliente;
import dev.Fabricio.AluguelCarros.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrar(Cliente cliente){
        return repository.save(cliente);
    }

    public List<Cliente> listar(){
        return repository.findAll();
    }

    public Cliente listarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public Cliente alterar(Long id, Cliente clienteNovo){
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isPresent()){
            clienteNovo.setId(id);
            return repository.save(clienteNovo);
        }

        return null;
    }

}
