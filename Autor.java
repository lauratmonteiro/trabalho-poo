public class Autor {
    private String id;
    private String nome;
    private String nacionalidade;
    private int anoNascimento;
    private int publicados;

    public Autor(String nome, String nacionalidade, int anoNascimento, int publicados) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.anoNascimento = anoNascimento;
        this.publicados = publicados;
    }

    public String getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getNacionalidade(){
        return this.nacionalidade;
    }

    public int getAnoNascimento() {
        return this.anoNascimento;
    }

    public int getPublicados() {
        return this.publicados;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + '\n' +
                "Nacionalidade: " + this.nacionalidade + '\n' +
                "Ano de nascimento: " + this.anoNascimento + '\n' +
                "Quantidade de livros publicados: " + this.publicados + '\n';
    }
}
