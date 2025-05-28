package Entidades;

/**
 *
 * @author Fabri
 */
public class Habitacion {
    private int numero;
    private TipoHabitacion tipo;
    private double precioPorNoche;

    public Habitacion(int numero, TipoHabitacion tipo, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
    }

    public int getNumero() {
        return numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HABITACION NUMERO:").append(this.numero).append("\n");
        sb.append("TIPO HABITACION:").append(this.tipo).append("\n");
        sb.append("PRECIO POR NOCHE:").append(this.precioPorNoche).append("\n");
        return sb.toString();
    }

    
    @Override
    public boolean equals(Object obj) {
        boolean esIgual = false;
        if(this == obj)
        {
            esIgual = true;
        }else if(obj != null && obj instanceof Habitacion)
        {
            Habitacion otra = (Habitacion)obj;
            if(this.numero==otra.numero)
            {
                esIgual = true;
            }
        }
        return esIgual;
    }   
}
