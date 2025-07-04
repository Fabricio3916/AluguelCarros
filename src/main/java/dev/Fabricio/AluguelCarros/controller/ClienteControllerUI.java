package dev.Fabricio.AluguelCarros.controller;

import dev.Fabricio.AluguelCarros.model.dto.ClienteDTO;
import dev.Fabricio.AluguelCarros.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("clientes/ui")
public class ClienteControllerUI {

    private final ClienteService service;

    public ClienteControllerUI(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public String listarClientes(Model model){
        List<ClienteDTO> clientes = service.listar();
        model.addAttribute("clientes", clientes);
        return "listarClientes";
    }

    @GetMapping("/deletar/{id}")
    public String deletarRegistro(@PathVariable Long id){
        service.deletar(id);
        return "redirect:/clientes/ui/listar";
    }

}
