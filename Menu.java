import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu { // classe para interação com o usuário

    private static void mostraMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1 - Cadastrar novo cliente");
        System.out.println("2 - Ver clientes cadastrados");
        System.out.println("3 - Buscar por um livro");
        System.out.println("4 - Alugar um livro");
        System.out.println("5 - Devolver um livro");
        System.out.println("6 - Ver recomendações");
        System.out.println("0 - Encerrar programa");
        System.out.println("--------------------------------------------------");
    }

    /* MÉTODOS PARA MOSTRAR DADOS */

    // mostra uma lista enumerada com todos os clientes cadastrados (identificados pelo nome)
    public static void listarClientes() {
        int num = 1;
        System.out.println("--------------------------------------------------");
        System.out.println("Mostrando clientes...");
        for (Cliente c : Livraria.getClientes()) {
            System.out.println(num + " - " + c.getNome());
            num++;
        }
        System.out.println("--------------------------------------------------");
    }

    // mostra uma lista enumerada com todos os alugueis cadastrados
    public static void listarAlugueis() {
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
    }  

    // mostra uma lista enumerada com todos os livros (com todas informações)
    public static void listarLivros() {
        int num = 1;
        System.out.println("--------------------------------------------------");
        System.out.println("Mostrando livros...\n");
        for (Livro l : Livraria.livrosCatalogo()) {
            System.out.println("---------- Livro nº " + num + " ----------");
            System.out.println(l);
            num++;
        }
        System.out.println("--------------------------------------------------");
    }

    // mostra uma lista enumerada com todos os autores (identificados pelo nome)
    public static void listarAutores() {
        int num = 1;
        System.out.println("--------------------------------------------------");
        System.out.println("Mostrando autores...\n");
        for (Autor a : Livraria.autoresCatalogo()) {
            System.out.println(num + a.getNome());
            num++;
        }
        System.out.println("--------------------------------------------------");
    }

    // mostra uma lista enumerada com todas os editoras(identificadas pelo nome)
    public static void listarEditoras() {
        int num = 1;
        System.out.println("--------------------------------------------------");
        System.out.println("Mostrando editoras...\n");
        for (Editora e : Livraria.editorasCatalogo()) {
            System.out.println(num + e.getNome());
            num++;
        }
        System.out.println("--------------------------------------------------");
    }

    // mostra uma lista numerada com todos os generos em ordem alfabética
    public static void listarGeneros(){
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
    }

    /* MÉTODOS PARA VALIDAÇÃO DAS ENTRADAS */

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
        Scanner teclado = new Scanner (System.in);

        System.out.print("Digite o nome do novo cliente: ");
        String nome = teclado.next();
        validaString(nome);
        System.out.print("Digite a nacionalidade do novo cliente: ");
        String nacionalidade = teclado.next();
        validaString(nacionalidade);
        System.out.print("Digite o ano de nascimento do novo cliente: ");
        Integer ano = teclado.nextInt();
        validaNumero(ano.toString());
        System.out.print("Digite o cpf do novo cliente (somente números): ");
        String cpf = teclado.next();
        validaNumero(cpf.toString());

        Livraria.salvaCliente(nome, nacionalidade, ano, cpf);
        teclado.close();

        //TODO: implementar validação
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
                Livraria.buscaLivro(str1).toString(); // encontra e imprime o livro 
                break; //TODO: lançar exceção pra quando não encontrar
            case 2:
                System.out.println("Insira o nome do autor: ");
                String str = input.nextLine();
                imprimeLista(Livraria.buscarLivros(Livraria.buscaAutor(str))); // encontra e imprime os livros
                break; //TODO: lançar exceção pra quando não encontrar
            case 3:
                System.out.println("Insira o nome da editora: ");
                String str3 = input.nextLine();
                imprimeLista(Livraria.buscarLivros(Livraria.buscaEditora(str3))); // encontra e imprime os livros
                break; //TODO: lançar exceção pra quando não encontrar
            case 4: 
                System.out.println("Insira o gênero: ");    
                String str4 = input.nextLine();
                imprimeLista(Livraria.buscarLivros(str4)); // encontra e imprime os livros
                break; //TODO: lançar exceção pra quando não encontrar
        }
        input.close();
    }

    // método para alugar um livro (cria um obj aluguel)
    public static void alugarLivro(Integer idLivro, String dataAluguel, Cliente cliente) {
        if (!cliente.getAssinante()) { // Caso o cliente não seja assinante
            System.out.println("Não é possível alugar o livro pois o cliente não é assinante do serviço.\n");
            System.out.println("Gostaria de assinar nosso serviço?\n");
            Scanner input = new Scanner(System.in);
            String resposta = input.nextLine();
            switch (resposta) {
                case "Sim": 
                    cliente.comprarAssinatura();
                    System.out.println("Assinatura efetuada com sucesso!\n");
                    input.close(); break;
                case "Não":
                    System.out.println("Obrigada por utilizar nosso serviço, volte sempre!\n"); 
                    input.close(); return;
            }
        }

        if (Livraria.verificaLimite(cliente)) { // Caso o cliente ja tenha o numero maximo de livros alugados
            System.out.println("Não é possível alugar o livro pois o cliente atingiu o limite de livros alugados simultaneamente.\n");
            return;
        }

        Livro livro = Livraria.buscaLivro(idLivro); // encontra o livro desejado

        if (Livraria.verificaDisponibilidade(livro)) { // Caso o livro nao esteja disponivel
            System.out.println("Não é possível alugar o livro pois não há exemplares disponíveis.\n");
            return;
        }

        Livraria.salvaAluguel(livro, dataAluguel, cliente);
        System.out.println("Livro alugado com sucesso!\n"); 
    }

    // método para devolver um livro
    public static void devolverLivro(Aluguel aluguel) {
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
    }

    // método para recomendar livros 
    public static void recomendaLivros() {
        //TODO: metodo pra mostrar o top 10 
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // le os dados dos arquivos
        Livraria.inicializaCatalogo();

        int option = -1; // inicializa a variavel option, usada para o usuário manipular o sistema
        while(option != 0) {

            mostraMenu();
            
            option = input.nextInt();
            System.out.println("\n--------------------------------------------------\n"); // padrao: 50 '-'
            while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 0) { // se a entrada não for uma das opções
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
                    busca();
                    // TODO: colocar um bloco try/catch aqui pra tratar quando o programa não encontrar nenhum resultado pra busca realizada (criar uma exception própria)
                case 4:
                    System.out.println("--------------------------------------------------");
                    System.out.println("Qual dos clientes a seguir vai realizar o aluguel?");
                    listarClientes();
                    int cliente = input.nextInt();
                    while (cliente-1 < 1 || cliente-1 >Livraria.getClientes().size()) { // enquando nao for um cliente valido
                        System.out.println("Cliente não encontrado. Por favor, tente novamente.\n");
                        cliente = input.nextInt();
                    }
                    System.out.println("Qual dos livros a seguir será alugado?");
                    listarLivros();
                    int livro = input.nextInt();
                    while (livro-1 < 1 || livro-1 >Livraria.livrosCatalogo().size()) { // enquando nao for um livro valido
                        System.out.println("Livro não encontrado. Por favor, tente novamente.\n");
                        livro = input.nextInt();
                    }
                    System.out.println("Insira a data do aluguel (formato dd/mm/aaaa): ");
                    String data = input.nextLine();
                    
                    //alugarLivro(Livraria.livrosCatalogo()[livro-1], data, Livraria.getClientes()[cliente-1]);
                    //TODO: consertar linha acima

                    break;
                case 5:
                case 6:
                    recomendaLivros(); break;
            }
        }

        input.close();
        // se a opção de encerrar o programa for escolhida, encerra

    }
}
