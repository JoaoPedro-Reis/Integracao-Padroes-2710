public class PagamentoCredito implements CalculoPagamento {

    public float calcular(float valor, int parcelas) {
        if (parcelas < 1) {
            throw new IllegalArgumentException("Número de parcelas inválido");
        }
        else if (parcelas == 1) {
            return valor; // à vista, sem juros
        }
        else {
            return valor * (1 + 0.02f * parcelas); // 2% de juros por parcela
        }
    }
}