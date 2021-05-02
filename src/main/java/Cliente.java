public class Cliente extends Pessoa implements Comparable<Cliente>{ 
    
    private String cpf;
    private Boolean assinante;
    private Integer qtdLivrosAlugados;

    /* Construtor */

    public Cliente (String nome, String nacionalidade, String anoNascimento, String cpf, Boolean assinante, Integer qtdLivrosAlugados) {
        super(nome, nacionalidade, anoNascimento);
        this.cpf = cpf;
        this.assinante = assinante;
        this.qtdLivrosAlugados = qtdLivrosAlugados;
    }

    /* Setters e getters */

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setAssinante(Boolean assinante) {
        this.assinante = assinante;
    }

    public Boolean getAssinante() {
        return assinante;
    }

    public void setQtdLivrosAlugados(Integer qtdLivrosAlugados) {
        this.qtdLivrosAlugados = qtdLivrosAlugados;
    }

    public Integer getQtdLivrosAlugados() {
        return qtdLivrosAlugados;
    }

    /* Outros métodos */

    public void comprarAssinatura() {
        this.setAssinante(true);
    }

    public void cancelarAssinatura() {
        this.setAssinante(false);
    }
       
    @Override
    public String toString() {
        return  "Nome do cliente: " + this.getNome() + "\n" +
                "CPF do cliente: " + this.getCpf() + "\n";
    }

    @Override
    public int compareTo(Cliente outroCliente) {
        return this.getNome().compareTo(outroCliente.getNome());
    } // função pra ordenar os clientes alfabeticamente
    
}
