package aed;

class Debugging {
    boolean xor (boolean a, boolean b) {
        boolean res= false;
        if (a==true && b==false || a==false && b==true){
            return true;
        }
        return res;
    
    }
    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;

        if(xs.length==ys.length){
         for (int i = 0; i < xs.length; i++) {
                if (xs[i] != ys[i]) {
                    res = false;
            }
        }
    }
        else{
            res=false;}
        
        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;
        if (xs.length==0 || xs.length==1){
            res=true;}
        else{
        for (int i = 0; i < xs.length -1 ; i++) {
            if (xs[i] > xs [i+1]) {
                res = false;
            }
        }
        }
        return res;
    }

    int maximo(int[] xs) {
        int res = xs[0];
        if (xs.length==0 || xs.length==1){
            res=xs[0];}
        else{
            for (int i = 0; i < xs.length; i++) {
                 if (xs[i] >= res) {
                  res = xs[i];}
        }
        }   
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = true;
        if (xs.length==0 || xs.length==1 && xs[0]>=0){
            res=true;}
        else{
         for (int i =0 ;i<xs.length;i++){
            if(xs[i]<= 0){
                return false;
            }
            else{
                res=true;
            }
        }
        }
            return res;
        }
}
