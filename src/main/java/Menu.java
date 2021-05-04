import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu { // classe para interação com o usuário
    
    public static void mostraMenuCliente() {
       
        System.out.println("------------------- MENU ------------------------------");
        System.out.println("1 - Buscar por um livro"); 
        System.out.println("2 - Ver livros recomendados");
        System.out.println("3 - Ver autores recomendados");
        System.out.println("0 - Encerrar programa");
        System.out.println("------------------------------------------------------");
        
    }
    
    public static void mostraMenuFuncionario() {
            System.out.println("------------------- MENU ------------------------------");
            System.out.println("Escolha uma das opções abaixo: ");
            System.out.println("1 - Cadastrar novo cliente"); 
            System.out.println("2 - Ver clientes cadastrados"); 
            System.out.println("3 - Buscar por um livro");
            System.out.println("4 - Alugar um livro"); 
            System.out.println("5 - Devolver um livro"); 
            System.out.println("6 - Adicionar novo livro ao catálogo");
            System.out.println("7 - Adicionar novo autor ao catálogo");
            System.out.println("8 - Adicionar nova editora ao catálogo");
            System.out.println("0 - Encerrar programa");
            System.out.println("------------------------------------------------------");
    }

    // método genérico auxiliar para imprimir listas de objetos
    public static void imprimeLista(List<?> lista) {
        for(Object elemento : lista){
            System.out.println(elemento);
        }
    }

    // método usado para realizar uma busca no catálogo
    public static void busca() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Pelo que deseja buscar?\n" + 
                            "1 - Título do livro\n" + 
                            "2 - Nome do autor\n" +
                            "3 - Nome da editora\n" +
                            "4 - Gênero do livro\n");
        
        int op = teclado.nextInt();
        teclado.nextLine();
        while (op != 1 && op != 2 && op != 3 && op != 4) { // se a entrada não for uma das opções
            System.out.println("Impossível realizar esta ação. Por favor, escolha uma opção válida");
            op = teclado.nextInt();
            teclado.nextLine();
        }
        switch (op) {
            case 1: 
                System.out.println("Insira o título do livro: ");
                String str1 = teclado.nextLine();
                
                try{
                    String buscado = Livraria.buscaLivro(str1).toString();// encontra e imprime o livro 
                    System.out.printf("%s", buscado);
                }catch(Exception e){
                    System.out.println("Livro não encontrado");
                } 
                break; 
            case 2:
                System.out.println("Insira o nome do autor: ");
                String str = teclado.nextLine();
                try{
                    imprimeLista(Livraria.buscarLivros(Livraria.buscaAutor(str)));// encontra e imprime os livros
                }catch(Exception e){
                    System.out.println("Autor não encontrado");
                } 
                break; 
            case 3:
                System.out.println("Insira o nome da editora: ");
                String str3 = teclado.nextLine();
                try{
                    imprimeLista(Livraria.buscarLivros(Livraria.buscaEditora(str3)));// encontra e imprime os livros
                }catch(Exception e){
                    System.out.println("Editora não encontrada");
                } 
                break; 
            case 4: 
                System.out.println("Insira o gênero: ");    
                String str4 = teclado.nextLine();
                try{
                    imprimeLista(Livraria.buscarLivros(str4));// encontra e imprime os livros
                }catch(Exception e){
                    System.out.println("Gênero não encontrada");
                } 
                break; 
        }
        
        
    }
   

   
    public static void main(String[] args) {
        // le os dados dos arquivos
        Livraria.inicializaCatalogo();
        Livraria.inicializaClientes();
        Livraria.inicializaAlugueis();
        
        
        Scanner teclado = new Scanner(System.in);
        int escolha = 0;
        System.out.println("--------------------------------------------------");
        System.out.println("------------- LIVRARIA PARTILHAR -----------------");
        System.out.println("--------------------------------------------------");
        System.out.println("1 - Funcionário");
        System.out.println("2 - Cliente ");
        System.out.println("Digite sua escolha: ");
        
        escolha = teclado.nextInt();
       
        
        
        if(escolha == 1){
            mostraMenuFuncionario();
            int opcao = 0;
            System.out.println("Digite a opção escolhida: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            while(opcao != 0) {
                System.out.println("\n--------------------------------------------------\n"); // padrao: 50 '-'
                while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5 && opcao != 6 && opcao != 7 && opcao != 8 && opcao != 0) { // se a entrada não for uma das opções
                    System.out.println("Impossível realizar esta ação. Por favor, escolha uma opção válida");
                    mostraMenuFuncionario();
                    opcao = teclado.nextInt();
                    
                }
                // roda o programa
                switch (opcao) {
                    case 0: break;
                    case 1:
                        try {
                            ManipulaCliente.armazenaCliente("dados/clientes.txt");
                            System.out.println("Cliente cadastrado com sucesso!\n");
                        } catch (IOException e) {
                            System.out.println("Não foi possível cadastrar o novo cliente!\n");
                        }
                        break;
                    case 2: 
                        ManipulaCliente.listarClientes();
                        break;
                    case 3:
                        busca();
                        break;
                    case 4:
                        GerenciaAlugueis.alugarLivro();
                        break;
                    case 5:
                        try{
                            GerenciaAlugueis.devolverLivro();
                        }catch(IOException erro){
                            System.out.println("Erro na devolução");
                        }
                        break;
                    
                    case 6:
                        try{
                            Catalogo.adicionaNovoLivro();
                        }catch(IOException erro){

                        } 
                        break;
                    case 7:
                        try{
                            Catalogo.adicionaNovoAutor();
                        }catch(IOException erro){
                            System.out.println("Erro ao adicionar novo autor!");
                        }
                        break;
                    case 8:
                        try{
                            Catalogo.adicionaNovaEditora();
                        }catch(IOException erro){
                            System.out.println("Erro ao adicionar novo autor!");
                        }
                        break;
                }
                
                mostraMenuFuncionario();
                System.out.println("Digite a opção escolhida: ");
                opcao = teclado.nextInt();
                teclado.nextLine();
            }
        }
        if(escolha == 2){
            mostraMenuCliente();
            int opcao1 = 0;
            System.out.println("Digite a opção escolhida: ");
            opcao1 = teclado.nextInt();
            teclado.nextLine();

            while(opcao1 != 0) {
                System.out.println("\n--------------------------------------------------\n"); // padrao: 50 '-'
                while (opcao1 != 1 && opcao1 != 2 && opcao1 != 3 && opcao1 != 4 && opcao1 != 5 && opcao1 != 6 && opcao1 != 7 && opcao1 != 0) { // se a entrada não for uma das opções
                    System.out.println("Impossível realizar esta ação. Por favor, escolha uma opção válida");
                    mostraMenuCliente();
                    opcao1 = teclado.nextInt();
                    
                }
                // roda o programa
                switch (opcao1) {
                    case 0: break;
                    case 1:
                        busca();
                        break;
                    case 2:
                        Recomendacao.recomendaLivros(); 
                        break;
                    case 3:
                        Recomendacao.recomendaAutores(); 
                        break;
                }
                mostraMenuCliente();
                System.out.println("Digite a opção escolhida: ");
                opcao1 = teclado.nextInt();
                teclado.nextLine();
                
            }
        }
        
    teclado.close();     
    }
      

}
