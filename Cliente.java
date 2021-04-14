public class Cliente implements Avaliacao { // Tem que implementar Avaliação, mas não consegue por causa do package
    
    private String nome;
    private String cpf;
    // private Integer numCompras -> podemos fazer um sisteminha de a cada X compras o cliente ganha 20% de desconto

    /* Construtor */

    public Cliente (String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    /* Setters e getters */
    //TODO: fazer validação dos setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    /* Outros métodos */

    @Override
    public void avaliar(Livro livro, Integer nota) {
        livro.setAvaliacao(nota);
    }

    @Override
    public String toString() {
        return  "Nome do cliente: " + this.nome + "\n" +
                "CPF do cliente: " + this.cpf + "\n";
    }

}
