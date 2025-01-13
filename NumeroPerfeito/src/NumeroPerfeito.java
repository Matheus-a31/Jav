public class NumeroPerfeito {
    
    private int valor;
    
    
    public int getValor(){
        if(valor==0){
           return 6;
       }
        return valor;
    }
    public void setValor(int valor){
        int soma=0;
        for(int i=1; i<valor; i++){
            if(valor%i==0){
                soma= soma+i;
            }
        }
        if(soma==valor & valor>0){
            this.valor=valor;
        }else{
            this.valor= 6;
        }
    }
    public NumeroPerfeito(){
        
    }
    public NumeroPerfeito(int valor){
        setValor(valor);
    }

}