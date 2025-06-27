package dev.Fabricio.AluguelCarros.repository;

import dev.Fabricio.AluguelCarros.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
