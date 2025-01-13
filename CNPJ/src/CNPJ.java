public class CNPJ{
    private String cnpj;
    private String empresa;
   
    public void setNomeEmpresa(String empresa){
       if(empresa!=null){
           this.empresa=empresa.toUpperCase();
       }
    }
    public String getNomeEmpresa(){
        return empresa;
    }
    public void setCnpj(String cnpj){
        if(cnpj.length()==14 && validarCnpj(cnpj)==true){
            this.cnpj=cnpj;
        }else{
           this.cnpj=null; 
        }
    }
    public String getCnpj(){
       return cnpj;
    }
    
    public CNPJ(){}
    public CNPJ(String cnpj){
        setCnpj(cnpj);
    }
    
    public boolean validarCnpj(String cnpj){
        if(cnpj.length()==14){
            int[] raiz= new int[14];
            for (int i=0; i<12; i++) {
                 int r = (int)Character.getNumericValue(cnpj.charAt(i));
                 raiz[i]=r;
            }
            int soma1=(raiz[0]*5) + (raiz[1]*4) + (raiz[2]*3) + (raiz[3]*2);
            soma1=soma1+(raiz[4]*9) + (raiz[5]*8)+(raiz[6]*7) + (raiz[7]*6);
            soma1=soma1+(raiz[8]*5) + (raiz[9]*4) +(raiz[10]*3) + (raiz[11]*2);
            int resto1= soma1%11;
            if(resto1==0 || resto1==1){
                raiz[12]=0;
            }else{
                raiz[12]=11-resto1;
            }
            
            int soma2=(raiz[0]*6) + (raiz[1]*5) + (raiz[2]*4) + (raiz[3]*3);
            soma2=soma2+(raiz[4]*2) + (raiz[5]*9)+(raiz[6]*8) + (raiz[7]*7);
            soma2=soma2+(raiz[8]*6) + (raiz[9]*5) +(raiz[10]*4) + (raiz[11]*3)+(raiz[12]*2);
            int resto2= soma2%11;
            
            if(resto2==0 || resto2==1){
                raiz[13]=0;
            }else{
                raiz[13]=11-resto2;
            }
            int n13=(int)Character.getNumericValue(cnpj.charAt(12));
            int n14=(int)Character.getNumericValue(cnpj.charAt(13));
            
            if(n13==raiz[12] && n14==raiz[13]){
                return true;
            }else{
                return false;
            }
            
        }else{
            return false;
        }
    }
 }