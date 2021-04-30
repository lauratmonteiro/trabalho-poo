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

    public static void addLivro(Livro livro){
        for (Livro l : livros){
            if(livro.getTitulo() == l.getTitulo()){
                if (livro.getIdAutor() == l.getIdAutor()) {
                    return;
                }
            }
        }
        livros.add(livro);
    } // TODO: metodo pra ler o livro do arquivo

    public void leLivro(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        String linha = "";

        while(linha != null){
            linha = br.readLine();
            String[] dados = linha.split(";", 10);
            Livro livro = new Livro(
                    dados[0],
                    Integer.valueOf(dados[1]),
                    Genero.values()[Integer.valueOf(dados[2])],
                    Integer.valueOf(dados[3]),
                    dados[4],
                    Integer.valueOf(dados[5]),
                    Integer.valueOf(dados[6]),
                    Integer.valueOf(dados[7]),
                    dados[8],
                    Double.valueOf(dados[9]));
            livros.add(livro);
        }

        br.close();
    }

    public static void addAutor(Autor autor){
        for(Autor a : autores){
            if(autor.getNome() == a.getNome()){
                return;
            }
        }
        autores.add(autor);
    }

    public void leAutor(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        String linha = "";

        while(linha != null){
            linha = br.readLine();
            String[] dados = linha.split(";", 5);
            Autor autor = new Autor(
                    Integer.valueOf(dados[0]),
                    dados[1],
                    dados[2],
                    Integer.valueOf(dados[3]),
                    Double.valueOf(dados[4]));
            autores.add(autor);
        }

        br.close();
    }

    public static void addEditora(Editora editora){
        for(Editora e : editoras){
            if(editora.getNome() == e.getNome()){
                return;
            }
        }
        editoras.add(editora);
    }

    public void leEditora(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        String linha = "";

        while(linha != null){
            linha = br.readLine();
            String[] dados = linha.split(";", 3);
            Editora editora = new Editora(
                    Integer.valueOf(dados[0]),
                    dados[1],
                    dados[2]);
            editoras.add(editora);
        }

        br.close();
    }

}