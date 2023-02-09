package api.despesas.services;

import api.despesas.models.Despesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class DespesaService {

    private static final String API_URL = "http://localhost:8080";

    @Autowired
    private RestTemplate restTemplate;

    public List<Despesa> getDespesas() {
        ResponseEntity<Despesa[]> response = restTemplate.getForEntity(API_URL + "/despesas", Despesa[].class);
        return Arrays.asList(response.getBody());
    }

    public void cadastraDespesa() {

    }
}

