package cl.speedfast.model;

import java.util.LinkedList;
import java.util.Queue;

public class ZonaDeCarga {
    private final Queue<Pedido> pedidosPendientes;

    public ZonaDeCarga() {
        this.pedidosPendientes = new LinkedList<>();
    }

    public synchronized void agregarPedido(Pedido p) {
        pedidosPendientes.add(p);
        System.out.println("Pedido #" + p.getId() + " agregado. Destino: " + p.getDireccionEntrega());
    }

    public synchronized Pedido retirarPedido() {
        if (pedidosPendientes.isEmpty()) {
            return null;
        }
        return pedidosPendientes.poll();
    }

    public synchronized boolean estaVacia() {
        return pedidosPendientes.isEmpty();
    }
}