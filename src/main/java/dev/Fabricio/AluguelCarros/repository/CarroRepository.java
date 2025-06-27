package dev.Fabricio.AluguelCarros.repository;

import dev.Fabricio.AluguelCarros.model.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
