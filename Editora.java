public class Editora {
    private String id;
    private String nome;
    private String cnpj;

    public Editora(String id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + '\n' +
                "CNPJ: " + this.cnpj + '\n';
    }
}
