package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private Recordatorio[] _recordatorio;


    public ArregloRedimensionableDeRecordatorios() {
        return ArregloRedimensionableDeRecordatorios._recordatorio();
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public int longitud() {
        return _recordatorio.length;
    }

    public void agregarAtras(Recordatorio i) {          
        throw new UnsupportedOperationException("No implementada aun") ;
   //   Recordatorio seqinicial = this._recordatorio();
     // Recordatorio seqnueva = new Recordatorio(null, null, null);
      //seqnueva.lenght = seqinicial.lenght +1;
      //int longnueva = _recordatorio.length + 1;
      


    }

    public Recordatorio obtener(int i) {
        return _recordatorio[i];
    }

    public void quitarAtras() { //dudosisimo
        _recordatorio[(_recordatorio.length) - 1 ] = null; 
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        _recordatorio[indice]= valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
   //     ArregloRedimensionableDeRecordatorios res
    throw new UnsupportedOperationException("No implementada aun") ;
    }

}
