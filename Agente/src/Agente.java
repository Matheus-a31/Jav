public class Agente{
    private String nome;
    private String missao;
    private int habilidade;
    private int experiencia;
    private int dificuldade;
    private int codigo;
    
    public void setNome(String nome){
        if(nome!=null){
            this.nome=nome;
        }else{
            this.nome=null;
        }
    }
    
    public void setMissao(String missao){
        if(missao!=null){
            this.missao=missao;
        }else{
            this.missao=null;
        }
    }
    
    public void setHabilidade(int habilidade){
        if(habilidade>0 && habilidade<=10){
            this.habilidade=habilidade;
        }else{
            this.habilidade=0;
        }
    }
    
    public void setExperiencia(int experiencia){
        if(experiencia>0 && experiencia<=10){
            this.experiencia=experiencia;
        }else{
            this.experiencia=0;
        }
    }
    
    public void setDificuldade(int dificuldade){
        if(dificuldade>0 && dificuldade<=10){
            this.dificuldade=dificuldade;
        }else{
            this.dificuldade=0;
        }
    }
    
    public void setCodigo(int codigo){
        if(codigo>0){
            this.codigo=codigo;
        }else{
            this.codigo=0;
        }
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getMissao(){
        return missao;
    }
    
    public int getHabilidade(){
        return habilidade;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public int getDificuldade(){
        return dificuldade;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String relatorioDaMissao(){
        String nome = "Nome: "+getNome();
        String missao = "\nMissao: "+getMissao();
        String codigo = "\nCodigo: "+getCodigo();
        String dificuldade = "\nDificuldade: "+getDificuldade();
        String habilidade = "\nHabilidade: "+getHabilidade();
        String experiencia = "\nExperiencia: "+getExperiencia();
        
        return "---Relatorio---\n"+nome+codigo+missao+dificuldade+habilidade+experiencia;

    }
    
    public String executarMissao(){
        if(getMissao()!=null && getCodigo()>0){
            if(getHabilidade()+getExperiencia()>2*getDificuldade()){
                return "A missao foi um sucesso!";
            }else if(getHabilidade()+getExperiencia()<2*getDificuldade()){
                return  "A missao fracassou!";
            }else{
                return "Inconclusivo";
            }
        }else{
            return "Sem missao!";
        }
    }
    
    
    public Agente(){
        
    }
    public Agente(String nome, int habilidade, int experiencia){
        setNome(nome);
        setHabilidade(habilidade);
        setExperiencia(experiencia);
    }
    public Agente(String nome){
        setNome(nome);
    }
    
}