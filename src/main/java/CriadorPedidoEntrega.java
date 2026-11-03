public class CriadorPedidoEntrega extends CriadorPedido {

    @Override
    protected Pedido criarPedido() {
        return new PedidoEntrega();
    }
}