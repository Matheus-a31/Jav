public class Executar {
    public static void main(String[] args){
        Fazenda farm = new Fazenda();
        farm.setNome("Fazenda Feliz");
        System.out.println(farm.getNome()+"\n");

        Bovino b1 = new Bovino('m');
        b1.setPeso(200);
        b1.setId(1000);
        System.out.println(b1.getId()+";"+b1.getPeso()+";"+b1.getGenero()+"\n");

        Fazenda farm1 = new Fazenda();
        farm1.setNome("Fazenda Feliz");
        Bovino b4 = new Bovino('m');
        b4.setPeso(200);
        b4.setId(1000);
        VacaLeiteira b2 = new VacaLeiteira();
        b2.setPeso(240);
        b2.setId(1001);
        Bovino b3 = new Bovino('F');
        b3.setPeso(180);
        b3.setId(1002);
        farm1.addBovino(b4);
        farm1.addBovino(b2);
        farm1.addBovino(b3);
        System.out.println(farm1.getListaBovinos().size()+"\n");


        Bovino b5 = new Bovino('A');
        b5.setPeso(200);
        b5.setId(1000);
        System.out.println(b5.getId()+";"+b5.getPeso()+";"+b5.getGenero()+"\n");
        

        Fazenda farm2 = new Fazenda();
        farm2.setNome("Fazenda Feliz");
        Bovino b6 = new Bovino('m');
        b6.setPeso(200);
        b6.setId(1000);
        VacaLeiteira b7 = new VacaLeiteira();
        b7.setPeso(240);
        b7.setId(1001);
        Bovino b8 = new Bovino('F');
        b8.setPeso(180);
        b8.setId(1002);
        farm2.addBovino(b6);
        farm2.addBovino(b7);
        farm2.addBovino(b8);
        System.out.println(farm2.getBovino(1002).getPeso()+"\n");
        System.out.println(farm2.getListaBovinos().size()+"\n");

        Bovino b9 = new Bovino('F');
        b9.setPeso(12);
        b9.setId(1005);

        farm2.addBovino(b9);
        System.out.println(farm2.getBovino(1005).getPeso()+"\n");
        System.out.println(b9.getPeso());
        System.out.println(b9.getId());

        System.out.println(farm2.getListaBovinos());

        Fazenda farm50 = new Fazenda();
        farm50.setNome("Fazenda Feliz");
        Bovino b50 = new Bovino('m');
        b50.setPeso(200);
        b50.setId(1000);
        VacaLeiteira b51 = new VacaLeiteira();
        b51.setPeso(240);
        b51.setQuantDiariaLeite(50);
        b51.setId(1001);
        Bovino b52 = new Bovino('F');
        b52.setPeso(180);
        b52.setId(1002);
        farm50.addBovino(b50);
        farm50.addBovino(b51);
        farm50.addBovino(b52);
        for (String linha : farm.getListaBovinos()) {
            System.out.println(linha);
        }
    }
}
