public class PagamentoPix implements CalculoPagamento {

    public float calcular(float valor, int parcelas) {
        return valor * 0.95f; // 5% de desconto
    }
}