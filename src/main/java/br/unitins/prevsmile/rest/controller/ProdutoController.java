package br.unitins.prevsmile.rest.controller;

import br.unitins.prevsmile.domain.model.Produto;
import br.unitins.prevsmile.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping
    public List<Produto> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarPeloId(@PathVariable Long id) {
        return service.buscarPeloId(id);
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        return service.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
