package api.despesas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Despesa {
    private @Id @GeneratedValue Long id;
    private String nome;
    private BigDecimal valor;
    private LocalDate dataPagamento;

    public Despesa() {}
    public Despesa(String nome, BigDecimal valor, LocalDate dataPagamento) {
        this.nome = nome;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", dataPagamento=" + dataPagamento +
                '}';
    }
}
