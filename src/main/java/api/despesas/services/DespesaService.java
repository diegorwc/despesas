package api.despesas.services;

import api.despesas.models.Despesa;
import api.despesas.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class DespesaService {

    private static final String API_URL = "http://localhost:8080";
    private final DespesaRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ResourceLoader resourceLoader;

    public DespesaService(DespesaRepository repository) {
        this.repository = repository;
    }

    public List<Despesa> getDespesas() {
        ResponseEntity<Despesa[]> response = restTemplate.getForEntity(API_URL + "/despesas", Despesa[].class);
        return Arrays.asList(response.getBody());
    }

    public void readFile(Resource file) throws IOException {
        InputStream inputStream = file.getInputStream();
        Scanner scanner = new Scanner(inputStream, StandardCharsets.ISO_8859_1);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.replaceAll("\"(\\d+),(\\d+)\"", "$1.$2");
            String[] split = line.split(",");
            String nome = split[0];
            BigDecimal valor = new BigDecimal(split[1]);
            LocalDate dataPagamento = LocalDate.of(Integer.valueOf(split[3]), Integer.valueOf(split[2]), 01);
            Despesa importaDespesa = new Despesa(nome, valor, dataPagamento);
            repository.save(importaDespesa);
            System.out.println(split[0] + split[1] + split[2]);
        }
    }

}

