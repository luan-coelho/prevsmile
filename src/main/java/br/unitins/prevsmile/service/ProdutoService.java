package br.unitins.prevsmile.service;

import br.unitins.prevsmile.domain.model.Produto;
import br.unitins.prevsmile.domain.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<Produto> buscarTodos() {
        return repository.findAll();
    }

    public Produto buscarPeloId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado pelo id"));
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produto) {
        Produto busca = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado pelo id"));
        BeanUtils.copyProperties(produto, busca);
        busca.setId(id);
        return repository.save(busca);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
