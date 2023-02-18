package api.despesas.view;

import api.despesas.DespesasApplication;
import api.despesas.exceptions.DespesaNotFoundException;
import api.despesas.models.Despesa;
import api.despesas.repositories.DespesaRepository;
import api.despesas.services.DespesaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
public class DespesaView {

    private static final Logger log = LoggerFactory.getLogger(DespesasApplication.class);
    private final DespesaRepository repository;
    @Autowired
    private DespesaService despesaService;

    public DespesaView(DespesaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/despesa_view/{id}")
    public String despesa_view(@PathVariable Long id, Model model) {

        Despesa despesa = repository.findById(id)
                .orElseThrow(() -> new DespesaNotFoundException(id));


        model.addAttribute("nome", despesa.getNome());
        model.addAttribute("valor", despesa.getValor());
        model.addAttribute("dataPagamento", formataData(despesa.getDataPagamento()));

        return "despesa_view";
    }

    @GetMapping("/")
    public String getDespesas(Model model) {
        List<Despesa> despesas = despesaService.getDespesas();

        model.addAttribute("despesas", despesas);
        return "todas_despesas";
    }

    public String formataData(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = date.format(formatter);
        return dataFormatada;
    }
    @GetMapping("/cadastra_despesa")
    public String cadastraDespesa(Model model) {
        return "cadastrar_despesa";
    }

    @GetMapping("/upload_file")
    public String uploadCsv(Model model) { return "upload"; }

}
