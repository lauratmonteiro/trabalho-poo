import java.util.ArrayList;

public class Livro {
    
    private String titulo;
    private String idGenero;
    private Integer numPaginas;
    private String sinopse;
    private String idAutor;
    private String idEditora;
    private String dataPublicacao;
    private Integer anoPublicacao;
    private String edicao;
    private Double avaliacao;
    private ArrayList<Integer> avaliacoes = new ArrayList<Integer>();

    /* Construtor */

    public Livro(String titulo, String idGenero, Integer numPaginas, String sinopse, String idAutor, String idEditora,
                 String dataPublicacao, Integer anoPublicacao, String edicao) {
        this.titulo = titulo;
        this.idGenero = idGenero;
        this.numPaginas = numPaginas;
        this.sinopse = sinopse;
        this.idAutor = idAutor;
        this.idEditora = idEditora;
        this.dataPublicacao = dataPublicacao;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;
    }

    /* Setters e getters */

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

    public String getDataPublicacao() {
        return this.dataPublicacao;
    }

    public Integer getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public String getEdicao() {
        return this.edicao;
    }

    public void setAvaliacao(Integer avaliacao) {
        // Adiciona a avaliação à lista de avaliações
        avaliacoes.add(avaliacao);
        // Calcula a nova avaliação média
        Integer soma = 0;
        for (Integer i : avaliacoes) {
            soma += i;
        }
        // Define a nova avaliação média
        avaliacao = (soma/avaliacoes.size());
        //TODO: atribuir a nota ao autor também
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    /* Outros métodos */

    @Override
    public String toString() {
        return  "Titulo: " + this.titulo + '\n' +
                "Numero de paginas: " + this.numPaginas + '\n' +
                "Sinopse: " + this.sinopse + '\n' +
                "Ano de publicacao: " + this.anoPublicacao + '\n' +
                "Edicao" + this.edicao + '\n';
    }
}