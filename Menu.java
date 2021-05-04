import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu { // classe para interação com o usuário

    private static void mostraMenu() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1 - Cadastrar novo cliente");
        System.out.println("2 - Ver clientes cadastrados");
        System.out.println("3 - Buscar por um livro");
        System.out.println("4 - Alugar um livro");
        System.out.println("5 - Devolver um livro");
        System.out.println("6 - Ver recomendações");
        System.out.println("7 - Ver livros disponiveis");
        System.out.println("8 - Ver autores disponiveis");
        System.out.println("0 - Encerrar programa");
        System.out.println("--------------------------------------------------\n");
    }

    /* MÉTODOS PARA MOSTRAR DADOS */

    // mostra uma lista enumerada com todos os clientes cadastrados (identificados pelo nome)
    public static void listarClientes() {
        int num = 1;
        System.out.println("\n--------------------------------------------------");
        System.out.println("Mostrando clientes...\n");
        for (Cliente c : Livraria.getClientes()) {
            System.out.println(num + " - " + c.getNome());
            num++;
        }
        System.out.println("--------------------------------------------------\n");
    }

    // mostra uma lista enumerada com todos os alugueis cadastrados
    public static void listarAlugueis() {
        int num = 1;
        System.out.println("\n--------------------------------------------------");
        System.out.println("Mostrando alugueis...\n");
        for (Aluguel a : Livraria.getAlugueis()) {
            System.out.println("--- Aluguel nº " + num + " ---");
            System.out.println("Cliente: " + a.getCliente().getNome());
            System.out.println("Livro: " + a.getLivro().getTitulo());
            num++;
        }
        System.out.println("--------------------------------------------------\n");
    }  

    // mostra uma lista enumerada com todos os livros (com todas informações)
    public static void listarLivros() {
        int num = 1;
        System.out.println("\n--------------------------------------------------");
        System.out.println("Mostrando livros...\n");
        for (Livro l : Livraria.livrosCatalogo()) {
            System.out.println("------------- Livro nº " + num + " -------------");
            System.out.println(l);
            num++;
        }
        System.out.println("--------------------------------------------------\n");
    }

    // mostra uma lista enumerada com todos os livros (com todas informações)
    public static void listarLivrosParaAlugar() {
        int num = 1;
        System.out.println("\n--------------------------------------------------");
        System.out.println("Mostrando livros...\n");
        for (Livro l : Livraria.livrosCatalogo()) {
            System.out.println("------------- Livro nº " + num + " -------------");
            System.out.println( "Titulo: " + l.getTitulo() + " - ID: " + l.getId() + '\n' +
                                "Autor: " + Livraria.buscaAutor(l.getIdAutor()).getNome() + '\n');
            num++;
        }
        System.out.println("--------------------------------------------------\n");
    }

    // mostra uma lista enumerada com todos os autores (identificados pelo nome)
    public static void listarAutores() {
        int num = 1;
        System.out.println("\n--------------------------------------------------");
        System.out.println("Mostrando autores...\n");
        for (Autor a : Livraria.autoresCatalogo()) {
            System.out.println(num + " - " + a.getNome());
            num++;
        }
        System.out.println("--------------------------------------------------\n");
    }

    // mostra uma lista enumerada com todas os editoras(identificadas pelo nome)
    public static void listarEditoras() {
        int num = 1;
        System.out.println("\n--------------------------------------------------");
        System.out.println("Mostrando editoras...\n");
        for (Editora e : Livraria.editorasCatalogo()) {
            System.out.println(num + e.getNome());
            num++;
        }
        System.out.println("--------------------------------------------------\n");
    }

    // mostra uma lista numerada com todos os generos em ordem alfabética
    public static void listarGeneros(){
        System.out.println("\n--------------------------------------------------");
        System.out.println("Mostrando gêneros...\n");
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
        System.out.println("--------------------------------------------------\n");
    }

    /* OUTROS MÉTODOS */

    // método genérico auxiliar para imprimir listas de objetos
    public static void imprimeLista(List<?> lista) {
        for(Object elemento : lista){
            System.out.println(elemento);
        }
    }

    // método para cadastrar um novo cliente
    public static void cadastrarCliente() throws IllegalArgumentException {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o nome do novo cliente: ");
        String nome = teclado.nextLine();
        System.out.print("Digite a nacionalidade do novo cliente: ");
        String nacionalidade = teclado.next();
        System.out.print("Digite o ano de nascimento do novo cliente: ");
        Integer ano = teclado.nextInt();
        System.out.print("Digite o cpf do novo cliente (somente números): ");
        String cpf = teclado.next();

        Livraria.salvaCliente(nome, nacionalidade, ano, cpf);
//        teclado.close();

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
        while (op != 1 && op != 2 && op != 3 && op != 4) { // se a entrada não for uma das opções
            System.out.println("Impossível realizar esta ação. Por favor, escolha uma opção válida");
            op = input.nextInt();
        }
        switch (op) {
            case 1: 
                System.out.println("Insira o título do livro: ");
                String str1 = input.nextLine();
                if(Livraria.buscaLivro(str1) == null){
                    throw new BuscaSemSucessoException("Busca sem resultado. Por favor, tente novamente.");
                }
                Livraria.buscaLivro(str1).toString(); // encontra e imprime o livro 
                break;
            case 2:
                System.out.println("Insira o nome do autor: ");
                String str = input.nextLine();
                if(Livraria.buscarLivros(Livraria.buscaAutor(str)).isEmpty()){
                    throw new BuscaSemSucessoException("Busca sem resultado. Por favor, tente novamente.");
                }
                imprimeLista(Livraria.buscarLivros(Livraria.buscaAutor(str))); // encontra e imprime os livros
                break;
            case 3:
                System.out.println("Insira o nome da editora: ");
                String str3 = input.nextLine();
                if(Livraria.buscarLivros(Livraria.buscaEditora(str3)).isEmpty()){
                    throw new BuscaSemSucessoException("Busca sem resultado. Por favor, tente novamente.");
                }
                imprimeLista(Livraria.buscarLivros(Livraria.buscaEditora(str3))); // encontra e imprime os livros
                break;
            case 4: 
                System.out.println("Insira o gênero: ");    
                String str4 = input.nextLine();
                if(Livraria.buscarLivros(str4).isEmpty()){
                    throw new BuscaSemSucessoException("Busca sem resultado. Por favor, tente novamente.");
                }
                imprimeLista(Livraria.buscarLivros(str4)); // encontra e imprime os livros
                break;
        }
    }

    // método para alugar um livro (cria um obj aluguel)
    public static void alugarLivro() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o CPF do cliente: ");
        String cpf = input.nextLine();
        Livraria.buscaCliente(cpf);

        if(Livraria.buscaCliente(cpf) == null){
            throw new BuscaSemSucessoException("Cliente não encontrado.");
        }

        if (!Livraria.buscaCliente(cpf).getAssinante()) { // Caso o cliente não seja assinante
            System.out.println("Não é possível alugar o livro pois o cliente não é assinante do serviço.\n");
            System.out.println("Gostaria de assinar nosso serviço? Digite Sim ou Não.\n");
            input = new Scanner(System.in);
            String resposta = input.nextLine();
            switch (resposta.toLowerCase()) {
                case "sim":
                    Livraria.buscaCliente(cpf).comprarAssinatura();
                    System.out.println("Assinatura efetuada com sucesso!\n");
                    break;
                case "nao":
                    System.out.println("Obrigada por utilizar nosso serviço, volte sempre!\n"); 
                    return;
            }
        }

        if (!Livraria.verificaLimite(Livraria.buscaCliente(cpf))) { // Caso o cliente ja tenha o numero maximo de livros alugados
            System.out.println("Não é possível alugar o livro pois o cliente atingiu o limite de livros alugados simultaneamente.\n");
            return;
        }

        System.out.println("Escolha um dos livros a seguir: ");
        listarLivrosParaAlugar();
        Integer numLivro = input.nextInt();

        while (numLivro-1 < 0 || numLivro-1 > Livraria.livrosCatalogo().size()) { // enquando nao for um livro valido
            System.out.println("Livro não encontrado. Por favor, tente novamente.\n");
            numLivro = input.nextInt();
        }

        Livraria.livrosCatalogo().get(numLivro-1);

        if (!Livraria.verificaDisponibilidade(Livraria.livrosCatalogo().get(numLivro-1))) { // Caso o livro nao esteja disponivel
            System.out.println("Não é possível alugar o livro pois não há exemplares disponíveis.\n");
            return;
        }

        System.out.println("Digite a data do aluguel: ");
        String data = input.nextLine();

        Livraria.salvaAluguel(Livraria.livrosCatalogo().get(numLivro-1), data, Livraria.buscaCliente(cpf));
        System.out.println("Livro alugado com sucesso!\n"); 
    }

    // método para devolver um livro
    public static void devolverLivro() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escolha um dos alugueis abaixo: ");
        listarAlugueis();
        Integer numAluguel = input.nextInt();

        while (numAluguel-1 < 1 || numAluguel-1 >Livraria.getAlugueis().size()) { // enquando nao for um livro valido
            System.out.println("Aluguel não encontrado. Por favor, tente novamente.\n");
            numAluguel = input.nextInt();
        }

        Livraria.removeAluguel(Livraria.getAlugueis().get(numAluguel-1));

        System.out.println("\nGostaria de avaliar o livro? Digite Sim ou Não.\n");
        String resposta = input.nextLine();
        switch (resposta) {
            case "Sim": 
                System.out.println("Numa escala de 1 a 5, o quanto você gostou do livro?\n");
                int nota = input.nextInt();
                Livraria.avaliarLivro(Livraria.getAlugueis().get(numAluguel-1).getLivro(), nota);
                break;
            case "Não":
                System.out.println("Obrigada por utilizar nosso serviço, volte sempre!\n"); 
                break;
        }
    }

    // método para recomendar livros 
    public static void recomendaLivros() {
        LivroComparator comparator = new LivroComparator() ;
        List<Livro> livrosRecomendados = new ArrayList<Livro>();
        livrosRecomendados  = Catalogo.getLivros();
        Collections.sort(livrosRecomendados, comparator);
        System.out.println("--------------- TOP 10 livros recomendados ---------------");
        for(int i = 0; i < 10; i++) 
            System.out.println(livrosRecomendados.get(i).getTitulo());
        System.out.println("--------------------------------------------------\n");
    }

    //método para recomendar autores
    public static void recomendaAutores() {
        AutorComparator comparator = new AutorComparator() ;
        List<Autor> autoresRecomendados = new ArrayList<Autor>();
        autoresRecomendados = Catalogo.getAutores();
        Collections.sort(autoresRecomendados, comparator);
        System.out.println("--------------- TOP 10 autores recomendados ---------------");
        for(int i = 0; i < 10; i++) 
            System.out.println(autoresRecomendados.get(i).getNome());
        System.out.println("--------------------------------------------------\n");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // le os dados dos arquivos
        Livraria.inicializaPrograma();

        int option = -1; // inicializa a variavel option, usada para o usuário manipular o sistema
        while(option != 0) {

            mostraMenu();
            
            option = input.nextInt();
            System.out.println("\n--------------------------------------------------\n"); // padrao: 50 '-'
            while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7 && option != 8 && option != 0) { // se a entrada não for uma das opções
                System.out.println("Impossível realizar esta ação. Por favor, escolha uma opção válida");
                option = input.nextInt(); 
            }
            
            // roda o programa
            switch (option) {
                case 0: break;
                case 1:
                    try {
                        cadastrarCliente();
                        System.out.println("Cliente cadastrado com sucesso!\n");
                    } catch (IllegalArgumentException e) {
                        e.getMessage();
                    }
                    break;
                case 2: 
                    listarClientes(); break;
                case 3:
                    try {
                        busca();
                    } catch (BuscaSemSucessoException e) {
                        e.getMessage();
                    }
                case 4:
                    try {
                        alugarLivro();
                    }catch (BuscaSemSucessoException e){
                        e.getMessage();
                    }
                    break;
                case 5:
                    devolverLivro();
                    break;
                case 6:
                    recomendaLivros();
                    recomendaAutores();
                    break;
                case 7:
                    listarLivros();
                    break;
                case 8:
                    listarAutores();
                    break;
            }
        }

        Livraria.finalizaPrograma();
        input.close();
        // se a opção de encerrar o programa for escolhida, encerra

    }
}
