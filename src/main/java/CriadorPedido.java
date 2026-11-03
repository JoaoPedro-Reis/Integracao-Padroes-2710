public abstract class CriadorPedido {

    public Pedido novoPedido(String nomeCliente, float valorLanche, float distanciaKm) {
        Pedido pedido = criarPedido();
        pedido.setNumero(CentralPedidos.getInstance().proximoNumero());
        pedido.setNomeCliente(nomeCliente);
        pedido.setValorLanche(valorLanche);
        pedido.setDistanciaKm(distanciaKm);
        CentralPedidos.getInstance().registrar(pedido);
        return pedido;
    }

    protected abstract Pedido criarPedido();
}