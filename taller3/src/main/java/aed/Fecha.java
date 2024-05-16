package aed;

public class Fecha {
    private int _mes;
    private int _dia;
    public Fecha(int dia, int mes) {
       _dia = dia;
       _mes = mes;

    }

    public Fecha(Fecha fecha) {
       _dia= fecha._dia;
       _mes= fecha._mes;
    }

    public Integer dia() {
        return _dia ;
    }

    public Integer mes() {
        return _mes ;
    }

    public String toString() {
            return String.valueOf(_dia) + "/" + String.valueOf(_mes);

    }

    @Override
    public boolean equals(Object otra) {
        boolean res = false;
        boolean laclase = otra.getClass() != this.getClass();
        boolean oed =(otra ==null);
        if (oed || laclase){
            return false;
        }
        boolean igualmes = ((Fecha)otra).mes() == this.mes();
        boolean igualdia = ((Fecha)otra).dia() == this.dia();
         if (igualmes && igualdia){
            res= true;
         }
         return res;

    }

    public void incrementarDia() {
        if(_mes==12 && _dia==31){
            _mes=1;
            _dia=1;
        }
        else
        {
            if(_dia < diasEnMes(_mes)){
                _dia= _dia + 1 ;
            }
            else{
                _mes = _mes +1; 
                _dia= 1;
            }
        }
    }


    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}