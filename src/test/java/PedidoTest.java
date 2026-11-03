import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void deveCalcularTotalPedidoEntrega() {
        CriadorPedido criador = new CriadorPedidoEntrega();
        Pedido pedido = criador.novoPedido("Ana", 30.0f, 4.0f);
        assertEquals(43.0f, pedido.calcularTotal(), 0.01f); // 30 + (5 + 2 * 4)
    }

    @Test
    void deveCalcularTotalPedidoRetirada() {
        CriadorPedido criador = new CriadorPedidoRetirada();
        Pedido pedido = criador.novoPedido("Bruno", 30.0f, 0.0f);
        assertEquals(30.0f, pedido.calcularTotal(), 0.01f);
    }

    @Test
    void deveCriarPedidoDoTipoCorreto() {
        Pedido entrega = new CriadorPedidoEntrega().novoPedido("Ana", 30.0f, 4.0f);
        Pedido retirada = new CriadorPedidoRetirada().novoPedido("Bruno", 30.0f, 0.0f);
        assertEquals("Pedido", entrega.getTipo());
        assertEquals("PedidoRetirada", retirada.getTipo());
    }

    @Test
    void devePagarPedidoEntregaComPix() {
        Pedido pedido = new CriadorPedidoEntrega().novoPedido("Ana", 30.0f, 4.0f);
        pedido.pagarComPix();
        assertEquals(40.85f, pedido.getTotalPago(), 0.01f);
    }

    @Test
    void devePagarPedidoRetiradaComDinheiro() {
        Pedido pedido = new CriadorPedidoRetirada().novoPedido("Bruno", 30.0f, 0.0f);
        pedido.pagarComDinheiro();
        assertEquals(27.0f, pedido.getTotalPago(), 0.01f);
    }

    @Test
    void devePagarPedidoComDebito() {
        Pedido pedido = new CriadorPedidoEntrega().novoPedido("Ana", 30.0f, 4.0f);
        pedido.pagarComDebito();
        assertEquals(43.0f, pedido.getTotalPago(), 0.01f);
    }

    @Test
    void devePagarPedidoComCreditoParcelado() {
        Pedido pedido = new CriadorPedidoEntrega().novoPedido("Ana", 30.0f, 4.0f);
        pedido.pagarComCredito(3);
        assertEquals(45.58f, pedido.getTotalPago(), 0.01f);
    }

    @Test
    void naoDevePagarPedidoComCreditoSemParcelas() {
        try {
            Pedido pedido = new CriadorPedidoEntrega().novoPedido("Ana", 30.0f, 4.0f);
            pedido.pagarComCredito(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Número de parcelas inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarSempreAMesmaInstanciaDaCentral() {
        assertSame(CentralPedidos.getInstance(), CentralPedidos.getInstance());
    }

    @Test
    void deveGerarNumerosSequenciaisParaOsPedidos() {
        CriadorPedido criador = new CriadorPedidoEntrega();
        Pedido primeiro = criador.novoPedido("Ana", 30.0f, 4.0f);
        Pedido segundo = criador.novoPedido("Bruno", 20.0f, 2.0f);
        assertEquals(primeiro.getNumero() + 1, segundo.getNumero());
    }

}