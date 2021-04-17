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

    public void addLivro(Livro livro){
        for (Livro l : this.livros){
            if(livro.getTitulo() == l.getTitulo()){
                return;
            }
        }
        livros.add(livro);
    }

    public void addAutor(Autor autor){
        for(Autor a : this.autores){
            if(autor.getNome() == a.getNome()){
                return;
            }
        }
        autores.add(autor);
    }

    public void addEditora(Editora editora){
        for(Editora e : this.editoras){
            if(editora.getNome() == e.getNome()){
                return;
            }
        }
        editoras.add(editora);
    }

    public void addGenero(Genero genero){
        for(Genero g : this.generos){
            if(genero.getNomeGenero() == g.getNomeGenero()){
                return;
            }
        }
        generos.add(genero);
    }

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
    
    public Livro buscaLivroPorId(Integer id){
        for(Livro l : this.livros){
            if(id == l.getId()){
                return l;
            }
        }
        return null;
    }

    public Autor buscaAutorPorId(Integer id){
        for(Autor a : this.autores){
            if(id == a.getId()){
                return a;
            }
        }
        return null;
    }

    //TODO: implementar metodo pra mostrar o top3 livros de alguma categoria (autor, genero ou catalogo no geral)

}