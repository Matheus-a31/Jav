class IdInvalidoException extends RuntimeException {
    public IdInvalidoException(String mensagem) {
        super(mensagem);
    }
}

class CreditosInvalidosException extends RuntimeException {
    public CreditosInvalidosException(String mensagem) {
        super(mensagem);
    }
}

abstract class Pessoa {
    private Integer id;
    private String nome;

    public Pessoa(Integer id, String nome) {
        if (id <= 0) {
            throw new IdInvalidoException("Id inválido!");
        }
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id <= 0) {
            throw new IdInvalidoException("Id inválido!");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pessoa pessoa = (Pessoa) obj;
        return id.equals(pessoa.id);
    }
}


class Estudante extends Pessoa {
    private int creditos;
    private String curso;

    public Estudante(Integer id, String nome, String curso, int creditos) {
        super(id, nome);
        if (creditos <= 0) {
            throw new CreditosInvalidosException("Créditos inválidos!");
        }
        this.creditos = creditos;
        this.curso = curso;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        if (creditos <= 0) {
            throw new CreditosInvalidosException("Créditos inválidos!");
        }
        this.creditos = creditos;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}


class Professor extends Pessoa {
    private String area;

    public Professor(Integer id, String nome, String area) {
        super(id, nome);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

import java.util.*;

class DAO {
    private HashMap<Integer, Pessoa> pessoas = new HashMap<>();
    private ArrayList<Integer> idProfessores = new ArrayList<>();

    public int getTotalPessoas() {
        return pessoas.size();
    }

    public void gravarPessoas(List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            this.pessoas.put(pessoa.getId(), pessoa);
            if (pessoa instanceof Professor) {
                idProfessores.add(pessoa.getId());
            }
        }
    }

    public void gravarPessoa(Pessoa pessoa) {
        this.pessoas.put(pessoa.getId(), pessoa);
        if (pessoa instanceof Professor) {
            idProfessores.add(pessoa.getId());
        }
    }

    public Pessoa consultarPessoa(int id) {
        return pessoas.get(id);
    }

    public Professor consultarProfessor(int id) {
        Pessoa pessoa = pessoas.get(id);
        if (pessoa instanceof Professor) {
            return (Professor) pessoa;
        }
        return null;
    }

    public Estudante consultarEstudante(int id) {
        Pessoa pessoa = pessoas.get(id);
        if (pessoa instanceof Estudante) {
            return (Estudante) pessoa;
        }
        return null;
    }

    public void removerPessoa(int id) {
        Pessoa pessoa = pessoas.remove(id);
        if (pessoa instanceof Professor) {
            idProfessores.remove(Integer.valueOf(id));
        }
    }

    public void removerPessoa(Pessoa pessoa) {
        removerPessoa(pessoa.getId());
    }

    public ArrayList<String> listarProfessores() {
        ArrayList<String> lista = new ArrayList<>();
        for (Integer id : idProfessores) {
            lista.add(pessoas.get(id).getNome());
        }
        return lista;
    }
}
