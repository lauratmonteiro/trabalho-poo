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
        try{
            super.setNome(teclado.next());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Digite o cpf do novo cliente: ");
        try{
            super.setCpf(teclado.next());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        teclado.close();
    }
    
}  
