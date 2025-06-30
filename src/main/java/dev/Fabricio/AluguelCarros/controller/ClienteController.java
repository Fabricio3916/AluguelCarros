package dev.Fabricio.AluguelCarros.controller;

import dev.Fabricio.AluguelCarros.model.entity.Carro;
import dev.Fabricio.AluguelCarros.model.entity.Cliente;
import dev.Fabricio.AluguelCarros.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarTodosClientes(){
        List<Cliente> clientes = service.listar();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/listarId/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        Cliente clienteEncontrado = service.listarPorId(id);
        if (clienteEncontrado != null){
            return ResponseEntity.ok(clienteEncontrado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente com registro " + id + " não foi encontrado");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarRegistro(@RequestBody Cliente cliente){
        Cliente novoCliente = service.cadastrar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O Cliente " + cliente.getNome() + " foi cadastrado com sucesso" );
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarRegistro(@PathVariable  Long id){
        if (service.listarPorId(id) != null){
            service.deletar(id);
            return ResponseEntity.ok("Cliente com registro " + id + " foi deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente com registro " + id + " não foi encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarRegistro(@PathVariable Long id, @RequestBody Cliente clienteAlterado){
        if (service.listarPorId(id) != null){
            service.alterar(id,clienteAlterado);
            return ResponseEntity.ok("Cliente com registro " + id + " foi alterado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente com registro " + id + " não foi encontrado");
        }
    }

}
