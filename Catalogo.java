import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.util.Collections;

public class Catalogo {

    /* Atributos */

    private static ArrayList<Livro> livros = new ArrayList<Livro>();
    private static List<Editora> editoras = new ArrayList<Editora>();
    private static List<Autor> autores = new ArrayList<Autor>();

    /* getters */

    public static ArrayList<Livro> getLivros() {
        Collections.sort(livros);
        return livros;
    }

    public static List<Autor> getAutores() {
        Collections.sort(autores);
        return autores;
    }

    public static List<Editora> getEditoras() {
        Collections.sort(editoras);
        return editoras;
    }

    /* outros métodos */

    /* Métodos para ler os dados de livros, autores e editoras disponíveis */

    public static void leLivro(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (new FileInputStream(caminhoArquivo), "UTF-8"));
        String linha = br.readLine();

        while(linha != null){
            String[] dados = linha.split(";", 12);
            Livro livro = new Livro(
                    Integer.valueOf(dados[0]), // id
                    dados[1], // titulo
                    Integer.valueOf(dados[2]), // idAutor
                    Integer.valueOf(dados[3]), // idEditora
                    Genero.values()[Integer.valueOf(dados[4])], // genero
                    Integer.valueOf(dados[5]), // anoPublicacao
                    Integer.valueOf(dados[6]), // edicao
                    Integer.valueOf(dados[7]), // numPaginas
                    dados[8], // sinopse
                    Integer.valueOf(dados[9]), // qtdExemplares
                    Integer.valueOf(dados[10]), // qtdAlugados
                    Double.valueOf(dados[11])); // avaliacao
            linha = br.readLine();
            livros.add(livro);
        }

        br.close();
    }

    // TESTAR
    // salva os clientes no arquivo de dados
    public static void escreveLivros() throws IOException {

        try {
            FileWriter fw = new FileWriter("dados/livros.txt");
            PrintWriter pw = new PrintWriter(fw);
    
            for (Livro l : Livraria.livrosCatalogo()) {
                pw.printf("%1$s;", l.getId());
                pw.printf("%1$s;", l.getTitulo());
                pw.printf("%1$s;", l.getIdAutor());
                pw.printf("%1$s;", l.getIdEditora());
                pw.printf("%1$s;", l.getGenero().ordinal());
                pw.printf("%1$s;", l.getAnoPublicacao());
                pw.printf("%1$s;", l.getEdicao());
                pw.printf("%1$s;", l.getNumPaginas());
                pw.printf("%1$s;", l.getSinopse());
                pw.printf("%1$s;", l.getQtdExemplares());
                pw.printf("%1$s;", l.getQtdAlugados());
                pw.printf("%1$s%n", l.getAvaliacao());
                pw.flush();
            }

            fw.close();

        } catch (IOException e) {
            throw new IOException("Arquivo não encontrado. Por favor, tente novamente.");
        }

    }

        // TESTAR
    // salva os clientes no arquivo de dados
    public static void escreveAutores() throws IOException {

        try {
            FileWriter fw = new FileWriter("dados/autores.txt");
            PrintWriter pw = new PrintWriter(fw);
    
            for (Autor a : Livraria.autoresCatalogo()) {
                pw.printf("%1$s;", a.getId());
                pw.printf("%1$s;", a.getNome());
                pw.printf("%1$s;", a.getNacionalidade());
                pw.printf("%1$s;", a.getAnoNascimento());
                pw.printf("%1$s%n", a.getAvaliacao());
                pw.flush();
            }
    
            fw.close();

        } catch (IOException e) {
            throw new IOException("Arquivo não encontrado. Por favor, tente novamente.");
        }
        
    }

    public static void leAutor(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (new FileInputStream(caminhoArquivo), "UTF-8"));
        String linha = br.readLine();

        while(linha != null){
            String[] dados = linha.split(";", 5);
            Autor autor = new Autor(
                    Integer.valueOf(dados[0]), // id
                    dados[1], // nome
                    dados[2], // nacionalidade
                    Integer.valueOf(dados[3]), // ano de nascimento 
                    Double.valueOf(dados[4])); // avaliacao
            linha = br.readLine();
            autores.add(autor);
        }

        br.close();
    }

    public static void leEditora(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (new FileInputStream(caminhoArquivo), "UTF-8"));        String linha = "";
        linha = br.readLine();

        while(linha != null){
            String[] dados = linha.split(";", 3);
            Editora editora = new Editora(
                    Integer.valueOf(dados[0]), // id
                    dados[1], // nome
                    dados[2]); // cnpj
            linha = br.readLine();
            editoras.add(editora);
        }

        br.close();
    }

}