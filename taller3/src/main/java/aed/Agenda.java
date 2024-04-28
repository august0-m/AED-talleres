package aed;

public class Agenda {
    private Fecha _fecha;
    private ArregloRedimensionableDeRecordatorios _recordatorio;

    public Agenda(Fecha fechaActual) {
        _fecha = fechaActual;
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        _recordatorio.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
       StringBuffer sBuffer = new StringBuffer();

       sBuffer.append(_fecha);
       sBuffer.append("\n");
       sBuffer.append("=====");
       sBuffer.append("\n");
       for (int i=0; i < _recordatorio.longitud() ; i++ ){//no se si esta bien asi
            sBuffer.append(_recordatorio.obtener(i));
            sBuffer.append("\n");
       }
       return sBuffer.toString();

    }

    public void incrementarDia() {
       _fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        return _fecha;
    }

}
