package dev.Fabricio.AluguelCarros.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "carrosAlugados")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    @Column(name = "data_de_criacao")
    private LocalDate dataCriacao;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Carro> carrosAlugados;


}
