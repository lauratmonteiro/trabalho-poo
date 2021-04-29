import java.util.ArrayList;

public class Livro implements Avaliacao, Comparable<Livro> {
    
    private Integer id;
    private String titulo;
    private Integer idAutor;
    private String idEditora;
    private Genero genero;
    private Integer anoPublicacao;
    private String edicao;
    private Integer numPaginas;
    private String sinopse;
    private Integer qtdExemplares;
    private Integer qtdAlugados;
    private Double avaliacao; // media das avaliações dos leitores armazenadas em avaliacoes
    private ArrayList<Integer> avaliacoes = new ArrayList<Integer>();

    /* Construtor */

    public Livro(Integer id, String titulo, Integer idAutor, String idEditora, Genero genero, Integer anoPublicacao, String edicao, Integer numPaginas, String sinopse, Double avaliacao) {
        this.id = id;
        this.titulo = titulo;
        this.idAutor = idAutor;
        this.idEditora = idEditora;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;
        this.numPaginas = numPaginas;
        this.sinopse = sinopse;
        this.avaliacao = avaliacao; // Inicializada com a nota do Goodreads (a partir da primeira avaliação, passa a ser a média das avaliações dos clientes)
    }

    /* Setters e getters */

    public Integer getId() {
        return id;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public String getNomeGenero() {
        // Transforma os nomes em Strings bonitinhas pra imprimir
        switch (this.genero) {
            case AUTOAJUDA: return "Autoajuda";
            case DRAMA: return "Drama"; 
            case FICCAO: return "Ficção";
            case INFANTOJUVENIL: return "Infantojuvenil";
            case JOVEM_ADULTO: return "Jovem Adulto"; 
            case NAO_FICCAO: return "Não-ficção";
            case POLICIAL: return "Policial"; 
            case QUADRINHOS: return "Quadrinhos";
            case ROMANCE: return "Romance";
            case SUSPENSE: return "Suspense";
            case TERROR: return "Terror"; 
        }
        return null;
    }

    public Integer getNumPaginas() {
        return this.numPaginas;
    }

    public String getSinopse() {
        return this.sinopse;
    }

    public Integer getIdAutor() {
        return this.idAutor;
    }

    public String getIdEditora() {
        return this.idEditora;
    }

    public Integer getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public String getEdicao() {
        return this.edicao;
    }

    public void setQtdExemplares(Integer qtdExemplares) {
        this.qtdExemplares = qtdExemplares;
    }

    public Integer getQtdExemplares() {
        return qtdExemplares;
    }

    public void setQtdAlugados(Integer qtdAlugados) {
        this.qtdAlugados = qtdAlugados;
    }

    public Integer getQtdAlugados() {
        return this.qtdAlugados;
    }

    public void setAvaliacao(Integer avaliacao) {
        // Adiciona a avaliação à lista de avaliações
        avaliacoes.add(avaliacao);
        // Calcula a nova avaliação média
        Integer soma = 0;
        for (Integer i : this.avaliacoes) {
            soma += i;
        }
        // Define a nova avaliação média
        avaliacao = (soma/this.avaliacoes.size());
        Catalogo.buscaAutorPorId(this.idAutor).avaliar(avaliacao);
    }

    public Double getAvaliacao() {
        return this.avaliacao;
    }

    /* Outros métodos */

    // verifica se ainda ha exemplares desse livro disponiveis para alugar
    public int verificaDisponibilidade() {
        if (this.qtdExemplares > this.qtdAlugados) 
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return  "Titulo: " + this.titulo + " - ID: " + this.id + '\n' +
                "Autor: " + Catalogo.buscaAutorPorId(this.getIdAutor()).getNome() + '\n' +
                "Genero: " + this.getNomeGenero() + '\n' +
                "Numero de paginas: " + this.numPaginas + '\n' +
                "Sinopse: " + this.sinopse + '\n' +
                "Ano de publicacao: " + this.anoPublicacao + " - " + this.edicao + "ª Edição\n";
    }

    @Override
    public int compareTo(Livro outroLivro) {
        return this.titulo.compareTo(outroLivro.titulo);
    } // função pra ordenar os livros alfabeticamente

    @Override
    public void avaliar(Integer nota) {
        this.setAvaliacao(nota);
    }

}