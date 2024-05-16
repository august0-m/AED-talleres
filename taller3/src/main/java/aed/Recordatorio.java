package aed;

public class Recordatorio {
    private String _mensaje;
    private Fecha _fecha;
    private Horario _horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        mensaje = _mensaje;
        fecha = new Fecha(fecha.dia(),fecha.mes());
        horario = _horario; 
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
        return String.valueOf(_mensaje) + "@" + String.valueOf(_fecha) + String.valueOf(_horario);
        //return sBuffer.toString();
    }

    @Override
    public boolean equals(Object otro) {
        boolean res = false;
        boolean noex = (otro == null);
        boolean distinta_clase = (otro.getClass() != this.getClass());
        if (distinta_clase || noex){
            return false;
        }
        boolean mismo_msj = ((Recordatorio)otro).mensaje() == this.mensaje();
        boolean misma_fecha = ((Recordatorio)otro).fecha() == this.fecha();
        boolean mismo_horario = ((Recordatorio)otro).horario() == this.horario();
        if(mismo_horario && misma_fecha && mismo_msj){
            res = true;
        }
        else{
            res=false;
        }
        return res;
    }

}