import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livraria {

    public static final int MAX_LIVROS = 5;
    private static ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();

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
                    break;
                case "Não":
                    System.out.println("Obrigada por utilizar nosso serviço, volte sempre!\n"); 
                    break;
            }
            input.close();
        }

        if (cliente.getQtdLivrosAlugados() == MAX_LIVROS) { // Caso o cliente ja tenha o numero maximo de livros alugados
            System.out.println("Não é possível alugar o livro pois o cliente atingiu o limite de livros alugados simultaneamente.\n");
            return;
        }

        Livro livro = Catalogo.buscaLivroPorId(idLivro); // encontra o livro desejado

        if (livro.verificaDisponibilidade() == 0) { // Caso o livro nao esteja disponivel
            System.out.println("Não é possível alugar o livro pois não há exemplares disponíveis.\n");
            return;
        }

        Aluguel novoAluguel = new Aluguel(livro, dataAluguel, cliente); // cria um obj da classe Aluguel com os dados
        alugueis.add(novoAluguel);
        System.out.println("Livro alugado com sucesso!\n"); 
    }

    // Devolve um livro
    public static void devolverLivro(Aluguel aluguel) {
        Scanner input = new Scanner(System.in);
        alugueis.remove(aluguel);
        int qtd = aluguel.getLivro().getQtdAlugados();
        aluguel.getLivro().setQtdAlugados(qtd-1);

        System.out.println("Gostaria de avaliar o livro?\n");
        String resposta = input.nextLine();
        switch (resposta) {
            case "Sim": 
                System.out.println("Numa escala de 1 a 5, o quanto você gostou do livro?\n");
                int nota = input.nextInt();
                aluguel.getLivro().avaliar(nota);
                break;
            case "Não":
                System.out.println("Obrigada por utilizar nosso serviço, volte sempre!\n"); 
                break;
        }
        input.close();
    }

    //TODO: mover para o menu
    public static void recomendaLivros() {
        //TODO: metodo pra mostrar o top 10
        List<Livro> topDez = new ArrayList<Livro>();   
    }

    public static void busca() {
        System.out.println("Pelo que deseja buscar?\n");
        Scanner input = new Scanner(System.in);
        String resposta = input.nextLine();
        switch (resposta.toLowerCase()) {
            case "livro": 
                System.out.println("Insira o título do livro: ");
                String str1 = input.nextLine();
                Catalogo.buscaLivroPorTitulo(str1).toString(); // encontra e imprime os livros 
                break;
            case "autor":
                System.out.println("Insira o nome do autor: \n");
                String str = input.nextLine();
                Catalogo.buscarLivros(Catalogo.buscaAutorPorNome(str)); // encontra e imprime os livros
                break;
            case "editora":
                System.out.println("Insira o nome da editora: ");
                String str3 = input.nextLine();
                Catalogo.buscarLivros(Catalogo.buscaEditoraPorNome(str3)); // encontra e imprime os livros
                break;
            case "genero": 
                System.out.println("Insira o gênero: \n");    
                String str4 = input.nextLine();
                Catalogo.buscarLivros(str4); // encontra e imprime os livros
                break;
        }
        input.close();
    }

    public static void cadastrarCliente(){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Digite o nome do novo cliente: ");
        String nome = teclado.next();
        System.out.println("Digite a nacionalidade do novo cliente: ");
        String nacionalidade = teclado.next();
        System.out.println("Digite o ano de nascimento do novo cliente: ");
        Integer ano = teclado.nextInt();
        System.out.println("Digite o cpf do novo cliente: ");
        String cpf = teclado.next();
        Cliente clienteNovo = new Cliente(nome, nacionalidade, ano, cpf, true);
        teclado.close();
    }

}