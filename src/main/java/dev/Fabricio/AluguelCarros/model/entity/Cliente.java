package dev.Fabricio.AluguelCarros.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    @Column(name = "data_de_alocação")
    private LocalDate dataAlocacao;

    @OneToMany(mappedBy = "cliente")
    private List<Carro> carrosAlugados;


}
