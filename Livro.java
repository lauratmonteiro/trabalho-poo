import java.util.ArrayList;

public class Livro implements Comparable<Livro> {
    
    private String titulo;
    private Integer id;
    private String idGenero;
    private Integer numPaginas;
    private String sinopse;
    private String idAutor;
    private String idEditora;
    private Integer anoPublicacao;
    private String edicao;
    private Integer qtdExemplares;
    private Integer qtdAlugados;
    private Double avaliacao; // media das avaliações dos leitores armazenadas em avaliacoes
    private ArrayList<Integer> avaliacoes = new ArrayList<Integer>();

    /* Construtor */

    public Livro(Integer id, String titulo, String idGenero, Integer numPaginas, String sinopse, String idAutor, String idEditora,
                 Integer anoPublicacao, String edicao) {
        this.id = id;
        this.titulo = titulo;
        this.idGenero = idGenero;
        this.numPaginas = numPaginas;
        this.sinopse = sinopse;
        this.idAutor = idAutor;
        this.idEditora = idEditora;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;
    }

    /* Setters e getters */

    public Integer getId() {
        return id;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getIdGenero() {
        return this.idGenero;
    }

    public Integer getNumPaginas() {
        return this.numPaginas;
    }

    public String getSinopse() {
        return this.sinopse;
    }

    public String getIdAutor() {
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
        //TODO: atribuir a nota ao autor também
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
        return  "Titulo: " + this.titulo + " - " + this.id + '\n' +
                "Numero de paginas: " + this.numPaginas + '\n' +
                "Sinopse: " + this.sinopse + '\n' +
                "Ano de publicacao: " + this.anoPublicacao + '\n' +
                "Edicao" + this.edicao + '\n';
    }

    @Override
    public int compareTo(Livro outroLivro) {
        return this.titulo.compareTo(outroLivro.titulo);
    } // função pra ordenar os livros alfabeticamente

}