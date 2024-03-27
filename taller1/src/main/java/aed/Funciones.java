package aed;

class Funciones {
    int cuadrado(int x) {
        int res;
        res = x*x ;
       return res;
    }

    double distancia(double x, double y) {
        double res;
        res = Math.sqrt ((x*x) + (y*y));
    
        return res;
    }

    boolean esPar(int n) {
        boolean res ;
        if (n % 2  == 0){
        res= true;
       }
        else {
            res= false;
    }
    return res;
    }

    boolean esBisiesto(int n) {  //no da el 2000 no se xq rehacer si pongo otro if con la segunda condicion no funciona, preguntar porque
        boolean res ;
        if(n % 400 == 0 || n % 4 == 0 && n % 100 != 0){
            res= true;
        }
        else {
            res= false;
        }
        return res;
        }

    int factorialIterativo(int n) { //si llamas a -res- una y otra vez no lo sobreescribe sino que lo guarda
        int res=1;
        for(int i=1 ;i<=n;i++){
            res=i*res; // si pongo res= i*(i+1) esta mal porq se sobreescribe y res sería=n*(n-1)
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res ;
        if (n==0){
            res= 1;
        }
        else {
            res= n* (factorialRecursivo(n-1));
        }
        return res;
    }
    boolean esPrimo(int n){
        boolean res=true;
        int sumar=1;
        if (n==1 || n==0){
            res=false;
        }
        for(int i=2;i<=n;i++)
            if(n % i==0){
                sumar+=1;
            }
        if (sumar>2){
            res=false;
        if (sumar<=2){
            res=true;
        }
        }
        return res;
    }

    int sumatoria(int[] numeros) {
        int res=0;
        for (int x:numeros){
            res= res + x;
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res=0;
        for(int i= 0; i< numeros.length;i++){
            if(numeros[i]==buscado){
            res=i;
        
            }}
        return res;
    }
    
    boolean tienePrimo(int[] numeros) { 
        boolean res=false;
        for (int i=0;i<numeros.length;i++){
            if(esPrimo(numeros[i])== true) {
            res= true;
            }
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res= true;
        for(int i=0;i<numeros.length;i++){
            if (esPar(numeros[i])!= true)
            res=false;
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res=false;
        if (s1.length() > s2.length()){
            return false; //porque si pongo res=false no corta y se mete en el for??
        }
        for(int i=0, j=0;i<s1.length();i++ , j++){   //no tiene sentido  agregar a j se puede usar solo con i pero estaba probando usar 2 variables
                if (s1.charAt(i)==s2.charAt(j)){
                        res=true;
                }
                else{
                    res=false;
                }
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) { // preguntar pq no, y pq funciona ocn i positiva y en charAt(s1.length()-i-1 (como dice la consigna creo xd))
        boolean res=true;
        if (s1.length() > s2.length()){
            return false;
        }
        for(int i=0;i <s1.length();i++){   
            if (s1.charAt(s1.length()-1-i)==s2.charAt(s2.length()-1-i)){
                    res=true;
            }
            else{ 
                return false;
            }
        }
    
        return res;
    }
}