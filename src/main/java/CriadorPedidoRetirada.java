public class CriadorPedidoRetirada extends CriadorPedido {

    @Override
    protected Pedido criarPedido() {
        return new PedidoRetirada();
    }
}