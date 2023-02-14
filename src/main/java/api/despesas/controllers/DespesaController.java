package api.despesas.controllers;

import api.despesas.exceptions.DespesaNotFoundException;
import api.despesas.models.Despesa;
import api.despesas.repositories.DespesaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DespesaController {

    private final AtomicLong counter = new AtomicLong();
    private final DespesaRepository repository;

    public DespesaController(DespesaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/despesas")
    List<Despesa> all() {
        System.out.println(repository.findAll());
        return repository.findAll();
    }

    @PostMapping("/novaDespesa")
    Despesa novaDespesa(@RequestBody Despesa novaDespesa) {
        return repository.save(novaDespesa);
    }

    @GetMapping("/despesa/{id}")
    Despesa despesa(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new DespesaNotFoundException(id));
    }
    @PutMapping("/despesa/{id}")
    Despesa edita(@RequestBody Despesa editaDespesa, @PathVariable Long id) {
        return repository.findById(id)
                .map(despesa -> {
                    if(editaDespesa.getNome() != null) {
                        despesa.setNome(editaDespesa.getNome());
                    }
                    if(editaDespesa.getValor() != null) {
                        despesa.setValor(editaDespesa.getValor());
                    }
                    if(editaDespesa.getDataPagamento() != null) {
                        System.out.println(editaDespesa.getDataPagamento());
                        despesa.setDataPagamento(editaDespesa.getDataPagamento());
                    }
                    return repository.save(despesa);
                })
                .orElseGet(() -> {
                   editaDespesa.setId(id);
                   return repository.save(editaDespesa);
                });
    }

    @DeleteMapping("/despesa/{id}")
    public ResponseEntity<Map<String, String>> deletaDespesa(@PathVariable Long id) {
        repository.deleteById(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Recurso deletado com sucesso");

        return ResponseEntity.ok(response);
    }

}
