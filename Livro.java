import java.util.ArrayList;

public class Livro implements Comparable<Livro> {
    
    private String titulo;
    private Integer id;
    private Genero nomeGenero;
    private Integer numPaginas;
    private String sinopse;
    private Integer idAutor;
    private String idEditora;
    private Integer anoPublicacao;
    private String edicao;
    private Integer qtdExemplares;
    private Integer qtdAlugados;
    private Double avaliacao; // media das avaliações dos leitores armazenadas em avaliacoes
    private ArrayList<Integer> avaliacoes = new ArrayList<Integer>();

    /* Construtor */

    public Livro(Integer id, String titulo, genero nomeGenero, Integer numPaginas, String sinopse, Integer idAutor, String idEditora,
                 Integer anoPublicacao, String edicao) {
        this.id = id;
        this.titulo = titulo;
        this.nomeGenero = nomeGenero;
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

    public String getNomeGenero() {
        //TODO: transforma os nomes em Strings bonitinhas pra imprimir
        switch (this.nomeGenero) {
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
        buscaAutorPorId(this.idAutor).setAvaliacao(avaliacao);
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
                "Genero: " + this.getnomeGenero() + '\n' +
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