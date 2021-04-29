import java.util.Scanner;

public class Menu { // classe para interação com o usuário

    private void mostraMenu() {
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1 - Cadastrar novo cliente");
        System.out.println("2 - Ver clientes cadastrados");
        System.out.println("3 - Buscar por um livro");
        System.out.println("4 - Alugar um livro");
        System.out.println("5 - Devolver um livro");
        System.out.println("6 - Ver recomendações");
        System.out.println("7 - Encerrar programa");
    }

    // mostra uma lista enumerada com todos os clientes cadastrados (identificados pelo nome)
    public static void listarClientes() {
        int num = 1;
        System.out.println("---------------"); // 15 "-"
        System.out.println("Listando clientes...");
        for (Cliente c : Livraria.getClientes()) {
            System.out.println(num + " - " + c.getNome());
            num++;
        }
        System.out.println("---------------");
    }

    // mostra uma lista enumerada com todos os clientes cadastrados (identificados pelo nome)
    public static void listarAlugueis() {
        int num = 1;
        System.out.println("---------------"); // 15 "-"
        System.out.println("Listando alugueis...");
        for (Aluguel a : Livraria.getAlugueis()) {
            System.out.println("--- Aluguel nº " + num + " ---");
            System.out.println("Cliente: " + a.getCliente().getNome());
            System.out.println("Livro: " + a.getLivro().getTitulo());
            num++;
        }
        System.out.println("---------------");
    }  

    // mostra uma lista enumerada com todos os livros (com todas informações)
    public static void listarLivros() {
        int num = 1;
        System.out.println("---------------"); 
        System.out.println("Listando livros...\n");
        for (Livro l : Livraria.livrosCatalogo()) {
            System.out.println("--- Livro nº " + num + " ---");
            System.out.println(l);
            num++;
        }
        System.out.println("---------------"); 
    }

    // mostra uma lista enumerada com todos os autores (identificados pelo nome)
    public static void listarAutores() {
        int num = 1;
        System.out.println("---------------"); 
        System.out.println("Listando autores...\n");
        for (Autor a : Livraria.autoresCatalogo()) {
            System.out.println(num + a.getNome());
            num++;
        }
        System.out.println("---------------");
    }

    // mostra uma lista enumerada com todas os editoras(identificadas pelo nome)
    public static void listarEditoras() {
        int num = 1;
        System.out.println("---------------"); 
        System.out.println("Listando editoras...\n");
        for (Editora e : Livraria.editorasCatalogo()) {
            System.out.println(num + e.getNome());
            num++;
        }
        System.out.println("---------------");
    }

    // mostra uma lista numerada com todos os generos em ordem alfabética
    public static void listarGeneros(){
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
    }

    public static void imprimeLista(List<T> lista) {
        for(T elemento : lista){
            System.out.println(elemento);
        }
    }

    public static void cadastrarCliente() {
        Scanner teclado = new Scanner (System.in);

        System.out.print("Digite o nome do novo cliente: ");
        String nome = teclado.next();
        System.out.print("Digite a nacionalidade do novo cliente: ");
        String nacionalidade = teclado.next();
        System.out.print("Digite o ano de nascimento do novo cliente: ");
        Integer ano = teclado.nextInt();
        System.out.print("Digite o cpf do novo cliente: ");
        String cpf = teclado.next();

        Livraria.salvaCliente(nome, nacionalidade, ano, cpf);
        teclado.close();

        //TODO: implementar validação
    }

    public static void busca() {
        System.out.println("Pelo que deseja buscar?\n");
        Scanner input = new Scanner(System.in);
        String resposta = input.nextLine();
        switch (resposta.toLowerCase()) {
            case "livro": 
                System.out.println("Insira o título do livro: ");
                String str1 = input.nextLine();
                Livraria.buscaLivro(str1).toString(); // encontra e imprime os livros 
                break; // lançar exceção pra quando não encontrar
            case "autor":
                System.out.println("Insira o nome do autor: \n");
                String str = input.nextLine();
                imprimeLista(Catalogo.buscarLivros(Catalogo.buscaAutorPorNome(str))); // encontra e imprime os livros
                break; // lançar exceção pra quando não encontrar
            case "editora":
                System.out.println("Insira o nome da editora: ");
                String str3 = input.nextLine();
                imprimeLista(Catalogo.buscarLivros(Catalogo.buscaEditoraPorNome(str3))); // encontra e imprime os livros
                break; // lançar exceção pra quando não encontrar
            case "genero": 
                System.out.println("Insira o gênero: \n");    
                String str4 = input.nextLine();
                imprimeLista(Catalogo.buscarLivros(str4)); // encontra e imprime os livros
                break; // lançar exceção pra quando não encontrar
        }
        input.close();
    }

    // Aluga um livro
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

        if (verificaLimite(cliente)) { // Caso o cliente ja tenha o numero maximo de livros alugados
            System.out.println("Não é possível alugar o livro pois o cliente atingiu o limite de livros alugados simultaneamente.\n");
            return;
        }

        Livro livro = Livraria.buscaLivro(idLivro); // encontra o livro desejado

        if (!verificaDisponibilidade(livro)) { // Caso o livro nao esteja disponivel
            System.out.println("Não é possível alugar o livro pois não há exemplares disponíveis.\n");
            return;
        }

        salvaAluguel(livro, dataAluguel, cliente);
        System.out.println("Livro alugado com sucesso!\n"); 
    }

    // Devolve um livro
    public static void devolverLivro(Aluguel aluguel) {
        Scanner input = new Scanner(System.in);
        removeAluguel(aluguel);

        System.out.println("Gostaria de avaliar o livro?\n");
        String resposta = input.nextLine();
        switch (resposta) {
            case "Sim": 
                System.out.println("Numa escala de 1 a 5, o quanto você gostou do livro?\n");
                int nota = input.nextInt();
                avaliarLivro(livro, nota);
                break;
            case "Não":
                System.out.println("Obrigada por utilizar nosso serviço, volte sempre!\n"); 
                break;
        }
        input.close();
    }

    public static void recomendaLivros() {
        //TODO: metodo pra mostrar o top 10 
    }

    public static void main(String[] args) {

    }
}
