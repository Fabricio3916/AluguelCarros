package dev.Fabricio.AluguelCarros.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Fabricio.AluguelCarros.model.enums.Marca;
import dev.Fabricio.AluguelCarros.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "tb_carro")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "cliente")
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

    @Column(name = "data_de_alocacao")
    private LocalDate dataAlocacao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnore
    private Cliente cliente;

}
