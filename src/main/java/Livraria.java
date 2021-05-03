import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Livraria { // controller

    /* inicializa os dados dos livros, autores e editoras */
    public static void inicializaCatalogo() {
        try {
            Catalogo.leLivro("dados/livros.txt"); 
            Catalogo.leAutor("dados/autores.txt");
            Catalogo.leEditora("dados/editoras.txt");
        } catch (IOException e) {
            System.out.println("Houve um problema na inicialização do catálogo. Por favor, tente novamente.");
        } 
    }
    

    // Mostra todos os livros em ordem alfabética
    public static List<Livro> livrosCatalogo(){
        return Catalogo.getLivros();
    }

    // Mostra os autores em ordem alfabética
    public static List<Autor> autoresCatalogo(){
        return Catalogo.getAutores();
    }

    // Mostra as editoras em ordem alfabética
    public static List<Editora> editorasCatalogo(){
        return Catalogo.getEditoras();
    }
    
    
    /* inicializa os dados dos clientes cadastrados no sistema */
    public static void inicializaClientes(){
        try {
            ManipulaCliente.leCliente("dados/clientes.txt"); 
        } catch (IOException e) {
            System.out.println("Erro na leitura dos clientes cadastrados!");
        } 
    
    }
    
    /* inicializa os dados dos alugueis cadastrados no sistema */
    public static void inicializaAlugueis(){
        try {
           GerenciaAlugueis.leAlugueis("dados/alugueis.txt"); 
        } catch (IOException e) {
            System.out.println("Erro na leitura dos dados referentes às locações de livros da livraria.");
        } 
    
    }
    
   
    /* -------------------- MÉTODOS DE BUSCA -------------------- */
    
    // retorna uma lista com os livros de um determinado autor em ordem alfabética
    public static List<Livro> buscarLivros(Autor autor){
        List<Livro> livros = new ArrayList<Livro>();
        for (Livro l : Catalogo.getLivros()) {
            if (l.getIdAutor() == autor.getId()) {
                livros.add(l);
            }
        }
        return livros;
    }

    // retorna uma lista com os livros de uma determinada editora em ordem alfabética
    public static List<Livro> buscarLivros(Editora editora){
        List<Livro> livros = new ArrayList<Livro>();
        for (Livro l : Catalogo.getLivros()) {
            if (l.getIdEditora() == editora.getId()) {
                livros.add(l);
            }
        }   
        return livros;
    }

    // retorna uma lista com os livros de um determinado genero em ordem alfabética
    public static List<Livro> buscarLivros(String genero){
        List<Livro> livros = new ArrayList<Livro>();
        
        for (Livro l : Catalogo.getLivros()) {
            if (genero.toLowerCase().equals(l.getNomeGenero().toLowerCase())) {
                livros.add(l);
            }
        }
        return livros;
    }

    /* métodos para encontrar um objeto Livro, Autor ou Livraria a partir de seu nome ou id */
    public static int buscaPosLivro(Integer id){
        for(int  i = 0; i < Catalogo.getLivros().size(); i++){
            if(id == Catalogo.getLivros().get(i).getId()){
                return i; /*retorna a posição do livro*/
            }
        }
        return -1; /*livro não encontrado*/
    }
    
    /* métodos buscarLivro: usados para encontrar uma lista de livros com as mesmas caracteristicas */
    public static Livro buscaLivro(Integer id){
        for(Livro l : Catalogo.getLivros()){
            if(id == l.getId()){
                return l;
            }
        }
        return null;
    }

    public static Livro buscaLivro(String titulo){
        for(Livro l : Catalogo.getLivros()) {
            if(titulo.toLowerCase().equals(l.getTitulo().toLowerCase())){
                return l;
              
            }
        }
        return null;
    }

    public static Autor buscaAutor(Integer id){
        for(Autor a : Catalogo.getAutores()){
            if(id.equals(a.getId())){
                return a;
            }
        }
        return null;
    }

    public static Autor buscaAutor(String nome){
        for(Autor a : Catalogo.getAutores()){
            if(nome.toLowerCase().equals(a.getNome().toLowerCase())){
                return a;
            }
        }
        return null;
    }

    public static Editora buscaEditora(Integer id){
        for(Editora e : Catalogo.getEditoras())  {
            if(id.equals(e.getId())){
                return e;
            }
        }
        return null;
    }

    public static Editora buscaEditora(String nome){
        for(Editora e : Catalogo.getEditoras()){
            if(nome.toLowerCase().equals(e.getNome().toLowerCase())){
                return e;
            }
        }
        return null;
    }

    

}