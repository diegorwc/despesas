package api.despesas.controllers;

import api.despesas.exceptions.DespesaNotFoundException;
import api.despesas.models.Despesa;
import api.despesas.repositories.DespesaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

    private final DespesaRepository repository;

    public ViewController(DespesaRepository repository) {
        this.repository = repository;
    }



    @GetMapping("/despesa_view/{id}")
    public String despesa_view(@PathVariable Long id, Model model) {

        Despesa despesa = repository.findById(id)
                .orElseThrow(() -> new DespesaNotFoundException(id));

        model.addAttribute("nome", despesa.getNome());
        model.addAttribute("valor", despesa.getValor());
        model.addAttribute("dataPagamento", despesa.getDataPagamento());

        return "despesa_view";
    }
}
