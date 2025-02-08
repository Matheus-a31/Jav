import java.util.*;

class DAO{
    private HashMap<Integer, Pessoa> pessoas = new HashMap<>();
    private ArrayList<Integer> idProfessores = new ArrayList<>();

    public int getTotalPessoas(){ return pessoas.size(); }

    public void gravarPessoas(Pessoa[] pessoas){
        for(Pessoa pessoa : pessoas) gravarPessoa(pessoa);
    }

    public void gravarPessoa(Pessoa pessoa){
        if (pessoas.containsKey(pessoa.getId())) return;
        pessoas.put(pessoa.getId(), pessoa);

        if(pessoa instanceof Professor) idProfessores.add(pessoa.getId());
    }

    public Professor consultarProfessor(Integer id){
        Pessoa pessoa = consultarPessoa(id);
        if(pessoa instanceof Professor) return (Professor) pessoa;
        return null;
    }
    
    public Pessoa consultarPessoa(Integer id){
        if(pessoas.containsKey(id)) return pessoas.get(id);
        return null;
    }

    public Estudante consultarEstudante(Integer id){
        Pessoa pessoa = consultarPessoa(id);
        if(pessoa instanceof Estudante) return (Estudante) pessoa;
        return null;
    }

    public void removerPessoa(Integer id){
        Pessoa pessoa = pessoas.remove(id);
        if(pessoa == null) return;

        if(pessoa instanceof Professor){
            idProfessores.remove(id);
        }
    }

    public List<String> listarProfessores(){
        List<String> professoresNomes = new ArrayList<>();
        for(Integer id : idProfessores){
            Pessoa pessoa = pessoas.get(id);
            if(pessoa != null) professoresNomes.add(pessoa.getNome());
        }
        return professoresNomes;
    }
}

class Pessoa{
    private Integer id;
    private String nome;

    public Integer getId(){ return id; }
    public void setId(Integer id){
        if(id != null && id > 0) this.id = id;
        else throw new IdInvalidoException();
    }
    
    public String getNome(){ return nome; }
    public void setNome(String nome){
        if(nome != null) this.nome = nome;
    }
}

class Estudante extends Pessoa{
    private int creditos;
    private String curso;
    
    public Estudante(){}
    public Estudante(Integer id, String nome, String curso, int creditos){
        setNome(nome);
        setCurso(curso);
        setId(id);
        setCreditos(creditos);
        
    }
    
    public void setCreditos(int creditos){
        if(creditos <= 0){
            this.creditos = 0;    
            System.out.println("Creditos invalidos!");
        }else this.creditos = creditos;
    }

    public int getCreditos(){ return creditos; }
    
    public String getCurso(){ return curso; }
    public void setCurso(String curso){
        if(curso != null) this.curso = curso;
    }
}

class Professor extends Pessoa{
    private String area;

    public Professor(Integer id, String nome, String area) {
        try{
            setId(id);
        } 
        catch(IdInvalidoException e){
            System.err.println(e.getMessage());
            setId(null); 
        }
    
        setNome(nome);
        setArea(area);
    }

    public String getArea(){ return area; }
    public void setArea(String area){
        if(area != null) this.area = area;
    }
    
    public boolean equals(Object obj){
        if(this == obj) return true; 
        if(obj == null || getClass() != obj.getClass()) return false; 
        
        Pessoa pessoa = (Pessoa) obj;
        return Objects.equals(getNome(), pessoa.getNome());
    }

    public int hashCode(){
        return Objects.hash(getNome());
    }
}

class IdInvalidoException extends RuntimeException{
    public IdInvalidoException(){
        super("Id invalido!");
    }
}

class CreditosInvalidosException extends RuntimeException{
    public CreditosInvalidosException(){
        super("Creditos invalidos!");
    }
}