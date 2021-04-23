import java.util.ArrayList;

public class Autor extends Pessoa implements Avaliacao, Comparable<Autor> {

    private Integer id;
    private Double avaliacao;
    private ArrayList<Integer> avaliacoes = new ArrayList<Integer>();

    /* Construtor */

    public Autor(String nome, String nacionalidade, Integer anoNascimento, Integer id) {
        super(nome, nacionalidade, anoNascimento);
        this.id = id;
    }

    /* Setters e getters */

    public Integer getId(){
        return this.id;
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
        return  "Nome: " + this.getNome() + '\n' +
                "Nacionalidade: " + this.getNacionalidade() + '\n' +
                "Ano de nascimento: " + this.getAnoNascimento() + '\n';
    }

    @Override
    public int compareTo(Autor outroAutor) {
        return this.getNome().compareTo(outroAutor.getNome());
    } // função pra ordenar os autores alfabeticamente

    @Override
    public void avaliar(Integer nota) {
        this.setAvaliacao(nota);
    }
    
}
