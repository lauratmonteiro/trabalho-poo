/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Cliente extends Pessoa{ // Tem que implementar Avaliação, mas não consegue por causa do package
    
    private String cpf;
    private Boolean assinante;
    private Integer qtdLivrosAlugados;

    /* Construtor */

    public Cliente (String nome, String nacionalidade, Integer anoNascimento, String cpf, Boolean assinante) {
        super(nome, nacionalidade, anoNascimento);
        this.cpf = cpf;
        this.assinante = assinante;
    }

    /* Setters e getters */
    //TODO: fazer validação dos setters

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

}
