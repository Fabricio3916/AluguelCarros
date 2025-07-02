package dev.Fabricio.AluguelCarros.model.mapper;

import dev.Fabricio.AluguelCarros.model.dto.ClienteDTO;
import dev.Fabricio.AluguelCarros.model.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {


    public Cliente map(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setDataCriacao(clienteDTO.getDataCriacao());
        cliente.setCarrosAlugados(clienteDTO.getCarrosAlugados());
        return cliente;
    }

    public ClienteDTO map(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setTelefone(cliente.getTelefone());
        clienteDTO.setDataCriacao(cliente.getDataCriacao());
        clienteDTO.setCarrosAlugados(cliente.getCarrosAlugados());
        return clienteDTO;
    }

}
