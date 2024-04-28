package aed;

public class Horario {

    private int _hora ;
    private int _min  ;

    public Horario(int hora, int minutos) {
        _hora = hora;
        _min = minutos;
    }

    public int hora() {
        return _hora;
    }

    public int minutos() {
       return _min;
    }

    @Override
    public String toString() {
        return String.valueOf(_hora) + ":" + String.valueOf(_min);
    }

    @Override
    public boolean equals(Object otro) {
        boolean res = false;
        boolean oed = otro.getClass() != this.getClass();
        boolean noex = (otro == null);
        if( oed || noex){
            return false;
        }
         boolean igual_min = ((Horario)otro).minutos()==this.minutos();
         boolean igual_hora = ((Horario)otro).hora() == this.hora();
         if (igual_min && igual_hora){
            res = true;
        }
        else{
            res= false;
        }
        return res;


    }

}
