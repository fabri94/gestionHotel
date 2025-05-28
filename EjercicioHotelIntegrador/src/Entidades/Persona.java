package Entidades;

import java.util.ArrayList;

/**
 *
 * @author Fabri
 */
public abstract class Persona {
    private String nombre;
    private String dni;
    private ArrayList<String> notificaciones;

    public Persona() {
        notificaciones = new ArrayList<>();
    }

    public Persona(String nombre, String dni) {
        this();
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public ArrayList<String> getNotificaciones() {
        return notificaciones;
    }
    
    protected void agregarNotificacion(String mensaje){
        if(mensaje!=null){
            notificaciones.add(mensaje);
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("NOMBRE: ").append(this.nombre).append("\n");
        sb.append("DNI: ").append(this.dni).append("\n");
        sb.append(mostrarNotificaciones());
        return sb.toString();
    }
    
    private String mostrarNotificaciones(){
        StringBuilder sb = new StringBuilder();
        for(String notificacion : notificaciones){
            sb.append(notificacion).append("\n");
        }
        return sb.toString();
    }
    
    public abstract void notificar(String notificacion);
}
