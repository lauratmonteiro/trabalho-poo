import java.util.ArrayList;

public class Autor implements Comparable<Autor> {

    private Integer id;
    private String nome;
    private String nacionalidade;
    private Integer anoNascimento;
    private Integer publicados;
    private Double avaliacao;
    private ArrayList<Integer> avaliacoes = new ArrayList<Integer>();

    /* Construtor */

    public Autor(Integer id, String nome, String nacionalidade, Integer anoNascimento, Integer publicados) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.anoNascimento = anoNascimento;
        this.publicados = publicados;
    }

    /* Setters e getters */

    public Integer getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getNacionalidade(){
        return this.nacionalidade;
    }

    public Integer getAnoNascimento() {
        return this.anoNascimento;
    }

    public Integer getPublicados() {
        return this.publicados;
    }

    public void setAvaliacao(Integer avaliacao) {
        // Adiciona a avaliação à lista de avaliações
        this.avaliacoes.add(avaliacao);
        // Calcula a nova avaliação média
        Integer soma = 0;
        for (Integer i : this.avaliacoes) {
            soma += i;
        }
        // Define a nova avaliação média
        avaliacao = (soma/this.avaliacoes.size());
    }

    /* Outros métodos */

    @Override
    public String toString() {
        return  "Nome: " + this.nome + '\n' +
                "Nacionalidade: " + this.nacionalidade + '\n' +
                "Ano de nascimento: " + this.anoNascimento + '\n' +
                "Quantidade de livros publicados: " + this.publicados + '\n';
    }

    @Override
    public int compareTo(Autor outroAutor) {
        return this.nome.compareTo(outroAutor.nome);
    } // função pra ordenar os autores alfabeticamente
}
