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

    @Enumerated(EnumType.STRING)
    private Marca marca;

    private String modelo;

    private String placa;

    private String cor;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
