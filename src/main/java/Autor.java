import java.util.ArrayList;

public class Autor extends Pessoa implements Avaliacao, Comparable<Autor> {
    
    /* Atributos */
    private Integer id;
    public Double avaliacao;
    private ArrayList<Integer> avaliacoes = new ArrayList<Integer>();

    /* Construtor */

    public Autor(Integer id, String nome, String nacionalidade, String anoNascimento, Double avaliacao) {
        super(nome, nacionalidade, anoNascimento);
        this.id = id;
        this.avaliacao =  avaliacao;
    }

    /* Setters e getters */

    public Integer getId(){
        return this.id;
    }
    
    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
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
