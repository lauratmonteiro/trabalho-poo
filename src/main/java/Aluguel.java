public class Aluguel{

    /* Atributos */
    private String cpfCliente;
    private Integer idLivro;
    private String dataAluguel;
    private String dataEntrega;
    public Boolean devolvido;
    

    /* Construtor */
    public Aluguel(String cpfCliente, Integer idLivro, String dataAluguel,String dataEntrega, Boolean devolvido){ // a data deve ser passada no formato dd/mm/aaaa
        this.cpfCliente = cpfCliente;
        this.idLivro = idLivro;
        this.dataAluguel = dataAluguel;
        this.dataEntrega = dataEntrega;
        this.devolvido = devolvido;
        

    }

    /* getters e setters */
    
    public String getCpfCliente() {
        return cpfCliente;
    }
    
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    
    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public void setDataAluguel(String dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public String getDataAluguel() {
        return dataAluguel;
    }
    
    public String getDataEntrega() {
        return dataEntrega;
    }
    
    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    
    public Boolean getDevolvido() {
        return devolvido;
    }
    
    public void setDevolvido(Boolean devolvido) {
        this.devolvido = devolvido;
    }
    

}