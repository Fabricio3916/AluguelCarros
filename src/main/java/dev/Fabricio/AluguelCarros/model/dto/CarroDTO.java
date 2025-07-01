package dev.Fabricio.AluguelCarros.model.dto;

import dev.Fabricio.AluguelCarros.model.entity.Cliente;
import dev.Fabricio.AluguelCarros.model.enums.Marca;
import dev.Fabricio.AluguelCarros.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarroDTO {

    private Long id;
    private Marca marca;
    private String modelo;
    private String placa;
    private String cor;
    private Status status;
    private LocalDate dataAlocacao;
    private Cliente cliente;

}
