public class App {
    public static void main(String[] args) throws Exception {

        CNPJ cnpj1 = new CNPJ();
        cnpj1.setNomeEmpresa("Universidade Federal do Ceara");
        System.out.println(cnpj1.getNomeEmpresa());
        

        CNPJ cnpj2 = new CNPJ();
        cnpj1.setCnpj("07272636000131");
        System.out.println(cnpj2.getCnpj());
       

        CNPJ cnpj3 = new CNPJ();
        cnpj3.setCnpj("07272636000121");
        System.out.println(cnpj3.getCnpj());
        

        CNPJ cnpj4 = new CNPJ();
        System.out.println(cnpj4.validarCnpj("24365710000183"));
        

        CNPJ cnpj5 = new CNPJ();
        System.out.println(cnpj5.validarCnpj("243657183"));
        

        CNPJ cnpj6 = new CNPJ();
        cnpj6.setCnpj("00776574000166");
        System.out.println(cnpj6.getCnpj());
        

        CNPJ cnpj7 = new CNPJ();
        System.out.println(cnpj7.validarCnpj("0077657400096"));
       

        CNPJ cnpj8 = new CNPJ("24365710000183");
        System.out.println(cnpj8.getCnpj());
        

        CNPJ cnpj9 = new CNPJ("07272636000131");
        System.out.println(cnpj9.getCnpj());
    }
}
