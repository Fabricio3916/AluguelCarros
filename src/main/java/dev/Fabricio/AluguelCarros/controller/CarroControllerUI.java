package dev.Fabricio.AluguelCarros.controller;

import dev.Fabricio.AluguelCarros.model.dto.CarroDTO;
import dev.Fabricio.AluguelCarros.service.CarroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("carros/ui")
public class CarroControllerUI {

    private final CarroService service;

    public CarroControllerUI(CarroService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public String listarCarros(Model model) {
        List<CarroDTO> carros = service.listar();
        model.addAttribute("carros", carros);
        return "listarCarros";  // Nome da página HTML (listarCarros.html)
    }

    @GetMapping("/deletar/{id}")
    public String deletarRegistro(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/carros/ui/listar";
    }

}
