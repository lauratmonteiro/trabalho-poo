import java.util.ArrayList;
import java.util.Collections;

public class Catalogo {

    /* Atributos */

    public final int MAX_LIVROS = 5;
    private ArrayList<Livro> livros = new ArrayList<Livro>();
    private ArrayList<Editora> editoras = new ArrayList<Editora>();
    private ArrayList<Autor> autores = new ArrayList<Autor>();
    private ArrayList<Genero> generos = new ArrayList<Genero>();

    /* Outros métodos*/

    // Mostra os livros em ordem alfabética
    public void listarLivros(){
        Collections.sort(livros);
        System.out.println(livros);
    }

    // Mostra os autores em ordem alfabética
    public void listarAutores(){
        Collections.sort(autores);
        System.out.println(livros);
    }

    // Mostra as editoras em ordem alfabética
    public void listarEditoras(){
        Collections.sort(editoras);
        System.out.println(editoras);
    }

    // Mostra os generos em ordem alfabética
    public void listarGeneros(){
        Collections.sort(generos);
        System.out.println(generos);
    }

    // Aluga um livro
    public void alugarLivro(Integer idLivro, String dataAluguel, Cliente cliente) {
        if (!cliente.getAssinante()) {
            System.out.println("Não é possível alugar o livro pois o cliente não é assinante do serviço.\n");
            //TODO: fornecer opção de assinar ou nao ?
            return;
        }
        if (cliente.getQtdLivrosAlugados() == MAX_LIVROS) {
            System.out.println("Não é possível alugar o livro pois o cliente atingiu o limite de livros alugados simultaneamente.\n");
            //TODO: fornecer opção de devolver ou nao ?
            return;
        }

        /* Descomentar quando tiver o método pra encontrar o livro pelo id
        Livro livro = livros.encontraLivro(idLivro);
        if (!livro.verificaDisponibilidade) {
            System.out.println("Não é possível alugar o livro pois não há exemplares disponíveis.\n");
            return;
        }
        Aluguel novoAluguel = new Aluguel(livro, dataAluguel, cliente); // cria um obj da classe Aluguel com os dados
        */
    }

    // Devolve um livro
    public void devolverLivro(Aluguel aluguel) {
        //TODO: implementar
    }
    
    /* // Encontra um livro a partir do seu id
    public Livro encontraLivro(Integer id){
        for (Livro li : livros) {
            if (li.getIdLivro() == id) 
                return li;
        }
        //TODO: terminar/consertar esse metodo
    } */

    //TODO: implementar metodo pra mostrar o top3 livros de alguma categoria (autor, genero ou catalogo no geral)

}