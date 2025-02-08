
class Coordenada {
    private int coordX;
    private int coordY;

    public Coordenada(int coordX, int coordY) {
        if (coordX >= 1 && coordX <= 10) this.coordX = coordX;
        if (coordY >= 1 && coordY <= 10) this.coordY = coordY;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordX(int coordX) {
        if (coordX > 0 && coordX <= 10) {
            this.coordX = coordX;
        }
    }

    public void setCoordY(int coordY) {
        if (coordY > 0 && coordY <= 10) {
            this.coordY = coordY;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Coordenada) {
            Coordenada c = (Coordenada) o;
            return this.coordX == c.coordX && this.coordY == c.coordY;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return coordX * 31 + coordY;
    }
}

class Navio implements Atingivel {
    private boolean[] partes;
    private String nome;
    private Coordenada coordProa;

    public Navio(int totalPartes) {
        if (totalPartes > 1 && totalPartes < 6) {
            partes = new boolean[totalPartes];
            switch (totalPartes) {
                case 2:
                    this.nome = "rebocador";
                    break;
                case 3:
                    this.nome = "contratorpedeiro";
                    break;
                case 4:
                    this.nome = "cruzador";
                    break;
                case 5:
                    this.nome = "porta-avioes";
                    break;
                default:
                    break;
            }
        }
    }

    public int getTamanho() {
        return partes.length;
    }

    public void setCoordProa(Coordenada coordProa) {
        if (coordProa != null && coordProa.getCoordX() > 0 && coordProa.getCoordX() <= 10 && coordProa.getCoordY() > 0 && coordProa.getCoordY() <= 10) {
            this.coordProa = coordProa;
        }
    }

    @Override
    public String atingir(Coordenada coordenada) {
        int index = coordenada.getCoordX() - coordProa.getCoordX();
        if (index >= 0 && index < partes.length) {
            partes[index] = true;

            boolean afundado = true;
            for (boolean parte : partes) {
                if (!parte) {
                    afundado = false;
                    break;
                }
            }
            String msg = afundado ? nome + " destruido!" : "Boom!";
            return msg;
        }
        return "Invalido";
    }

    @Override
    public String exibir(Coordenada coordenada) {
        int index = coordenada.getCoordX() - coordProa.getCoordX();
        if (index >= 0 && index < partes.length) {
            return partes[index] ? "X" : "~";
        }
        return "~";
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean parte : partes) {
            sb.append(parte ? "true" : "false");
        }
        return sb.toString();
    }
}

class BatalhaNaval {
    private Atingivel[][] oceano = new Atingivel[10][10];
    private int totalNavios = 0;

    public BatalhaNaval() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                oceano[i][j] = new Mar(new Coordenada(i + 1, j + 1));
            }
        }
    }

    public int getTotalNavios() {
        return totalNavios;
    }

    public void addNavio(Coordenada coordenada, Navio navio) {
        int x = coordenada.getCoordX() - 1;
        int y = coordenada.getCoordY() - 1;
        if (x + navio.getTamanho() > 10) {
            return;
        }

        for (int i = 0; i < navio.getTamanho(); i++) {
            if (!(oceano[y][x + i] instanceof Mar)) return;
        }

        for (int i = 0; i < navio.getTamanho(); i++) {
            oceano[y][x + i] = navio;
        }
        navio.setCoordProa(coordenada);
        totalNavios++;
    }

    public void exibir() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(oceano[i][j].exibir(new Coordenada(j + 1, i + 1)) + " ");
            }
            System.out.println();
        }
    }

    public void atingir(String tiro) throws TiroInvalidoException {
        if (tiro == null || tiro.length() < 2) {
            throw new TiroInvalidoException("Coordenada de tiro invalida: " + tiro);
        }
        char linha = Character.toUpperCase(tiro.charAt(0));
        int coluna;

        try {
            coluna = Integer.parseInt(tiro.substring(1));
        } catch (NumberFormatException e) {
            throw new TiroInvalidoException("Coordenada de tiro invalida: " + tiro);
        }

        int x = coluna - 1;
        int y = linha - 'A';

        if (x < 0 || x >= 10 || y < 0 || y >= 10) {
            throw new TiroInvalidoException("Coordenada de tiro invalida: " + tiro);
        }

        System.out.println(oceano[y][x].atingir(new Coordenada(x + 1, y + 1)));
    }
}

class Mar implements Atingivel {
    private boolean atingido = false;
    private Coordenada coordenada;

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Mar(Coordenada coordenada) {
        setCoordenada(coordenada);
    }

    @Override
    public String atingir(Coordenada coordenada) {
        atingido = true;
        return "Agua";
    }

    @Override
    public String exibir(Coordenada coordenada) {
        return atingido ? "^" : "~";
    }
}

class TiroInvalidoException extends RuntimeException {
    public TiroInvalidoException(String message) {
        super(message);
    }
}

interface Atingivel {
    String atingir(Coordenada coordenada);
    String exibir(Coordenada coordenada);
}