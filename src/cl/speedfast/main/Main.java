package cl.speedfast.main;

import cl.speedfast.model.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("[Zona de carga inicializada]");

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        // Carga de 5 pedidos iniciales
        zonaDeCarga.agregarPedido(new Pedido(1, "Santiago Centro"));
        zonaDeCarga.agregarPedido(new Pedido(2, "Providencia"));
        zonaDeCarga.agregarPedido(new Pedido(3, "Ñuñoa"));
        zonaDeCarga.agregarPedido(new Pedido(4, "Recoleta"));
        zonaDeCarga.agregarPedido(new Pedido(5, "Las Condes"));

        // Inicialización repartidores
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new Repartidor("Juan", zonaDeCarga));
        executor.execute(new Repartidor("Camila", zonaDeCarga));
        executor.execute(new Repartidor("Pedro", zonaDeCarga));

        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("...");
                System.out.println("[Zona de carga vacía]");
                System.out.println("Todos los pedidos han sido entregados correctamente.");
            } else {
                System.err.println("El tiempo de entrega ha excedido el límite.");
            }
        } catch (InterruptedException e) {
            System.err.println("Ejecución principal interrumpida: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}