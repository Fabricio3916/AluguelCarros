package dev.Fabricio.AluguelCarros.model.entity;

import dev.Fabricio.AluguelCarros.model.enums.Marca;
import dev.Fabricio.AluguelCarros.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_carro")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Marca marca;
    private String modelo;
    private String placa;
    private String cor;
    private Status status;

}
