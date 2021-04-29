import java.util.Scanner;

public class Menu {
    /* Classe para interação com o usuário */

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
    
    //TODO: mover pra ca os metodos de alugar e devolver livro e a busca
    public static void main(String[] args) {

    }
}
