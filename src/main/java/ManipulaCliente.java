
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public class ManipulaCliente {
    
    private static List<Cliente> clientes = new ArrayList<Cliente>();
   
    /* ordena clientes em ordem alfabética */
    public static List<Cliente> getClientes() {
        Collections.sort(clientes);
        return clientes;
    }
    
    /*lê os clientes cadastrados */
    public static void leCliente(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        String linha = "";
        linha = br.readLine();
        
        while(linha != null){
            String[] dados = linha.split(";", 6);
            Cliente cliente = new Cliente(
                    dados[0], //nome
                    dados[1], //nacionalidade
                    dados[2], //anoNascimento
                    dados[3], //cpf
                    Boolean.valueOf(dados[4]), //assinante
                    Integer.valueOf(dados[5])); //qtdLivrosAlugados
            clientes.add(cliente);
            linha = br.readLine();
        }

        br.close();
        
    }
    
    /*armazena clientes novos no arquivo de dados*/
    public static void armazenaCliente(String caminhoArquivo) throws IOException {
        Scanner teclado = new Scanner (System.in);
        BufferedWriter br = new BufferedWriter(new FileWriter(caminhoArquivo,  true));
        
        System.out.println("Digite o nome do novo cliente: ");
        String nome = teclado.nextLine();
        br.write(nome);
        br.write(";");
        
        System.out.println("Digite a nacionalidade do novo cliente: ");
        String nacionalidade = teclado.next();
        br.write(nacionalidade);
        br.write(";");
        
        System.out.println("Digite o ano de nascimento do novo cliente: ");
        String ano = teclado.next();
        br.write(ano);
        br.write(";");
        
        System.out.println("Digite o cpf do novo cliente (somente números): ");
        String cpf = teclado.next();
        br.write(cpf);
        br.write(";");
        
        /* Quando o cliente faz o cadastro já obtêm a assinatura da livraria */
        br.write("true");
        br.write(";");
        
        /* Ao se cadastrar a quantidade de livros alugados é nula */
        br.write("0");
        
        br.newLine();
        br.close();
        teclado.close();
        
    }
    
    
    /* public static void removeCliente(String caminhoArquivo) throws IOException { //SE DER TEMPO
    
    }*/
    
    public static void incrementaqtdAlugados(String cpf){
        int pos = buscaCliente(cpf);
        for(int i = 0; i < clientes.size(); i++){
            if(pos == i){
                Integer qtdAlugadosNovo = (clientes.get(i).getQtdLivrosAlugados())+1;
                clientes.get(i).setQtdLivrosAlugados(qtdAlugadosNovo);
            }
        }
    }
    
    /* mostra uma lista com os dados dos clientes cadastrados */
    public static void listarClientes(){
        List<Cliente> clientesOrdenados = new ArrayList<Cliente>();
        System.out.println("--------- Clientes cadastrados ---------- ");
        clientesOrdenados = getClientes();    
        for(Cliente c: clientesOrdenados){
            System.out.println("Nome:"+ c.getNome());
            System.out.println("Nº CPF:"+ c.getCpf());
            System.out.println("Nacionalidade:"+ c.getNacionalidade());
            System.out.println("Ano de nascimento:" + c.getAnoNascimento());
            System.out.println("Quantidade de livros alugados:" + c.getQtdLivrosAlugados());
            System.out.println("\n");
        }
    }
    
    /* busca um determinado cliente pelo seu numero de cpf */
    public static int buscaCliente(String cpfBuscado){
        for(int i = 0; i < clientes.size(); i++){
            if(cpfBuscado.equals(clientes.get(i).getCpf())){
                return i; //posição do cliente no arquivo de dados dos clientes cadastrados
            }
        }
        return - 1; //caso não encontre o cliente
    
    }
    
    /* busca um determinado cliente pelo seu numero de cpf e retorna sua qtd de livros alugados */
    public static int buscaqtdAlugadosCliente(String cpfBuscado){
        int qtd  = 0; 
        for(int i = 0; i < clientes.size(); i++){
            if(cpfBuscado.equals(clientes.get(i).getCpf())){
                qtd = clientes.get(i).getQtdLivrosAlugados(); 
                 
            }
        }
        
        return qtd;
    }
    
    public static void armazenaAlteraçõesCliente()  throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter("dados/clientes.txt"));
        for(int i = 0; i < clientes.size(); i++){
            br.write(clientes.get(i).getNome());
            br.write(";");

            
            br.write(clientes.get(i).getCpf());
            br.write(";");

           
            br.write(clientes.get(i).getAnoNascimento());
            br.write(";");

            
            br.write(clientes.get(i).getNacionalidade());
            br.write(";");

            
            br.write(Boolean.toString(clientes.get(i).getAssinante()));
            br.write(";");

            
            br.write(Integer.toString(clientes.get(i).getQtdLivrosAlugados()));

            br.newLine();
            
        }
        br.close();
    
    }
    
    /*OLHAR DEPOIS*/
   /* 
    // método usado quando a entrada deve ser uma string formada apenas por letras do alfabeto
    public static void validaString(String valor) throws IllegalArgumentException {
        String[] array = valor.split(""); // divide a string em um array onde cada elemento é um caractere
        for (String s : array) {
            int num = Character.getNumericValue(s.toLowerCase().charAt(0));
            if (num < 97 || num > 122 || s == null || s == "") { // caso nao seja uma letra do alfabeto ou seja uma string vazia (null ou "")
                throw new IllegalArgumentException("Entrada inválida! Por favor, tente novamente.");
            }
        }
    }

    public static void validaNumero(String valor) {
        String[] array = valor.split(""); // divide a string em um array onde cada elemento é um caractere
        for (String s : array) {
            List<Integer> numeros = new ArrayList<Integer>();
            numeros.add(1); numeros.add(2); numeros.add(3); numeros.add(4); numeros.add(5);
            numeros.add(6); numeros.add(7); numeros.add(8); numeros.add(9); numeros.add(0);  
            if (s == null || s == "" || !numeros.contains(Integer.parseInt(s))) { // caso seja uma string vazia (null ou "") ou não seja um número de 0 a 9
                throw new IllegalArgumentException("Entrada inválida! Por favor, tente novamente.");
            }
        }
    }*/
}
