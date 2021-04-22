public class Aluguel{

    /* Atributos */
    private Livro livro;
    private String dataAluguel;
    private Cliente cliente;

    /* Construtor */
    public Aluguel(Livro livro, String dataAluguel, Cliente cliente){ // a data deve ser passada no formato dd/mm/aaaa
        this.livro = livro;
        this.dataAluguel = dataAluguel;
        this.cliente = cliente;

        // incrementa a qtd de livros alugados no obj livro
        livro.setQtdAlugados(livro.getQtdAlugados() + 1);

    }

    /* getters e setters */
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    /* Valicação necessária do setter da data de aluguel */
    public String validacaoDataAluguel(String valor) throws IllegalArgumentException {        
        if(valor == null || valor.equals("")) 
            throw new IllegalArgumentException("Entrada inválida! Prencha a data de entrega corretamente.");
        return valor;
    }

    /* Essa excessão vai ser tratada por quem chama a setDataAluguel */
    public void setDataAluguel(String dataAluguel) throws IllegalArgumentException {
        this.dataAluguel = validacaoDataAluguel(dataAluguel);
    }

    public String getDataAluguel() {
        return dataAluguel;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    /* Outros métodos */

}