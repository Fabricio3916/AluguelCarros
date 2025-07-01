package dev.Fabricio.AluguelCarros.model.mapper;


import dev.Fabricio.AluguelCarros.model.dto.CarroDTO;
import dev.Fabricio.AluguelCarros.model.entity.Carro;
import dev.Fabricio.AluguelCarros.model.entity.Cliente;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class CarroMapper {

    public Carro map(CarroDTO carroDTO) {
        Carro carro = new Carro();

        carro.setId(carroDTO.getId());
        carro.setMarca(carroDTO.getMarca());
        carro.setModelo(carroDTO.getModelo());
        carro.setPlaca(carroDTO.getPlaca());
        carro.setCor(carroDTO.getCor());
        carro.setStatus(carroDTO.getStatus());
        carro.setDataAlocacao(carroDTO.getDataAlocacao());
        carro.setCliente(carroDTO.getCliente());

        return carro;
    }

    public CarroDTO map(Carro carro) {
        CarroDTO carroDTO = new CarroDTO();

        carroDTO.setId(carro.getId());
        carroDTO.setMarca(carro.getMarca());
        carroDTO.setModelo(carro.getModelo());
        carroDTO.setPlaca(carro.getPlaca());
        carroDTO.setCor(carro.getCor());
        carroDTO.setStatus(carro.getStatus());
        carroDTO.setDataAlocacao(carro.getDataAlocacao());
        carroDTO.setCliente(carro.getCliente());

        return carroDTO;
    }

}
