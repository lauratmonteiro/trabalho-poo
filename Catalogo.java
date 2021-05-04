import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import java.util.Collections;

public class Catalogo {

    /* Atributos */

    private static List<Livro> livros = new ArrayList<Livro>();
    private static List<Editora> editoras = new ArrayList<Editora>();
    private static List<Autor> autores = new ArrayList<Autor>();

    /* getters */

    public static List<Livro> getLivros() {
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
                    Integer.valueOf(dados[9]),
                    Integer.valueOf(dados[10]),
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
            BufferedWriter br = new BufferedWriter(new FileWriter("dados/livros.txt", false));
            br.write("");
    
            for (Livro l : Livraria.livrosCatalogo()) {
                br.write(l.getId()); br.write(";");
                br.write(l.getTitulo()); br.write(";");
                br.write(l.getIdAutor()); br.write(";");
                br.write(l.getIdEditora()); br.write(";");
                br.write(String.valueOf(l.getGenero())); br.write(";");
                br.write(l.getAnoPublicacao()); br.write(";");
                br.write(l.getEdicao()); br.write(";");
                br.write(l.getNumPaginas()); br.write(";");
                br.write(l.getSinopse()); br.write(";");
                br.write(String.valueOf(l.getAvaliacao()));
            }
    
            br.close();

        } catch (IOException e) {
            throw new IOException("Arquivo não encontrado. Por favor, tente novamente.");
        }

    }

        // TESTAR
    // salva os clientes no arquivo de dados
    public static void escreveAutores() throws IOException {

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("dados/autores.txt", false));
            br.write("");
    
            for (Autor a : Livraria.autoresCatalogo()) {
                br.write(a.getId()); br.write(";");
                br.write(a.getNome()); br.write(";");
                br.write(a.getNacionalidade()); br.write(";");
                br.write(a.getAnoNascimento()); br.write(";");
                br.write(String.valueOf(a.getAvaliacao()));
            }
    
            br.close();

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