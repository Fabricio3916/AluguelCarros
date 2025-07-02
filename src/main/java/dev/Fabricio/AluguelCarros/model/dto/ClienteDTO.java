package dev.Fabricio.AluguelCarros.model.dto;


import dev.Fabricio.AluguelCarros.model.entity.Carro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO {

    private Long id;
    private String nome;
    private String telefone;
    private LocalDate dataCriacao;
    private List<Carro> carrosAlugados;

}
