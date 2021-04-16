import java.util.Scanner;

public class ClienteNovo extends Cliente {

    /* Construtor */

    public ClienteNovo(String nomeCliente, String numeroCpf, Boolean assinante) {
        super(nomeCliente, numeroCpf, assinante); 
    }
    
    /* Outros métodos */
    
    public void cadastrarCliente(){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Digite o nome do novo cliente: ");
        super.setNome(teclado.next());
        System.out.println("Digite o cpf do novo cliente: ");
        super.setCpf(teclado.next());
        teclado.close();
    }
    
}  
