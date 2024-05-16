package aed;

public class Recordatorio {
    private String _mensaje;
    private Fecha _fecha;
    private Horario _horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        _mensaje = mensaje;
        _fecha = new Fecha(fecha.dia(),fecha.mes());
        _horario = horario; 
    }

    public Horario horario() {
        return _horario;
    }

    public Fecha fecha() {
        Fecha lafecha = new Fecha(_fecha.dia(),_fecha.mes());
        return lafecha;
       // return  (new Fecha(this.fecha()));
    }

    public String mensaje() {
        return _mensaje;
    }

    @Override
    public String toString() {  //se puede hacer de otras manera tmb
        //StringBuffer sBuffer = new StringBuffer();
        //sBuffer.append(_mensaje);
        //sBuffer.append("@");
        //sBuffer.append(_fecha);
        //sBuffer.append(_horario);
        return String.valueOf(_mensaje)+" " + "@" +" "+ String.valueOf(_fecha)+" " + String.valueOf(_horario);
        //return sBuffer.toString();
    }

    @Override
    public boolean equals(Object otro) {
        Recordatorio eldistinto= (Recordatorio) otro;
       // boolean res= false;
        //boolean noex = (otro == null);
        //boolean oed = otro.getClass() != this.getClass();
        if (this== otro){
            return true;
        }
        if( otro==null || otro.getClass()!=this.getClass()){
            return false;
        }
       // Recordatorio eldistinto= (Recordatorio) otro;

        boolean mismo_horario = (this.horario().equals(eldistinto.horario()));
        boolean misma_fecha = (this.fecha().equals(eldistinto.fecha()));
        boolean mismo_msj = (this.mensaje().equals(eldistinto.mensaje()));
        return mismo_horario && misma_fecha && mismo_msj;
       
  
    }


}