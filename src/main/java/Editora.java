public class Editora implements Comparable<Editora> {
    
    private Integer id;
    private String nome;
    private String cnpj;

    /* Construtor */

    public Editora(Integer id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    /* Setters e getters */

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    /* Outros métodos */

    @Override
    public String toString() {
        return  "Nome: " + this.nome + '\n' +
                "CNPJ: " + this.cnpj + '\n';
    }

    @Override
    public int compareTo(Editora outraEditora) {
        return this.nome.compareTo(outraEditora.nome);
    } // função pra ordenar as editoras alfabeticamente
    
}
