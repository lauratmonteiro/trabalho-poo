public class Pessoa {
    
    /* Atributos */
    private String nome;
    private String nacionalidade;
    private String anoNascimento;

    /* Construtor */


    public Pessoa(String nome, String nacionalidade, String anoNascimento) {
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

    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getAnoNascimento() {
        return this.anoNascimento;
    }
    
}
