import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Livraria { // controller

    public static final int MAX_LIVROS = 5;
    private static ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    /* getters */

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static ArrayList<Aluguel> getAlugueis() {
        return alugueis;
    }

    /* métodos para inicializar e finalizar o programa */

    public static void inicializaPrograma() {
        try {
            Catalogo.leLivro("dados/livros.txt");
            Catalogo.leAutor("dados/autores.txt");
            Catalogo.leEditora("dados/editoras.txt");
            leClientes("dados/clientes.txt");
            leAlugueis("dados/alugueis.txt")
        } catch (IOException e) {
            System.out.println("Houve um problema na inicialização do catálogo. Por favor, tente novamente.");
        }
    }

    //TODO: terminar
    public static void finalizaPrograma() throws IOException {
        escreveClientes();
        escreveAlugueis();
        Catalogo.escreveLivros();
        Catalogo.escreveAutores();
    }

    /* métodos para manipulação de arquivos */

    // le o arquivo que contem os dados dos clientes 
    public static void leClientes(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (new FileInputStream(caminhoArquivo), "UTF-8")); //TODO: consertar isso aqui
        String linha = "";
        linha = br.readLine();

        while(linha != null){
            String[] dados = linha.split(";", 6);
            Cliente cliente = new Cliente(
                    dados[0], //nome
                    dados[1], //nacionalidade
                    Integer.valueOf(dados[2]), //anoNascimento
                    dados[3], //cpf
                    Boolean.valueOf(dados[4]), //assinante
                    Integer.valueOf(dados[5])); //qtdLivrosAlugados
            clientes.add(cliente);
            linha = br.readLine();
        }

        br.close();

    }

    // salva os clientes no arquivo de dados
    public static void escreveClientes() throws IOException {

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("dados/clientes.txt", false));
            br.write("");
    
            for (Cliente c : Livraria.getClientes()) {
                armazenaCliente("dados/clientes.txt", c);
            }
    
            br.close();
        } catch (IOException e) {
            throw new IOException("Arquivo não encontrado. Por favor, tente novamente.");
        }
    }

    // le o arquivo que contem os alugueis 
    public static void leAlugueis(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (new FileInputStream(caminhoArquivo), "UTF-8"));
        String linha = "";
        linha = br.readLine();

        while(linha != null){
            String[] dados = linha.split(";", 3);
            Aluguel aluguel = new Aluguel(
                    buscaLivro(Integer.valueOf(dados[0])), //id Livro
                    dados[1], //data aluguel
                    buscaCliente(dados[2]) //cpf Cliente
            );
            alugueis.add(aluguel);
            linha = br.readLine();
        }
        br.close();
    }

    // salva os clientes no arquivo de dados
    public static void escreveAlugueis() throws IOException {

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("dados/clientes.txt", false));
            br.write("");
    
            for (Aluguel a : Livraria.getAlugueis()) {
                armazenaAluguel("dados/clientes.txt", a);
            }

            br.close();

        } catch (IOException e) {
            throw new IOException("Arquivo não encontrado. Por favor, tente novamente.");
        }
    }

    /* métodos para manipular alugueis */

    public static void salvaAluguel(Livro livro, String dataAluguel, Cliente cliente) {
        Aluguel novoAluguel = new Aluguel(livro, dataAluguel, cliente); // cria um obj da classe Aluguel com os dados
        int qtd = novoAluguel.getLivro().getQtdAlugados();
        novoAluguel.getLivro().setQtdAlugados(qtd+1);
        cliente.setQtdLivrosAlugados(cliente.getQtdLivrosAlugados()+1);
        alugueis.add(novoAluguel);
    }

    public static void armazenaAluguel(String caminhoArquivo, Aluguel aluguel) {
 
        try {

            BufferedWriter br = new BufferedWriter(new FileWriter(caminhoArquivo,  true));

            br.write(aluguel.getLivro().getId());
            br.write(";");            

            br.write(aluguel.getDataAluguel());
            br.write(";");          

            br.write(aluguel.getCliente().getCpf());
            br.write(";");            
            
            br.newLine();
            br.close();

        } catch (IOException e) {
            e.getMessage();
        }

    }

    public static void removeAluguel(Aluguel aluguel) {
        alugueis.remove(aluguel);
        int qtd = aluguel.getLivro().getQtdAlugados();
        aluguel.getLivro().setQtdAlugados(qtd-1);
        aluguel.getCliente().setQtdLivrosAlugados(aluguel.getCliente().getQtdLivrosAlugados()-1);
    }

    /* métodos para manipular clientes */

    // TESTAR
    // cria e salva um novo cliente (será escrito no arquivo assim que o programa for encerrado)
    public static void salvaCliente(String nome, String nacionalidade, Integer anoNascimento, String cpf) {
        Cliente clienteNovo = new Cliente(nome, nacionalidade, anoNascimento, cpf, true, 0);
        clientes.add(clienteNovo);
    }

    // TESTAR
    // salva um cliete no arquivo de dados
    public static void armazenaCliente(String caminhoArquivo, Cliente cliente) throws IOException {
        try {
            
            BufferedWriter br = new BufferedWriter(new FileWriter(caminhoArquivo, true));

            br.write(cliente.getNome());
            br.write(";");
    
            br.write(cliente.getNacionalidade());
            br.write(";");
    
            br.write(cliente.getAnoNascimento());
            br.write(";");
    
            br.write(cliente.getCpf());
            br.write(";");
    
            /* Quando o cliente faz o cadastro já obtêm a assinatura da livraria */
            br.write("true");
            br.write(";");
    
            /* Ao se cadastrar a quantidade de livros alugados é nula */
            br.write("0");
    
            br.newLine();
            br.close();

        } catch (IOException e) {
            throw new IOException("Arquivo não encontrado.");
        }
    }

    // remove um cliente do array (será removido do arquivo assim que o programa for encerrado)
    public static void removeCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    // TESTAR
    // busca um determinado cliente pelo seu cpf 
    public static Cliente buscaCliente(String cpfBuscado){
        for (Cliente c : clientes) {
            if (cpfBuscado == c.getCpf()) {
                return c;
            }
        }
        return null; //caso não encontre o cliente
    }

    /* outros métodos */

    public static void avaliarLivro(Livro livro, Integer nota) {
        livro.avaliar(nota);
        buscaAutor(livro.getIdAutor()).avaliar(nota);
    }

    // verifica se o cliente pode alugar novos livros
    public static Boolean verificaLimite(Cliente c) {
        if (c.getQtdLivrosAlugados() == MAX_LIVROS)
            return false; // retorna falso se tiver o maximo
        return true; // retorna verdadeiro se ainda houver limite disponivel
    }

    // verifica se ainda ha exemplares desse livro disponiveis para alugar
    public static Boolean verificaDisponibilidade(Livro l) {
        if (l.getQtdExemplares() == l.getQtdAlugados())
            return false; // retorna falso caso o livro não esteja disponível
        return true;
    }


    /* -------------------- MÉTODOS DE BUSCA -------------------- */

    /* métodos para mostrar os livros, autores e editoras disponíveis */

    // Mostra todos os livros em ordem alfabética
    public static List<Livro> livrosCatalogo() {
        return Catalogo.getLivros();
    }

    // Mostra os autores em ordem alfabética
    public static List<Autor> autoresCatalogo() {
        return Catalogo.getAutores();
    }

    // Mostra as editoras em ordem alfabética
    public static List<Editora> editorasCatalogo() {
        return Catalogo.getEditoras();
    }

    /* métodos buscarLivro: usados para encontrar uma lista de livros com as mesmas caracteristicas */

    // retorna uma lista com os livros de um determinado autor em ordem alfabética
    public static List<Livro> buscarLivros(Autor autor) {
        List<Livro> livros = new ArrayList<Livro>();
        for (Livro l : Catalogo.getLivros()) {
            if (l.getIdAutor() == autor.getId()) {
                livros.add(l);
            }
        }
        return livros;
    }

    // retorna uma lista com os livros de uma determinada editora em ordem alfabética
    public static List<Livro> buscarLivros(Editora editora) {
        List<Livro> livros = new ArrayList<Livro>();
        for (Livro l : Catalogo.getLivros()) {
            if (l.getIdEditora() == editora.getId()) {
                livros.add(l);
            }
        }
        return livros;
    }

    // retorna uma lista com os livros de um determinado genero em ordem alfabética
    public static List<Livro> buscarLivros(String genero) {
        List<Livro> livros = new ArrayList<Livro>();
        for (Livro l : Catalogo.getLivros()) {
            if (genero == l.getNomeGenero()) {
                livros.add(l);
            }
        }
        return livros;
    }

    /* métodos para encontrar um objeto Livro, Autor ou Livraria a partir de seu nome ou id */

    public static Livro buscaLivro(Integer id) {
        for (Livro l : Catalogo.getLivros()) {
            if (id == l.getId()) {
                return l;
            }
        }
        return null;
    }

    public static Livro buscaLivro(String titulo) {
        for (Livro l : Catalogo.getLivros()) {
            if (titulo.toLowerCase() == l.getTitulo().toLowerCase()) {
                return l;
            }
        }
        return null;
    }

    public static Autor buscaAutor(Integer id) {
        for (Autor a : Catalogo.getAutores()) {
            if (id == a.getId()) {
                return a;
            }
        }
        return null;
    }

    public static Autor buscaAutor(String nome) {
        for (Autor a : Catalogo.getAutores()) {
            if (nome.toLowerCase() == a.getNome().toLowerCase()) {
                return a;
            }
        }
        return null;
    }

    public static Editora buscaEditora(Integer id) {
        for (Editora e : Catalogo.getEditoras()) {
            if (id == e.getId()) {
                return e;
            }
        }
        return null;
    }

    public static Editora buscaEditora(String nome) {
        for (Editora e : Catalogo.getEditoras()) {
            if (nome.toLowerCase() == e.getNome().toLowerCase()) {
                return e;
            }
        }
        return null;
    }

}

