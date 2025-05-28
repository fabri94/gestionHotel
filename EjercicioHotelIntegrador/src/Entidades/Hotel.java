package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Fabri
 */
public class Hotel {
    private String nombre;
    private String direccion;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Recepcionista> recepcionistas;
    private ArrayList<Reserva> reservas;
    
    public Hotel(){
        habitaciones = new ArrayList<>();
        recepcionistas = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public Hotel(String nombre, String direccion) {
        this();
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public ArrayList<Recepcionista> getRecepcionistas() {
        return recepcionistas;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    
    public void agregarHabitacion(Habitacion habitacion){
        if(habitacion != null){
            habitaciones.add(habitacion);
        }
    }
    
    public void agregarRecepcionista(Recepcionista recepcionista){
        if(recepcionista != null){
            recepcionistas.add(recepcionista);
        }
    }
    
    public void agregarReserva(Reserva reserva){
        if(reserva != null && !reservas.contains(reserva)){
            reservas.add(reserva);
        }   
    }
       
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("HOTEL: ").append(this.nombre).append("\n");
        sb.append("DIRECCION: ").append(this.direccion).append("\n");
        sb.append(mostrarHabitaciones());
        sb.append(mostrarReservas());
        sb.append(mostrarRecepcionistas());
        return sb.toString();
    }
    
    public ArrayList<Habitacion> buscarHabitacionesDisponibles(LocalDate inicio, LocalDate fin, TipoHabitacion tipo){
        ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<>();
        
        for(Habitacion h : habitaciones){
            if(h.getTipo() == tipo){
                
                boolean estaDisponible = true;
                
                for(Reserva r : reservas){
                    if(r.isConfirmada()&& r.getHabitacion().equals(h)&& r.seSolapa(inicio, fin)){
                        estaDisponible = false;
                        break;
                    }
                    
                }if(estaDisponible){
                    habitacionesDisponibles.add(h);
                }
            }
        }
        return habitacionesDisponibles;
    }
    
    private String mostrarHabitaciones(){
        StringBuilder sb = new StringBuilder();
        for(Habitacion h : habitaciones){
            sb.append(h).append("\n");
        }
        return sb.toString();
    }
    
    private String mostrarRecepcionistas(){
        StringBuilder sb = new StringBuilder();
        for(Recepcionista r : recepcionistas){
            sb.append(r).append("\n");
        }
        return sb.toString();
    }
    
    private String mostrarReservas(){
        StringBuilder sb = new StringBuilder();
        for(Reserva rs : reservas){
            sb.append(rs).append("\n");
        }
        return sb.toString();
    }
}
