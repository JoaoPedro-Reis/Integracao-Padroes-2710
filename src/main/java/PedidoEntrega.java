public class PedidoEntrega extends Pedido {

    public float calcularTaxaEntrega() {
        return 5.0f + (2.0f * this.getDistanciaKm());
    }
}