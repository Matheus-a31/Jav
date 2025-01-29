public class Main {
    public static void main(String[] args){
        DAO dao1 = new DAO();
        Professor p5 = new Professor(12,"Marcos Vinicius","ES");
        Estudante p6 = new Estudante(2,"Huguinho","ES",100);
        Estudante p7 = new Estudante(5,"Zezinho","CC",10);
        Estudante p8 = new Estudante(7,"Luizinho","ES",10);
        Pessoa[] pm = {p5,p6,p7,p8};
        dao1.gravarPessoas(pm);
        System.out.println(dao1.consultarPessoa(5).getNome());
        
        DAO dao3 = new DAO();
        Professor p9 = new Professor(12,"Marcos Vinicius","ES");
        Estudante p10 = new Estudante(2,"Huguinho","ES",100);
        Estudante p11 = new Estudante(5,"Zezinho","CC",10);
        Estudante p12 = new Estudante(7,"Luizinho","ES",10);
        Pessoa[] pa = {p9,p10,p11,p12};
        dao3.gravarPessoas(pa);
        System.out.println(dao3.consultarProfessor(5));

    }
}
