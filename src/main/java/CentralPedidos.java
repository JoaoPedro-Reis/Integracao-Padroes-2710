import java.util.ArrayList;
import java.util.List;

public class CentralPedidos {

    private static CentralPedidos instancia;

    private List<Pedido> pedidos = new ArrayList<>();
    private int ultimoNumero = 0;

    private CentralPedidos() {
    }

    public static CentralPedidos getInstance() {
        if (instancia == null) {
            instancia = new CentralPedidos();
        }

        return instancia;
    }

    public int proximoNumero() {
        ultimoNumero++;
        return ultimoNumero;
    }

    public void registrar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}