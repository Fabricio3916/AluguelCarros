package dev.Fabricio.AluguelCarros.model;

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

    private String marca;
    private String modelo;
    private String placa;
    private String cor;
    private

}
