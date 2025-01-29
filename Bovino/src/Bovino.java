import java.util.ArrayList;

class Bovino {
    private int id;
    private float peso;
    private String raca;
    private char genero;

    public Bovino() {}

    public Bovino(char genero) {
        setGenero(genero);
    }

    public void setId(int id) {
        if (id >= 1000 && id <= 9999) {
            this.id = id;
        }
    }

    public int getId() {
        return id;
    }

    public void setPeso(float peso) {
        if (peso > 15) {
            this.peso = peso;
        }
    }

    public float getPeso() {
        return peso;
    }

    public void setRaca(String raca) {
        if (raca != null) {
            this.raca = raca;
        }
    }

    public String getRaca() {
        return raca;
    }

    public void setGenero(char genero) {
        genero = Character.toUpperCase(genero);
        if (genero == 'M' || genero == 'F') {
            this.genero = genero;
        }
        else this.genero = 'M';
    }

    public char getGenero() {
        return genero;
    }
}

class VacaLeiteira extends Bovino {
    private int quantDiariaLeite;

    public VacaLeiteira() {
        setGenero('F'); 
    }

    public void setQuantDiariaLeite(int quantDiariaLeite) {
        if (quantDiariaLeite >= 0) {
            this.quantDiariaLeite = quantDiariaLeite;
        }
    }

    public int getQuantDiariaLeite() {
        return quantDiariaLeite;
    }
}

class Fazenda {
    private String nome;
    private ArrayList<Bovino> bovinos = new ArrayList<>();

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void addBovino(Bovino bovino) {
        if (bovino != null) {
            bovinos.add(bovino);
        }
    }

    public ArrayList<String> getListaBovinos() {
        ArrayList<String> lista = new ArrayList<>();
        for (Bovino bovino : bovinos) {
            String info ="ID: "+bovino.getId() + " - PESO: "+ bovino.getPeso() + " - GENERO: " + bovino.getGenero();
            if (bovino instanceof VacaLeiteira) {
                VacaLeiteira vaca = (VacaLeiteira) bovino;
                info += " - PROD LEITE: " + vaca.getQuantDiariaLeite();
            }
            lista.add(info);
        }
        return lista;
    }

    public Bovino getBovino(int id) {
        for (Bovino bovino : bovinos) {
            if (bovino.getId() == id) {
                return bovino;
            }
        }
        return null;
    }
}