public class App {
    public static void main(String[] args){
        
        NumeroPerfeito perfeito1 = new NumeroPerfeito();
        System.out.println(perfeito1.getValor()+"\n");

        NumeroPerfeito perfeito2 = new NumeroPerfeito(28);
        System.out.println(perfeito2.getValor()+"\n");
    
        NumeroPerfeito perfeito3 = new NumeroPerfeito();
        perfeito3.setValor(28);
        System.out.println(perfeito3.getValor()+"\n");

        NumeroPerfeito perfeito4 = new NumeroPerfeito(10);
        System.out.println(perfeito4.getValor()+"\n");

        NumeroPerfeito perfeito5 = new NumeroPerfeito(496);
        System.out.println(perfeito5.getValor()+"\n");

        NumeroPerfeito perfeito6 = new NumeroPerfeito();
        perfeito6.setValor(8128);
        System.out.println(perfeito6.getValor()+"\n");
    }
}
