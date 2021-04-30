import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    /* Outros métodos*/
    
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