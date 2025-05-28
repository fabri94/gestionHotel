/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciohotelintegrador;

import Entidades.*;
import java.time.LocalDate;

/**
 *
 * @author Fabri
 */
public class EjercicioHotelIntegrador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Buena Vista", "Calle Falsa 123");

        // Agregar habitaciones
        Habitacion habSimple = new Habitacion(101, TipoHabitacion.SIMPLE, 100.0);
        Habitacion habDoble = new Habitacion(102, TipoHabitacion.DOBLE, 200.0);
        hotel.agregarHabitacion(habSimple);
        hotel.agregarHabitacion(habDoble);

        // Agregar recepcionistas
        Recepcionista recepcionista1 = new Recepcionista("Ana", "12345678", "R001");
        Recepcionista recepcionista2 = new Recepcionista("Luis", "87654321", "R002");
        hotel.agregarRecepcionista(recepcionista1);
        hotel.agregarRecepcionista(recepcionista2);

        // Crear clientes
        Cliente cliente1 = new Cliente("Carlos", "11111111", "carlos@mail.com");
        Cliente cliente2 = new Cliente("Lucía", "22222222", "lucia@mail.com");
        Cliente cliente3 = new Cliente("Pedro", "33333333", "pedro@mail.com");
        Cliente cliente4 = new Cliente("María", "44444444", "maria@mail.com");

        // === Escenario A ===
        System.out.println("=== ESCENARIO A ===");
        LocalDate inicioA = LocalDate.of(2025, 6, 1);
        LocalDate finA = LocalDate.of(2025, 6, 5);
        cliente1.realizarReserva(hotel, habSimple, inicioA, finA);
        Reserva reservaA = cliente1.getReservas().get(0);
        recepcionista1.confirmarReserva(reservaA, hotel);

        // === Escenario B ===
        System.out.println("\n=== ESCENARIO B ===");
        LocalDate inicioB = LocalDate.of(2025, 6, 6);
        LocalDate finB = LocalDate.of(2025, 6, 10);
        cliente2.realizarReserva(hotel, habSimple, inicioB, finB);
        Reserva reservaB = cliente2.getReservas().get(0);
        recepcionista2.confirmarReserva(reservaB, hotel);

        // === Escenario C ===
        System.out.println("\n=== ESCENARIO C ===");
        LocalDate inicioC = LocalDate.of(2025, 6, 4); // solapa con la reserva de cliente1
        LocalDate finC = LocalDate.of(2025, 6, 8);
        cliente3.realizarReserva(hotel, habSimple, inicioC, finC); // no se debería registrar

        // === Escenario D ===
        System.out.println("\n=== ESCENARIO D ===");
        LocalDate inicioD = LocalDate.of(2025, 6, 1);
        LocalDate finD = LocalDate.of(2025, 6, 3);
        cliente4.realizarReserva(hotel, habSimple, inicioD, finD); // ya ocupada por cliente1

        // === Notificaciones de clientes ===
        System.out.println("\n=== NOTIFICACIONES DE CLIENTES ===");
        System.out.println("Cliente 1:\n" + cliente1);
        System.out.println("Cliente 2:\n" + cliente2);
        System.out.println("Cliente 3:\n" + cliente3);
        System.out.println("Cliente 4:\n" + cliente4);

        // === Notificaciones de recepcionistas ===
        System.out.println("\n=== NOTIFICACIONES DE RECEPCIONISTAS ===");
        System.out.println("Recepcionista 1:\n" + recepcionista1);
        System.out.println("Recepcionista 2:\n" + recepcionista2);

        // === Detalle de reservas confirmadas en el hotel ===
        System.out.println("\n=== RESERVAS CONFIRMADAS EN EL HOTEL ===");
        System.out.println(hotel);
    }
    
}
