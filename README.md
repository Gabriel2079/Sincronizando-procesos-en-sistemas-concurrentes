# SpeedFast - Gestión Concurrente de Pedidos

Actividad individual de la Semana 5 para la asignatura **Desarrollo Orientado a Objetos II**

---

## ¿De qué trata el proyecto?

El objetivo es simular el flujo de despacho de la empresa **SpeedFast**, donde varios repartidores trabajan en paralelo retirando paquetes desde una bodega común. 

Para evitar entregas duplicadas o conflictos de acceso (condiciones de carrera), el sistema utiliza programación multihilo en Java (`Thread` y `Runnable`) y control de concurrencia mediante métodos sincronizados (`synchronized`).

---

## Cómo funciona el sistema

1. **`EstadoPedido`**: Enum con los tres estados posibles: `PENDIENTE`, `EN_REPARTO` y `ENTREGADO`.
2. **`Pedido`**: Representa la encomienda con su ID, dirección de destino y estado actual.
3. **`ZonaDeCarga`**: Actúa como recurso compartido. Gestiona la lista de pedidos pendientes usando métodos `synchronized` (`agregarPedido` y `retirarPedido`) para garantizar que cada paquete sea tomado por un solo repartidor a la vez.
4. **`Repartidor`**: Implementa `Runnable`. Cada hilo representa a un repartidor que toma un pedido, actualiza su estado a `EN_REPARTO`, simula el traslado con `Thread.sleep()` y finalmente lo marca como `ENTREGADO`.
5. **`Main`**: Inicializa la zona de carga con al menos 5 pedidos, pone a trabajar a 3 repartidores en simultáneo y espera a que todos terminen para cerrar la jornada.

---

## Estructura del repositorio

```text
semana 5/
├── src/
│   ├── EstadoPedido.java
│   ├── Main.java
│   ├── Pedido.java
│   ├── Repartidor.java
│   └── ZonaDeCarga.java
└── README.md
