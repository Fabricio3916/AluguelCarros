package dev.Fabricio.AluguelCarros.service;

import dev.Fabricio.AluguelCarros.model.dto.ClienteDTO;
import dev.Fabricio.AluguelCarros.model.entity.Cliente;
import dev.Fabricio.AluguelCarros.model.mapper.ClienteMapper;
import dev.Fabricio.AluguelCarros.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ClienteDTO cadastrar(ClienteDTO clienteDTO){
        Cliente cliente =  mapper.map(clienteDTO);
        cliente = repository.save(cliente);
        return mapper.map(cliente);
    }

    public List<ClienteDTO> listar(){
        List<Cliente> clientes = repository.findAll();
        return clientes.stream()
                .map(mapper::map)
                .toList();
    }

    public ClienteDTO listarPorId(Long id){
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.map(mapper::map).orElse(null);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public ClienteDTO alterar(Long id, ClienteDTO clienteDTO){
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isPresent()){
            Cliente clienteAtualizado = mapper.map(clienteDTO);
            clienteAtualizado.setId(id);
            return mapper.map(repository.save(clienteAtualizado));
        }

        return null;
    }

}
