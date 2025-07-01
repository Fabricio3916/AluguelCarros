package dev.Fabricio.AluguelCarros.controller;


import dev.Fabricio.AluguelCarros.model.dto.CarroDTO;
import dev.Fabricio.AluguelCarros.model.entity.Carro;
import dev.Fabricio.AluguelCarros.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroService service;

    public CarroController(CarroService service) {
        this.service = service;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarCarro(@RequestBody CarroDTO novoCarro){
        CarroDTO carro = service.cadastrar(novoCarro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Carro cadastrado com sucesso: " + carro.getModelo() + " (ID) : " + carro.getId());

    }
    @GetMapping("/listar")
    public ResponseEntity<List<CarroDTO>> listarCarros(){
        List<CarroDTO> carros = service.listar();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/listarId/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        CarroDTO carro = service.listarPorId(id);
        if (carro != null){
            return ResponseEntity.ok(carro);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carro com registro " + id + " não foi encontrado no sistema");
        }
    }

    @DeleteMapping("/deletar{id}")
    public ResponseEntity<String> deletarCarro(@PathVariable Long id){
        if(service.listarPorId(id) != null){
            service.deletar(id);
            return ResponseEntity.ok("Carro deletado com sucesso, seu id era " + id);
        } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Carro com registro " + id + " não foi encontrado no sistema");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarCarro(@PathVariable Long id, @RequestBody CarroDTO carroalterado){
        if(service.listarPorId(id) != null){
            CarroDTO novoCarro = service.alterar(id,carroalterado);
            return ResponseEntity.ok(novoCarro);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carro com registro " + id + " não foi encontrado no sistema");
        }
    }
}
