import java.util.ArrayList;

public class Livro implements Avaliacao, Comparable<Livro> {

    /* Atributos */
    private  Integer id;
    private  String titulo;
    private Integer idAutor;
    private Integer idEditora;
    private Genero genero;
    private Integer anoPublicacao;
    private String edicao;
    private Integer numPaginas;
    private String sinopse;
    private Integer qtdExemplares;
    private Integer qtdAlugados;
    public Double avaliacao ;// media das avaliações dos leitores armazenadas em avaliacoes
    private ArrayList<Integer> avaliacoes = new ArrayList<Integer>();

    /* Construtor */

    public Livro(Integer id, String titulo, Integer idAutor, Integer idEditora, Genero genero, Integer anoPublicacao, String edicao, Integer numPaginas, String sinopse, Integer qtdExemplares, Integer qtdAlugados, Double avaliacao) {
        this.id = id;
        this.titulo = titulo;
        this.idAutor = idAutor;
        this.idEditora = idEditora;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;
        this.numPaginas = numPaginas;
        this.sinopse = sinopse;
        this.qtdExemplares = qtdExemplares;
        this.qtdAlugados = qtdAlugados;
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

    public Integer getIdEditora() {
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
    
    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    public Double getAvaliacao() {
        return this.avaliacao;
    }

    /* Outros métodos */

    @Override
    public String toString() {
        return  "Titulo: " + this.titulo + " - ID: " + this.id + '\n' +
                "Autor: " + Livraria.buscaAutor(this.getIdAutor()).getNome() + '\n' +
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
        avaliacoes.add(nota);
        int soma = 0;
        double mediaAvaliacoes = 0;
        for(int i = 0; i < avaliacoes.size(); i++){
            soma+= avaliacoes.get(i);
        
        }
        mediaAvaliacoes = soma/avaliacoes.size();
        this.setAvaliacao(mediaAvaliacoes );
    }
}

