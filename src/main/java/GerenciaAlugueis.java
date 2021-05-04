
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
        BufferedReader br = new BufferedReader(new InputStreamReader (new FileInputStream(caminhoArquivo), "UTF-8"));
        String linha = "";
        linha = br.readLine();
        
        while(linha != null){
            String[] dados = linha.split(";", 5);
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
        
        
        br.write("false"); //quando o aluguel é registrado, devolvido é setado como falso
        br.write(";");            
        
        
        br.newLine();
        br.close();
        
        
        /* Faz alterações nos arquivos clientes e livros para as devidas alterações */
        ManipulaCliente.incrementaqtdAlugados(clienteAluguel);
        Catalogo.incrementaqtdAlugados(idLivroAluguel);
        ManipulaCliente.armazenaAlteraçõesCliente();
        Catalogo.armazenaAlteraçõesLivro();

    
    }
    
    public static void armazenaAlteraçõesAlugueis()  throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter("dados/alugueis.txt"));
        for(int i = 0; i < alugueis.size(); i++){
            br.write(alugueis.get(i).getCpfCliente());
            br.write(";");
            
            br.write(Integer.toString(alugueis.get(i).getIdLivro()));
            br.write(";");

            br.write(alugueis.get(i).getDataAluguel());
            br.write(";");

            br.write(alugueis.get(i).getDataEntrega());
            br.write(";");
            
            br.write("true");
            br.newLine();
            
        }
        br.close();
    
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
   
    public static void avaliarLivro(Livro livro, Integer nota) {
        livro.avaliar(nota); //adiciona nota ao livro
        Livraria.buscaAutor(livro.getIdAutor()).avaliar(nota); //atribui ao autor tbm
    }
    
    /* método para devolver um livro */
    public static void devolverLivro() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente que realizou o aluguel");
        String cpf = input.next();
        System.out.println("Digite o ID do livro alugado");
        Integer id = input.nextInt();
        //buscar pela linha no arquivo de alugueis onde tem o msm cpf e o msm id 
        for(int i = 0; i < alugueis.size(); i++){
            if(alugueis.get(i).getCpfCliente().equals(cpf) && alugueis.get(i).getIdLivro() == id){
                alugueis.get(i).setDevolvido(true); //muda o estado do livro para devolvido 
            }
        }
        
        /* grava mudanças no arquivo alugueis */
        armazenaAlteraçõesAlugueis();
        
        /* decrementa quantidade de livros alugados do cliente */
        ManipulaCliente.decrementaqtdAlugados(cpf);
        
        /*decrementa a quantidade alugados do livro */
        Catalogo.decrementaqtdAlugados(id);
        
       
        /* setar avaliação */
        System.out.println("Gostaria de avaliar o livro? Digite Sim ou Não.\n");
        String resposta = input.next();
        switch (resposta) {
            case "Sim": 
                System.out.println("Numa escala de 1 a 5, o quanto você gostou do livro?\n");
                int nota = input.nextInt();
                Livro livro = Livraria.buscaLivro(id);
                avaliarLivro(livro,nota);
                System.out.println("Avaliação feita com sucesso.Obrigada e volte sempre!");
                break;
            case "Não":
                System.out.println("Obrigada por utilizar nosso serviço, volte sempre!\n"); 
                break;
        }
        
        /* grava alterações no arquivo clientes, livros e autor */
        ManipulaCliente.armazenaAlteraçõesCliente();
        Catalogo.armazenaAlteraçõesLivro();
        Catalogo.armazenaAlteraçõesAutor();
        
        
    }
    
    /*  método para alugar um livro  */
    public static void alugarLivro() {
        Scanner teclado = new Scanner (System.in);
        System.out.println("Digite o cpf do cliente para verificar se a locação de livros está disponível: ");
        String cpfCliente = teclado.next();
        int qtd = ManipulaCliente.buscaqtdAlugadosCliente(cpfCliente);
        if (qtd == GerenciaAlugueis.getMAX_LIVROS()) { // Caso o cliente ja tenha o numero maximo de livros alugados
            System.out.println("Não é possível alugar o livro pois o cliente atingiu o limite de livros alugados simultaneamente.\nEfetue as devoluções pendentes e volte a alugar conosco!");
        }
        else{
            System.out.println("---------- Realiza aluguel ----------------");
            try{
                GerenciaAlugueis.armazenaAluguel("dados/alugueis.txt");
                System.out.println("Aluguel efetuado com sucesso!");
            }catch(IOException erro){
                    System.out.println("Erro na realização do Aluguel. Tente novamente!");
            }
        }
       
    }

   
     
}
