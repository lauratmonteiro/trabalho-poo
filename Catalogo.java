import java.util.ArrayList;
import java.util.Collections;

public class Catalogo {

    /* Atributos */

    private static ArrayList<Livro> livros = new ArrayList<Livro>();
    private static ArrayList<Editora> editoras = new ArrayList<Editora>();
    private static ArrayList<Autor> autores = new ArrayList<Autor>();

    /* Outros métodos*/

    // Mostra os livros em ordem alfabética
    public static void listarLivros(){
        Collections.sort(livros);
        System.out.println(livros);
    }

    // Mostra os autores em ordem alfabética
    public static void listarAutores(){
        Collections.sort(autores);
        System.out.println(livros);
    }

    // Mostra as editoras em ordem alfabética
    public static void listarEditoras(){
        Collections.sort(editoras);
        System.out.println(editoras);
    }

    // Mostra os generos em ordem alfabética
    public static void listarGeneros(){
        System.out.println( "Autoajuda\n" + 
                            "Drama\n" +
                            "Ficção\n" +
                            "Infantojuvenil\n" +
                            "Jovem adulto\n" + 
                            "Não ficção\n" + 
                            "Policial\n" + 
                            "Quadrinhos\n" +
                            "Romance\n" +
                            "Suspense\n" + 
                            "Terror\n" );
    }

    //TODO: implementar busca (por título do livro, autor, gênero ou editora)
    //TODO: implementar metodo pra mostrar o top3 livros
    
    public static Livro buscaLivroPorId(Integer id){
        for(Livro l : livros){
            if(id == l.getId()){
                return l;
            }
        }
        return null;
    }

    public static Autor buscaAutorPorId(Integer id){
        for(Autor a : autores){
            if(id == a.getId()){
                return a;
            }
        }
        return null;
    }

    /* Métodos para ler os dados de livros, autores e editoras disponíveis */

    public static void addLivro(Livro livro){
        for (Livro l : livros){
            if(livro.getTitulo() == l.getTitulo()){
                if (livro.getIdAutor() == l.getIdAutor()) {
                    return;
                }
            }
        }
        livros.add(livro);
    } // TODO: metodo pra ler o livro do arquivo 

    public static void addAutor(Autor autor){
        for(Autor a : autores){
            if(autor.getNome() == a.getNome()){
                return;
            }
        }
        autores.add(autor);
    } //TODO: metodo pra ler o autor do arquivo

    public static void addEditora(Editora editora){
        for(Editora e : editoras){
            if(editora.getNome() == e.getNome()){
                return;
            }
        }
        editoras.add(editora);
    } //TODO: metodo pra ler a editora do arquivo

}