package com.emyllio.projeto_automovel.automovel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutomovelService {

    private final AutomovelRepository automovelRepository;

    @Autowired
    public AutomovelService(AutomovelRepository automovelRepository) {
        this.automovelRepository = automovelRepository;
    }

    // LISTAR TODOS
    public List<Automovel> listarTodos(){
        return automovelRepository.findAll();
    }

    // INSERIR
    public Automovel inserir(Automovel automovel){
        return automovelRepository.save(automovel);
    }

    // BUSCAR POR ID
    public Automovel buscarPorId(Long id){
        return automovelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Automóvel não encontrado"));
    }

    // ATUALIZAR
    public Automovel atualizar(Long id, Automovel novo){
        // Aqui garantimos que "a" é do tipo Automovel
        Automovel a = buscarPorId(id);

        // Atualiza todos os campos
        a.setNome(novo.getNome());
        a.setModelo(novo.getModelo());
        a.setQuantidade(novo.getQuantidade());
        a.setPrecoVenda(novo.getPrecoVenda());
        a.setTrioEletrico(novo.isTrioEletrico());
        a.setDataFabricacao(novo.getDataFabricacao());

        return automovelRepository.save(a);
    }

    // DELETAR
    public void deletar(Long id){
        // Garante que o objeto existe antes de deletar
        buscarPorId(id);
        automovelRepository.deleteById(id);
    }
}