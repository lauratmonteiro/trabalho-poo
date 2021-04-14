public class Livro {
    private String titulo;
    private String idGenero;
    private int numPaginas;
    private String sinopse;
    private String idAutor;
    private String idEditora;
    private String dataPublicacao;
    private int anoPublicacao;
    private String edicao;


    public Livro(String titulo, String idGenero, int numPaginas, String sinopse, String idAutor, String idEditora,
                 String dataPublicacao, int anoPublicacao, String edicao) {
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

    public String getTitulo(){
        return this.titulo;
    }

    public String getIdGenero() {
        return this.idGenero;
    }

    public int getNumPaginas() {
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

    public int getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public String getEdicao() {
        return this.edicao;
    }

    @Override
    public String toString() {
        return "Titulo: " + this.titulo + '\n' +
                "Numero de paginas: " + this.numPaginas + '\n' +
                "Sinopse: " + this.sinopse + '\n' +
                "Ano de publicacao: " + this.anoPublicacao + '\n' +
                "Edicao" + this.edicao + '\n';
    }
}