import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livraria { // controller

    public static final int MAX_LIVROS = 5;
    private static ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    /* getters */

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static ArrayList<Aluguel> getAlugueis() {
        return alugueis;
    }

    /* Outros métodos */

    public static void inicializaCatalogo() {
        try {
            Catalogo.leLivro("dados/livros.txt"); 
            Catalogo.leAutor("dados/autores.txt");
            Catalogo.leEditora("dados/editoras.txt");
        } catch (IOException e) {
            System.out.println("Houve um problema na inicialização do catálogo. Por favor, tente novamente.");
        } 
    }

    public static void avaliarLivro(Livro livro, Integer nota) {
        livro.avaliar(nota);
        buscaAutor(livro.getIdAutor()).avaliar(nota);
    }

    public static void salvaCliente(String nome, String nacionalidade, Integer anoNascimento, String cpf){
        Cliente clienteNovo = new Cliente(nome, nacionalidade, anoNascimento, cpf, true);
        clientes.add(clienteNovo);
    }

    public static void removeCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public static void salvaAluguel(Livro livro, String dataAluguel, Cliente cliente) {
        Aluguel novoAluguel = new Aluguel(livro, dataAluguel, cliente); // cria um obj da classe Aluguel com os dados
        alugueis.add(novoAluguel);
    }

    public static void removeAluguel(Aluguel aluguel) {
        alugueis.remove(aluguel);
        int qtd = aluguel.getLivro().getQtdAlugados();
        aluguel.getLivro().setQtdAlugados(qtd-1);
    }

    // verifica se o cliente pode alugar novos livros
    public static Boolean verificaLimite(Cliente c) {
        if (c.getQtdLivrosAlugados() == MAX_LIVROS) 
            return false; // retorna falso se tiver o maximo
        return true; // retorna verdadeiro se ainda houver limite disponivel
    }

    // verifica se ainda ha exemplares desse livro disponiveis para alugar
    public static Boolean verificaDisponibilidade(Livro l) {
        if (l.getQtdExemplares() == l.getQtdAlugados()) 
            return false; // retorna falso caso o livro não esteja disponível
        return true;
    }


    /* -------------------- MÉTODOS DE BUSCA -------------------- */

    /* métodos para mostrar os livros, autores e editoras disponíveis */

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

    /* métodos buscarLivro: usados para encontrar uma lista de livros com as mesmas caracteristicas */

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
            if (genero == l.getNomeGenero()) {
                livros.add(l);
            }
        }
        return livros;
    }

    /* métodos para encontrar um objeto Livro, Autor ou Livraria a partir de seu nome ou id */

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
            if(titulo.toLowerCase() == l.getTitulo().toLowerCase()){
                return l;
            }
        }
        return null;
    }

    public static Autor buscaAutor(Integer id){
        for(Autor a : Catalogo.getAutores()){
            if(id == a.getId()){
                return a;
            }
        }
        return null;
    }

    public static Autor buscaAutor(String nome){
        for(Autor a : Catalogo.getAutores()){
            if(nome.toLowerCase() == a.getNome().toLowerCase()){
                return a;
            }
        }
        return null;
    }

    public static Editora buscaEditora(Integer id){
        for(Editora e : Catalogo.getEditoras())  {
            if(id == e.getId()){
                return e;
            }
        }
        return null;
    }

    public static Editora buscaEditora(String nome){
        for(Editora e : Catalogo.getEditoras()){
            if(nome.toLowerCase() == e.getNome().toLowerCase()){
                return e;
            }
        }
        return null;
    }

}