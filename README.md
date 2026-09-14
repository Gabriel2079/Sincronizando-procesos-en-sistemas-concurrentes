# SpeedFast - Gestión Concurrente de Pedidos

Actividad individual de la Semana 5 para la asignatura **Desarrollo Orientado a Objetos II**

---

## ¿De qué trata el proyecto?

El objetivo es simular el flujo de despacho de la empresa **SpeedFast**, donde varios repartidores trabajan en paralelo retirando paquetes desde una bodega común. 

Para evitar entregas duplicadas o condiciones de carrera, el sistema implementa programación multihilo en Java (`Thread` y `Runnable`) y control de concurrencia mediante métodos sincronizados (`synchronized`).

---

## Cómo funciona el sistema

1. **`cl.speedfast.model.EstadoPedido`**: Enum con los estados del ciclo de vida: `PENDIENTE`, `EN_REPARTO` y `ENTREGADO`.
2. **`cl.speedfast.model.Pedido`**: Modela la encomienda con su ID, dirección y estado.
3. **`cl.speedfast.model.ZonaDeCarga`**: Recurso compartido que gestiona la cola/lista de pedidos. Implementa los métodos sincronizados `agregarPedido()` y `retirarPedido()` para garantizar que solo un repartidor retire un pedido a la vez.
4. **`cl.speedfast.model.Repartidor`**: Implementa `Runnable`. Cada hilo retira un pedido seguro, lo pasa a `EN_REPARTO`, simula el traslado con `Thread.sleep()` y lo marca como `ENTREGADO`.
5. **`cl.speedfast.main.Main`**: Inicializa la zona de carga con los pedidos requeridos, lanza los 3 repartidores en paralelo y espera la finalización de todas las entregas.

---

## Estructura del proyecto

```text
semana 5/
└── src/
    └── cl/
        └── speedfast/
            ├── main/
            │   └── Main.java
            └── model/
                ├── EstadoPedido.java
                ├── Pedido.java
                ├── Repartidor.java
                └── ZonaDeCarga.java
