public class PedidoRetirada extends Pedido {

    public float calcularTaxaEntrega() {
        return 0.0f;
    }

    @Override
    public String getTipo() {
        return "PedidoRetirada";
    }
}