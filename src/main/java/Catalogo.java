import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
        linha = br.readLine();
        
        while(linha != null){
            String[] dados = linha.split(";", 12);
            
            Livro livro = new Livro(
                    Integer.valueOf(dados[0]), // id
                    dados[1], // titulo
                    Integer.valueOf(dados[2]), // idAutor
                    Integer.valueOf(dados[3]), // idEditora
                    Genero.values()[Integer.valueOf(dados[4])], //genero
                    Integer.valueOf(dados[5]), // anoPublicacao
                    dados[6], // edicao
                    Integer.valueOf(dados[7]), // numPaginas
                    dados[8], // sinopse
                    Integer.valueOf(dados[9]),
                    Integer.valueOf(dados[10]),
                    Double.valueOf(dados[11])
                    
            );
            linha = br.readLine();
            livros.add(livro);
        }

        br.close();
    }

    public static void leAutor(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        String linha = br.readLine();
        
        while(linha != null){
            String[] dados = linha.split(";", 5);
            Autor autor = new Autor(
                    Integer.valueOf(dados[0]), // id
                    dados[1], // nome
                    dados[2], // nacionalidade
                    dados[3], // ano de nascimento 
                    Double.valueOf(dados[4])); // avaliacao
            autores.add(autor);
            linha = br.readLine();
        }

        br.close();
    }

    public static void leEditora(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        String linha = "";
        linha = br.readLine();
        
        while(linha != null){
            String[] dados = linha.split(";", 3);
            Editora editora = new Editora(
                    Integer.valueOf(dados[0]), // id
                    dados[1], // nome
                    dados[2]); // cnpj
            editoras.add(editora);
            linha = br.readLine();
        }

        br.close();
    }
    
    public static void incrementaqtdAlugados(Integer id){
        int pos = Livraria.buscaPosLivro(id);
        for(int i = 0; i < livros.size(); i++){
            if(pos == i){
                Integer qtdAlugadosNovo = (livros.get(i).getQtdAlugados())+1;
                livros.get(i).setQtdAlugados(qtdAlugadosNovo);
            }
        }
    
    }
    
    public static void armazenaAlteraçõesLivro() throws IOException{
        BufferedWriter br = new BufferedWriter(new FileWriter("dados/livros.txt"));
        for(int i = 0; i < livros.size(); i++){
            br.write(Integer.toString(livros.get(i).getId()));
            br.write(";");

            br.write(livros.get(i).getTitulo());
            br.write(";");

            br.write(Integer.toString(livros.get(i).getIdAutor()));
            br.write(";");
            
            br.write(Integer.toString(livros.get(i).getIdEditora()));
            br.write(";");
            
            /* Gênero */
            if(livros.get(i).getNomeGenero().equals("AUTOAJUDA")){
                br.write(0);
                br.write(";");
            }
            if(livros.get(i).getNomeGenero().equals("DRAMA")){
                br.write(1);
                br.write(";");
            }
            if(livros.get(i).getNomeGenero().equals("FICCAO")){
                br.write(2);
                br.write(";");
            }
            if(livros.get(i).getNomeGenero().equals("INFANTOJUVENIL")){
                br.write(3);
                br.write(";");
            }
            if(livros.get(i).getNomeGenero().equals("JOVEM_ADULTO")){
                br.write(4);
                br.write(";");
            }
            if(livros.get(i).getNomeGenero().equals("NAO_FICCAO")){
                br.write(5);
                br.write(";");
            }
            if(livros.get(i).getNomeGenero().equals("POLICIAL")){
                br.write(6);
                br.write(";");
            }
            if(livros.get(i).getNomeGenero().equals("QUADRINHOS")){
                br.write(7);
                br.write(";");
            }
            if(livros.get(i).getNomeGenero().equals("ROMANCE")){
                br.write(8);
                br.write(";");
            }
            if(livros.get(i).getNomeGenero().equals("SUSPENSE")){
                br.write(9);
                br.write(";");
            }
            if(livros.get(i).getNomeGenero().equals("TERROR")){
                br.write(10);
                br.write(";");
            }
             
            br.write(Integer.toString(livros.get(i).getAnoPublicacao()));
            br.write(";");
            
            br.write(livros.get(i).getEdicao());
            br.write(";");
            
            br.write(Integer.toString(livros.get(i).getNumPaginas()));
            br.write(";");
            
            br.write(livros.get(i).getSinopse());
            br.write(";");
            
            br.write(Integer.toString(livros.get(i).getQtdExemplares()));
            br.write(";");
            
            br.write(Integer.toString(livros.get(i).getQtdAlugados()));
            br.write(";");
            
            br.write(Double.toString(livros.get(i).getAvaliacao()));
            br.write(";");
            
            br.newLine();
            
        }
        br.close();
    
    }
    
}