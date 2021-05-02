
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class GerenciaAlugueis {
    
    public static final int MAX_LIVROS = 5;
    
    public static int getMAX_LIVROS() {
        return MAX_LIVROS;
    }
    
    private static ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
    
    
    public static ArrayList<Aluguel> getAlugueis() {
        return alugueis;
    }
     
    public static void leAlugueis (String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        String linha = "";
        linha = br.readLine();
        
        while(linha != null){
            String[] dados = linha.split(";", 4);
            Aluguel aluguel = new Aluguel(
                    dados[0], //cpf Cliente
                    Integer.valueOf(dados[1]), //id Livro
                    dados[2], //data aluguel
                    dados[3], //data entrega
                    Boolean.valueOf(dados[4])); //devolvido
          
            alugueis.add(aluguel);
            linha = br.readLine();
        }

        br.close();
        
    }
    
    public static void armazenaAluguel (String caminhoArquivo) throws IOException {
        Scanner teclado = new Scanner (System.in);
        BufferedWriter br = new BufferedWriter(new FileWriter(caminhoArquivo,  true));
        
        System.out.println("Digite o CPF do cliente que realizará o aluguel:");
        String clienteAluguel = teclado.next();
        
        br.write(clienteAluguel);
        br.write(";");            
        
        System.out.println("Digite o ID do livro que será alugado: ");
        Integer idLivroAluguel = teclado.nextInt();
        br.write(Integer.toString(idLivroAluguel));
        br.write(";");            
        
        System.out.println("Insira a data do aluguel (formato dd/mm/aaaa): ");
        String dataAluguel = teclado.next();
        br.write(dataAluguel);
        br.write(";");            
        
        System.out.println("Insira a data de entrega (formato dd/mm/aaaa): ");
        String dataEntrega = teclado.next();
        br.write(dataEntrega);
        br.write(";");            
        ;
        
        br.write("false"); //quando o aluguel é registrado, devolvido é setado como falso
        br.write(";");            
        ;
        
        br.newLine();
        br.close();
        teclado.close();
        
        /* Faz alterações nos arquivos clientes e livros para as devidas alterações */
        ManipulaCliente.incrementaqtdAlugados(clienteAluguel);
        Catalogo.incrementaqtdAlugados(idLivroAluguel);
        ManipulaCliente.armazenaAlteraçõesCliente();
        Catalogo.armazenaAlteraçõesLivro();
        
         

    
    }
    
    public static void listaAlugueis(){
        System.out.println("--------- Alugueis realizados ---------- ");  
        for(Aluguel a: alugueis){
            System.out.println("Cpf cliente: :"+ a.getCpfCliente());
            System.out.println("ID do livro alugado:"+ a.getIdLivro());
            System.out.println("Data de aluguel:" + a.getDataAluguel());
            System.out.println("Data de entrega: " + a.getDataEntrega());
            System.out.println("Devolvido: " + a.getDevolvido());
            System.out.println("\n");
        }
    
    }
    
    
    
     
}
