package aed;

public class Agenda {
    private Fecha _fecha;
    private ArregloRedimensionableDeRecordatorios _recordatorio;

    public Agenda(Fecha fechaActual) {
        this._fecha = fechaActual;
        this._recordatorio = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this._recordatorio.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(fechaActual().toString());
        sBuffer.append("\n=====\n");
        for (int i = 0;i<this._recordatorio.longitud();i++){
            if (_recordatorio.obtener(i).fecha().equals(this.fechaActual())){
                sBuffer.append(_recordatorio.obtener(i).toString()+"\n");
            }

        }
        return sBuffer.toString();
    }
      // StringBuffer sBuffer = new StringBuffer();

       //sBuffer.append(_fecha);
       //sBuffer.append("\n");
       //sBuffer.append("=====");
       //sBuffer.append("\n");
       //for (int i=0; i < _recordatorio.longitud() ; i++ ){//no se si esta bien asi
        //    sBuffer.append(_recordatorio.obtener(i));
        //    sBuffer.append("\n");
       //}
       //return sBuffer.toString();

//    }

    public void incrementarDia() {
      this._fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        return this._fecha;
    }

}
