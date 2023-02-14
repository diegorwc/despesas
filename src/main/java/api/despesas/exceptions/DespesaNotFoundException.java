package api.despesas.exceptions;

public class DespesaNotFoundException extends RuntimeException {
    public DespesaNotFoundException(Long id) {
        super("Despesa não encontrada, id -> " + id);
    }
}
