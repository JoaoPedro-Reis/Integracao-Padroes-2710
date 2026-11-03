public class CalculadoraPagamento {

    private float valor;
    private int parcelas;

    public CalculadoraPagamento(float valor, int parcelas) {
        this.valor = valor;
        this.parcelas = parcelas;
    }

    public float calcular(CalculoPagamento calculo) {
        return calculo.calcular(valor, parcelas);
    }
}