package api.despesas.controllers;

import api.despesas.models.Despesa;
import api.despesas.models.Greeting;
import api.despesas.repositories.DespesaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DespesaController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();
    private final DespesaRepository repository;

    public DespesaController(DespesaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
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

}
