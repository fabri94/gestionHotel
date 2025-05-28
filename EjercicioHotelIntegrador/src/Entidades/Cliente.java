package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Fabri
 */
public class Cliente extends Persona{

    private String mail;
    private ArrayList<Reserva> reservas;

    public Cliente(String nombre, String dni, String mail) {
        super(nombre, dni);
        this.reservas = new ArrayList<>();
        this.mail = mail;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    
    public String getEmail(){
        return mail;
    }
    
    public void realizarReserva(Hotel hotel, Habitacion habitacion, LocalDate inicio, LocalDate fin){
        
        TipoHabitacion tipoSolicitado = habitacion.getTipo();
        ArrayList<Habitacion> habitacionesDisponibles = hotel.buscarHabitacionesDisponibles(inicio, fin, tipoSolicitado);
        
        if(habitacionesDisponibles.contains(habitacion)){
                Reserva reservaPepe = new Reserva(this,habitacion,inicio,fin);
                reservas.add(reservaPepe);
                for(Recepcionista r : hotel.getRecepcionistas()){
                    r.notificar(super.getNombre()+" ha realizado una reserva");
                }
        }else{
            System.out.println("No hay disponibilidad");
        }
        
        //CUALQUIERAAAAAno       
        /*for(Habitacion h : habitacionesDisponibles){
            if(habitacion.equals(h)){
                Reserva reservaPepe = new Reserva(this,habitacion,inicio,fin);
                reservas.add(reservaPepe);
                for(Recepcionista r : hotel.getRecepcionistas()){
                    r.notificar("Cliente: "+super.toString()+" ha hecho una reserva");
                }
            }else{
                System.out.println("No hay disponibilidad");
            }
        }*/
        
    }
        
    @Override
    public void notificar(String notificacion) {
        super.agregarNotificacion(notificacion);
    }
    
}
