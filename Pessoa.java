public class Pessoa {

    private String nome;
    private String nacionalidade;
    private Integer anoNascimento;

    /* Construtor */


    public Pessoa(String nome, String nacionalidade, Integer anoNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.anoNascimento = anoNascimento;
    }

    /* setters e getters */

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNacionalidade(){
        return this.nacionalidade;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoNascimento() {
        return this.anoNascimento;
    }
    
}
