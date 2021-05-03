import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jdk.internal.agent.resources.agent;
import jdk.jshell.resources.l10n;

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
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        String linha = "";

        while(linha != null){
            linha = br.readLine();
            String[] dados = linha.split(";", 10);
            Livro livro = new Livro(
                    Integer.valueOf(dados[0]), // id
                    dados[1], // titulo
                    Integer.valueOf(dados[5]), // idAutor
                    Integer.valueOf(dados[6]), // idEditora
                    Genero.values()[Integer.valueOf(dados[2])], // genero
                    Integer.valueOf(dados[7]), // anoPublicacao
                    Integer.valueOf(dados[8]), // edicao
                    Integer.valueOf(dados[3]), // numPaginas
                    dados[4], // sinopse
                    Double.valueOf(dados[9])); // avaliacao
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
                br.write(String.valueOf(l.getAvaliacao())); br.write(";");
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
                br.write(String.valueOf(a.getAvaliacao())); br.write(";");
            }
    
            br.close();

        } catch (IOException e) {
            throw new IOException("Arquivo não encontrado. Por favor, tente novamente.");
        }
        
    }

    public static void leAutor(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        String linha = "";

        while(linha != null){
            linha = br.readLine();
            String[] dados = linha.split(";", 5);
            Autor autor = new Autor(
                    Integer.valueOf(dados[0]), // id
                    dados[1], // nome
                    dados[2], // nacionalidade
                    Integer.valueOf(dados[3]), // ano de nascimento 
                    Double.valueOf(dados[4])); // avaliacao
            autores.add(autor);
        }

        br.close();
    }

    public static void leEditora(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        String linha = "";

        while(linha != null){
            linha = br.readLine();
            String[] dados = linha.split(";", 3);
            Editora editora = new Editora(
                    Integer.valueOf(dados[0]), // id
                    dados[1], // nome
                    dados[2]); // cnpj
            editoras.add(editora);
        }

        br.close();
    }

}