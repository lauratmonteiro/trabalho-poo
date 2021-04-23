import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Livraria {

    public static final int MAX_LIVROS = 5;

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
        System.out.println("Livro alugado com sucesso!\n"); 
    }

    // Devolve um livro
    public static void devolverLivro(Aluguel aluguel) {
        Scanner input = new Scanner(System.in);
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
        System.out.println("Aqui estão algumas recomendações para você:\n");
        topTres(aluguel.getLivro());
    }

    // T<Livro, Autor, Editora, Genero> 
    public static void busca() {
        System.out.println("Pelo que deseja buscar?\n");
        Scanner input = new Scanner(System.in);
        String resposta = input.nextLine();
        switch (resposta) {
            case "Livro": 
                String str1 = input.nextLine();
                Catalogo.buscaLivroPorTitulo(str1).toString(); // encontra e imprime os livros 
                break;
            case "Autor":
                String str = input.nextLine();
                Catalogo.buscarLivros(Catalogo.buscaAutorPorNome(str)); // encontra e imprime os livros
                break;
            case "Editora":
                String str3 = input.nextLine();
                Catalogo.buscarLivros(Catalogo.buscaEditoraPorNome(str3)); // encontra e imprime os livros
                break;
            case "Genero": 
                String str4 = input.nextLine();
                Catalogo.buscarLivros(str4); // encontra e imprime os livros
                break;
        }
        input.close();
    }

    public static void topTres(Livro livro) {
        List<Livro> livrosOrdenados = new ArrayList<Livro>();
        livrosOrdenados = Collections.reverse(Catalogo.getLivros().sort(Comparator.comparing(Livro :: getAvaliacao))); //TODO: consertar isso aqui
        
        int top = 0;
        for (Livro l : livrosOrdenados) {
            if (l.getIdAutor() == livro.getIdAutor() || l.getGenero() == livro.getGenero()) { // se for do mesmo autor ou do mesmo genero
                System.out.println(l);
                top++;
            }
            if (top == 3) break;
        }
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