public class PagamentoDinheiro implements CalculoPagamento {

    public float calcular(float valor, int parcelas) {
        return valor * 0.90f; // 10% de desconto
    }
}