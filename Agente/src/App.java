public class App {
    public static void main(String[] args) throws Exception {
                    
        Agente a1 = new Agente("Joao Bonde", 9, 7);
        a1.setCodigo(77777);
        a1.setMissao("Passar em POO");
        a1.setDificuldade(7);
        System.out.printf("%s",a1.relatorioDaMissao()+"\n");


        Agente a2 = new Agente("Joao Bonde");
        a2.setCodigo(72772);
        a2.setMissao("Se formar na UFC");
        a2.setDificuldade(8);
        a2.setHabilidade(10);
        a2.setExperiencia(7);
        System.out.println(a2.executarMissao()+"\n");


        Agente a3 = new Agente();
        a3.setNome("Joao Bonde");
        a3.setDificuldade(8);
        a3.setHabilidade(10);
        a3.setExperiencia(7);
        System.out.println(a3.executarMissao()+"\n");


        Agente a4 = new Agente();
        a4.setNome("Joao Bonde");
        a4.setCodigo(73773);
        a4.setMissao("Vencer aquele boss dificil");
        a4.setDificuldade(9);
        a4.setHabilidade(6);
        a4.setExperiencia(5);
        System.out.println(a4.executarMissao()+"\n");


        Agente a5 = new Agente();
        a5.setNome("Joao Bonde");
        a5.setCodigo(74774);
        a5.setMissao("Acordar cedo");
        a5.setDificuldade(7);
        a5.setHabilidade(8);
        a5.setExperiencia(6);
        System.out.println(a5.executarMissao()+"\n");


        Agente a6 = new Agente();
        a6.setDificuldade(-100);
        a6.setHabilidade(-100);
        a6.setExperiencia(-100);
        System.out.println(a6.getExperiencia()+"\n");
        System.out.println(a6.getDificuldade()+"\n");
        System.out.println(a6.getHabilidade());


    }
}
