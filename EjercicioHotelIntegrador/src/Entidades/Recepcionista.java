package Entidades;
/**
 *
 * @author Fabri
 */
public class Recepcionista extends Persona{

    private String legajo;

    public Recepcionista(String nombre, String dni, String legajo) {
        super(nombre, dni);
        this.legajo = legajo;
    }
    
    public String getLegajo(){
        return this.legajo;
    }
    
    public void confirmarReserva(Reserva reserva, Hotel hotel){
        if(reserva !=null){
           if(!reserva.isConfirmada()){
                reserva.confirmar();
                reserva.getCliente().notificar("La reserva "+reserva.toString()+" ha sido realizada con exito");
                hotel.agregarReserva(reserva);
            }else
            {
                System.out.println("La reserva "+reserva.toString()+" ya se encontraba confirmada");
            } 
        }else{
            System.out.println("Reserva invalida");
        }
            
        
        //MAS FALOPA
        /*    
        if(hotel.getReservas().contains(reserva) && !reserva.isConfirmada()){
           reserva.confirmar();
           reserva.getCliente().notificar("Se confirmo reserva del pelotudito");
       }else{
           System.out.println("La reserva del bobi ya estaba confirmada");
       }*/
    }
    
    @Override
    public void notificar(String notificacion) {
        super.agregarNotificacion(notificacion);
    }
}
