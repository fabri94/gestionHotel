package Entidades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Fabri
 */
public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean confirmada;

    public Reserva(Cliente cliente, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public boolean isConfirmada() {
        return confirmada;
    }
    
    public void confirmar(){
        if(!confirmada){
            this.confirmada = true;
        }
    }
    
    public double calcularTotal(){
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        return dias * this.habitacion.getPrecioPorNoche();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: ").append(cliente.getNombre()).append("\n");
        sb.append("Habitacion: ").append(habitacion.getTipo()).append("\n");
        sb.append("Fecha ingreso: ").append(this.fechaInicio).append("\n");
        sb.append("Fecha egreso: ").append(this.fechaFin).append("\n");
        return sb.toString();
    }
    
    public boolean seSolapa(LocalDate fechaIngreso, LocalDate fechaEgreso){
        return !(this.fechaFin.isBefore(fechaIngreso)||this.fechaInicio.isAfter(fechaEgreso));
    }
    
}
