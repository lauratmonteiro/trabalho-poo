import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu { // classe para interação com o usuário

    private static void mostraMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1 - Cadastrar novo cliente"); 
        System.out.println("2 - Ver clientes cadastrados"); 
        System.out.println("3 - Buscar por um livro"); 
        System.out.println("4 - Alugar um livro"); 
        System.out.println("5 - Devolver um livro"); //resolver
        System.out.println("6 - Ver livros recomendados");
        System.out.println("7 - Ver autores recomendados");
        System.out.println("0 - Encerrar programa");
        System.out.println("--------------------------------------------------");
    }

    /* MÉTODOS PARA MOSTRAR DADOS */

    // mostra uma lista enumerada com todos os clientes cadastrados (identificados pelo nome)
    /*public static void listarClientes() {
        int num = 1;
        System.out.println("--------------------------------------------------");
        System.out.println("Mostrando clientes...");
        for (Cliente c : Catalogo.getClientes()) {
            System.out.println(num + " - " + c.getNome());
            num++;
        }
        System.out.println("--------------------------------------------------");
    }*/

    // mostra uma lista enumerada com todos os alugueis cadastrados
   /* public static void listarAlugueis() {
        int num = 1;
        System.out.println("--------------------------------------------------");
        System.out.println("Mostrando alugueis...");
        for (Aluguel a : Livraria.getAlugueis()) {
            System.out.println("--- Aluguel nº " + num + " ---");
            System.out.println("Cliente: " + a.getCliente().getNome());
            System.out.println("Livro: " + a.getLivro().getTitulo());
            num++;
        }
        System.out.println("--------------------------------------------------");
    } */ 

    // mostra uma lista enumerada com todos os livros (com todas informações)
   /* public static void listarLivros() {
        int num = 1;
        System.out.println("--------------------------------------------------");
        System.out.println("Mostrando livros...\n");
        for (Livro l : Livraria.livrosCatalogo()) {
            System.out.println("---------- Livro nº " + num + " ----------");
            System.out.println(l);
            num++;
        }
        System.out.println("--------------------------------------------------");
    }*/

    // mostra uma lista enumerada com todos os autores (identificados pelo nome)
   /* public static void listarAutores() {
        int num = 1;
        System.out.println("--------------------------------------------------");
        System.out.println("Mostrando autores...\n");
        for (Autor a : Livraria.autoresCatalogo()) {
            System.out.println(num + a.getNome());
            num++;
        }
        System.out.println("--------------------------------------------------");
    }*/

    // mostra uma lista enumerada com todas os editoras(identificadas pelo nome)
   /* public static void listarEditoras() {
        int num = 1;
        System.out.println("--------------------------------------------------");
        System.out.println("Mostrando editoras...\n");
        for (Editora e : Livraria.editorasCatalogo()) {
            System.out.println(num + e.getNome());
            num++;
        }
        System.out.println("--------------------------------------------------");
    }*/

    // mostra uma lista numerada com todos os generos em ordem alfabética
    /*public static void listarGeneros(){
        System.out.println("--------------------------------------------------");
        System.out.println("Mostrando gêneros...");
        System.out.println( "1 - Autoajuda\n" + 
                            "2 - Drama\n" +
                            "3 - Ficção\n" +
                            "4 - Infantojuvenil\n" +
                            "5 - Jovem adulto\n" + 
                            "6 - Não ficção\n" + 
                            "7 - Policial\n" + 
                            "8 - Quadrinhos\n" +
                            "9 - Romance\n" +
                            "10 - Suspense\n" + 
                            "11 - Terror" );
        System.out.println("--------------------------------------------------");
    }*/

    /* OUTROS MÉTODOS */

    // método genérico auxiliar para imprimir listas de objetos
    public static void imprimeLista(List<?> lista) {
        for(Object elemento : lista){
            System.out.println(elemento);
        }
    }

    // método usado para realizar uma busca no catálogo
    public static void busca() {
        System.out.println("Pelo que deseja buscar?\n" + 
                            "1 - Título do livro\n" + 
                            "2 - Nome do autor\n" +
                            "3 - Nome da editora\n" +
                            "4 - Gênero do livro\n");
        Scanner input = new Scanner(System.in);
        int op = -1; op = input.nextInt();
        input.nextLine();
        while (op != 1 && op != 2 && op != 3 && op != 4) { // se a entrada não for uma das opções
            System.out.println("Impossível realizar esta ação. Por favor, escolha uma opção válida");
            op = input.nextInt();
            input.nextLine();
        }
        switch (op) {
            case 1: 
                System.out.println("Insira o título do livro: ");
                String str1 = input.nextLine();
                
                try{
                    String buscado = Livraria.buscaLivro(str1).toString();// encontra e imprime o livro 
                    System.out.printf("%s", buscado);
                }catch(Exception e){
                    System.out.println("Livro não encontrado");
                } 
                break; 
            case 2:
                System.out.println("Insira o nome do autor: ");
                String str = input.nextLine();
                try{
                    imprimeLista(Livraria.buscarLivros(Livraria.buscaAutor(str)));// encontra e imprime os livros
                }catch(Exception e){
                    System.out.println("Autor não encontrado");
                } 
                break; 
            case 3:
                System.out.println("Insira o nome da editora: ");
                String str3 = input.nextLine();
                try{
                    imprimeLista(Livraria.buscarLivros(Livraria.buscaEditora(str3)));// encontra e imprime os livros
                }catch(Exception e){
                    System.out.println("Editora não encontrada");
                } 
                break; 
            case 4: 
                System.out.println("Insira o gênero: ");    
                String str4 = input.nextLine();
                try{
                    imprimeLista(Livraria.buscarLivros(str4));// encontra e imprime os livros
                }catch(Exception e){
                    System.out.println("Gênero não encontrada");
                } 
                break; 
        }
    }

    // método para alugar um livro 
    public static void alugarLivro() {
        Scanner teclado = new Scanner (System.in);
        System.out.println("Digite o cpf do cliente para verificar se a locação de livros está disponível: ");
        String cpfCliente = teclado.nextLine();
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

    // método para devolver um livro
    /*public static void devolverLivro(Aluguel aluguel) {
        Scanner input = new Scanner(System.in);
        Livraria.removeAluguel(aluguel);

        System.out.println("Gostaria de avaliar o livro?\n");
        String resposta = input.nextLine();
        switch (resposta) {
            case "Sim": 
                System.out.println("Numa escala de 1 a 5, o quanto você gostou do livro?\n");
                int nota = input.nextInt();
                Livraria.avaliarLivro(aluguel.getLivro(), nota);
                break;
            case "Não":
                System.out.println("Obrigada por utilizar nosso serviço, volte sempre!\n"); 
                break;
        }
        input.close();
    }*/

   

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // le os dados dos arquivos
        Livraria.inicializaCatalogo();
        Livraria.inicializaClientes();

        int option = -1; // inicializa a variavel option, usada para o usuário manipular o sistema
        while(option != 0) {

            mostraMenu();
            option = input.nextInt();
            System.out.println("\n--------------------------------------------------\n"); // padrao: 50 '-'
            while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7 && option != 0) { // se a entrada não for uma das opções
                System.out.println("Impossível realizar esta ação. Por favor, escolha uma opção válida");
                option = input.nextInt(); 
            }
            
            // roda o programa
            switch (option) {
                case 0: break;
                case 1:
                    try {
                        ManipulaCliente.armazenaCliente("dados/clientes.txt");
                        System.out.println("Cliente cadastrado com sucesso!\n");
                    } catch (IOException e) {
                        System.out.println("Não foi possível cadastrar o novo cliente!\n");
                        e.getMessage();
                    }
                    break;
                case 2: 
                    ManipulaCliente.listarClientes();
                    break;
                case 3:
                    busca();
                    break;
                case 4:
                    alugarLivro();
                    break;
                case 5:
                    break;
                case 6:
                    Recomendacao.recomendaLivros(); 
                    break;
                case 7:
                    Recomendacao.recomendaAutores(); 
                    break;
            }
            
        }

        input.close();
        // se a opção de encerrar o programa for escolhida, encerra

    }
}
