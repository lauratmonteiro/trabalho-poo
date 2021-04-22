public class Cliente implements Avaliacao { // Tem que implementar Avaliação, mas não consegue por causa do package
    
    private String nome;
    private String cpf;
    private Boolean assinante;
    private Integer qtdLivrosAlugados;

    /* Construtor */

    public Cliente (String nome, String cpf, Boolean assinante) {
        this.nome = nome;
        this.cpf = cpf;
        this.assinante = assinante;
    }
    
    /* Setters e getters */

    /* Validação necessária de alguns setters */
    public String validacaoNome(String valor) throws IllegalArgumentException {        
        if(valor == null || valor.equals("")) 
            throw new IllegalArgumentException("Entrada inválida! Prencha o nome do Cliente corretamente.");
        return valor;
    }

    public String validacaoCPF(String valor) throws IllegalArgumentException {        
        if(valor == null || valor.equals("")) 
            throw new IllegalArgumentException("Entrada inválida! Prencha o CPF do Cliente corretamente.");
        return valor;
    }

    /* Essas exceções vão ser tratadas apenas por quem chamar esses setters */
    public  void  setNome ( String  nome ) throws IllegalArgumentException {
        this.nome = validacaoNome(nome);
    }

    public  String  getNome () {
        return nome;
    }

    public  void  setCpf ( String  cpf ) throws IllegalArgumentException {
        this.cpf = cpf;
    }

    public  String  getCpf () {
        return cpf;
    }

    public  void  setAssinante ( Boolean  assinante ) {
        this.assinante = assinante;
    }

    public  Boolean  getAssinante () {
        retorno assinante;
    }

    public  void  setQtdLivrosAlugados ( Integer  qtdLivrosAlugados ) {
        this.qtdLivrosAlugados = qtdLivrosAlugados;
    }

    public  Integer  getQtdLivrosAlugados () {
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
    public void avaliar(Livro livro, Integer nota) {
        livro.setAvaliacao(nota);
    }

    @Override
    public String toString() {
        return  "Nome do cliente: " + this.nome + "\n" +
                "CPF do cliente: " + this.cpf + "\n";
    }

}
