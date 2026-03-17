package com.emyllio.projeto_automovel.automovel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/automovel")
public class AutomovelController {

    private final AutomovelService automovelService;

    @Autowired
    public AutomovelController(AutomovelService automovelService){
        this.automovelService = automovelService;
    }

    // LISTAR TODOS
    @GetMapping
    public List<Automovel> listarTodos(){
        return automovelService.listarTodos();
    }

    // INSERIR
    @PostMapping
    public Automovel inserir(@RequestBody Automovel automovel){
        return automovelService.inserir(automovel);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Automovel buscarPorId(@PathVariable Long id){
        return automovelService.buscarPorId(id);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Automovel atualizar(@PathVariable Long id,
                               @RequestBody Automovel automovel){
        return automovelService.atualizar(id, automovel);
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        automovelService.deletar(id);
    }
}