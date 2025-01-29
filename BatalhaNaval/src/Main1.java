public class Main1 {
    public static void main(String[] args) {
        Navio n1 = new Navio(3);
        System.out.println(n1+"\n");

        BatalhaNaval b1 = new BatalhaNaval();
        Navio n3 = new Navio(5);
        b1.addNavio(new Coordenada(1,1), n3);
        b1.exibir();
        System.out.println("\n");

        BatalhaNaval b2 = new BatalhaNaval();
        Navio n4 = new Navio(3);
        b2.addNavio(new Coordenada(1,1), n4);
        b2.exibir();
        System.out.println("\n");

        BatalhaNaval b3 = new BatalhaNaval();
        Navio n5 = new Navio(3);
        b3.addNavio(new Coordenada(1,1), n5);
        try{
            b3.atingir("a1");
            b3.exibir();
        } catch (TiroInvalidoException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n");

        	
        BatalhaNaval b4 = new BatalhaNaval();
        Navio n6 = new Navio(3);
        b4.addNavio(new Coordenada(1,1), n6);
        try{
            b4.atingir("a1");
            b4.atingir("A2");
            b4.atingir("A3");
            b4.exibir();
        } catch (TiroInvalidoException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n");

        BatalhaNaval b5 = new BatalhaNaval();
        Navio n7 = new Navio(2);
        Navio n8 = new Navio(5);
        b5.addNavio(new Coordenada(1,1), n7);
        b5.addNavio(new Coordenada(2,1), n8);
        System.out.println(b5.getTotalNavios());
        System.out.println("\n");

        BatalhaNaval b6 = new BatalhaNaval();
        try{
            b6.atingir("m5");
        } catch (TiroInvalidoException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n");

        	
        BatalhaNaval b7 = new BatalhaNaval();
        try{
            b7.atingir("j5");
            b7.exibir();
        } catch (TiroInvalidoException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n");

        BatalhaNaval b8 = new BatalhaNaval();
        try{
            b8.atingir(null);
        } catch (TiroInvalidoException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n");

        BatalhaNaval b = new BatalhaNaval();
        Navio n2 = new Navio(5);
        b.addNavio(new Coordenada(6,1), n2);
        System.out.println(b.getTotalNavios()+"\n");

        BatalhaNaval b10 = new BatalhaNaval();
        Navio n10 = new Navio(5);
        b10.addNavio(new Coordenada(1,5),n10);
        try{
            b10.atingir("E1");
            b10.atingir("E2");
            b10.atingir("J8");
            b10.atingir("J9");
            b10.atingir("J10");
            b10.exibir();
        } catch (TiroInvalidoException e){
            System.out.println(e.getMessage());
        }

    }
}
