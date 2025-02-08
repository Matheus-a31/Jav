public class ContaTerminal {
    //atributos da classe conta
    private int numero;
    private String agencia;
    private String nome;
    private double saldo;

    //get e set de numero
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero>0)this.numero = numero;
        else System.out.println("Numero invalido");
    }

    //get e set de agencia
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
    if (agencia.length()==5 && agencia!=null)this.agencia = agencia;
    else System.out.println("Agencia invalida!");
    }
    
    //get e set de nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome!=null)this.nome = nome;
        else System.out.println("Nome invalido!");
    }

    //get e set de saldo
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
        if (saldo>0) System.out.println("Saldo positivo!");
        else if (saldo==0) System.out.println("Saldo zerado!");
        else System.out.println("Saldo negativo!");
    }

    //construtor padrao
    public ContaTerminal(){

    }

    public ContaTerminal(int numero, String agencia, String nome, double saldo) {
        setNumero(numero);
        setAgencia(agencia);
        setNome(nome);
        setSaldo(saldo);
    }

    public static void main(String[] args) throws Exception {

        int numero;
        String agencia;
        String nome;
        double saldo;

        System.out.println("Por favor, digite o número da Conta !");
        numero = Integer.parseInt(System.console().readLine());
        
        System.out.println("\nPor favor, digite o número da Agência!");
        agencia = System.console().readLine();

        System.out.println("\nPor favor, digite o nome do Cliente !");
        nome = System.console().readLine();

        System.out.println("\nPor favor, digite o saldo da Conta !");
        saldo = Double.parseDouble(System.console().readLine());

        ContaTerminal conta = new ContaTerminal(numero, agencia, nome, saldo);
        System.out.println("\nOlá "+conta.getNome()+", obrigado por criar uma conta em nosso banco, sua agência é "+conta.getAgencia()+", conta "+conta.getNumero()+" e seu saldo "+conta.getSaldo()+" já está disponível para saque.");
    }
}
