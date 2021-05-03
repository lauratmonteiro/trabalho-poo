import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

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
    
    /*métodos*/
    
    /* Métodos para ler os dados de livros, autores e editoras disponíveis */
    public static void leLivro(String caminhoArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (new FileInputStream(caminhoArquivo), "UTF-8"));
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
       BufferedReader br = new BufferedReader(new InputStreamReader (new FileInputStream(caminhoArquivo), "UTF-8"));
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
        BufferedReader br = new BufferedReader(new InputStreamReader (new FileInputStream(caminhoArquivo), "UTF-8"));
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
    
   
    
    /* incrementa o valor da quantidade de livros alugados de determinado livro */
    public static void incrementaqtdAlugados(Integer id){
        int pos = Livraria.buscaPosLivro(id);
        for(int i = 0; i < livros.size(); i++){
            if(pos == i){
                Integer qtdAlugadosNovo = (livros.get(i).getQtdAlugados())+1;
                livros.get(i).setQtdAlugados(qtdAlugadosNovo);
            }
        }
    
    }
    
    
    /* decrementa o valor da quantidade de livros alugados de determinado livro */
    public static void decrementaqtdAlugados(Integer id){
        int pos = Livraria.buscaPosLivro(id);
        for(int i = 0; i < livros.size(); i++){
            if(pos == i){
                Integer qtdAlugadosNovo = (livros.get(i).getQtdAlugados())-1;
                livros.get(i).setQtdAlugados(qtdAlugadosNovo);
            }
        }
    
    }
    /*adiciona novo livro ao catálogo*/
    public static void adicionaNovoLivro() throws IOException{
        Scanner teclado = new Scanner(System.in);
        BufferedWriter br = new BufferedWriter(new FileWriter("dados/livros.txt",  true));
        System.out.println("Digite o ID do novo livro: ");
        br.write(Integer.toString(teclado.nextInt()));
        br.write(";");
        teclado.nextLine();
        
        System.out.println("Digite o título do novo livro: ");
        br.write(teclado.nextLine());
        br.write(";");
        
        System.out.println("Digite o ID do autor do novo livro: ");
        br.write(Integer.toString(teclado.nextInt()));
        br.write(";");
        
        System.out.println("Digite o ID da editora do novo livro: ");
        br.write(Integer.toString(teclado.nextInt()));
        br.write(";");
            
        System.out.println("Digite o gênero do novo livro: ");
        System.out.println( "0 - Autoajuda\n" + 
                            "1 - Drama\n" +
                            "2 - Ficção\n" +
                            "3 - Infantojuvenil\n" +
                            "4 - Jovem adulto\n" + 
                            "5 - Não ficção\n" + 
                            "6 - Policial\n" + 
                            "7 - Quadrinhos\n" +
                            "8 - Romance\n" +
                            "9 - Suspense\n" + 
                            "10 - Terror" );
        br.write(teclado.next());
        br.write(";");
        
        System.out.println("Digite o ano de publicação do novo livro: ");
        br.write(teclado.next());
        br.write(";");
        
        System.out.println("Digite a edição do novo livro: ");
        br.write(teclado.next());
        br.write(";");
        
        System.out.println("Digite o número de páginas do novo livro: ");
        br.write(Integer.toString(teclado.nextInt()));
        teclado.nextLine();
        br.write(";");
        
        System.out.println("Digite a sinopse do novo livro: ");
        br.write(teclado.nextLine());
        br.write(";");
        
        System.out.println("Digite a quantidade de exemplares do novo livro: ");
        br.write(Integer.toString(teclado.nextInt()));
        br.write(";");
           
        br.write('0'); //seta 0 na qtd de livros alugados
        br.write(";");
            
        br.write('0'); //seta 0 na avaliação do livro novo
            
        br.newLine();
        br.close();
            
    }
    
    /*adiciona nova editora ao catálogo*/
    public static void adicionaNovaEditora() throws IOException{
        Scanner teclado = new Scanner(System.in);
        BufferedWriter br = new BufferedWriter(new FileWriter("dados/editoras.txt",  true));
        System.out.println("Digite o ID da nova editora: ");
        br.write(Integer.toString(teclado.nextInt()));
        br.write(";");
        teclado.nextLine();
        
        System.out.println("Digite o nome da nova editora: ");
        br.write(teclado.nextLine());
        br.write(";");
        
        System.out.println("Digite o CNPJ da nova editora: ");
        br.write(teclado.next());
        br.write(";");
            
        br.newLine();
        br.close();
    }  
    
    /*adiciona novo autor ao catálogo*/
    public static void adicionaNovoAutor() throws IOException{
        Scanner teclado = new Scanner(System.in);
        BufferedWriter br = new BufferedWriter(new FileWriter("dados/autores.txt",  true));
        System.out.println("Digite o ID do novo autor: ");
        br.write(Integer.toString(teclado.nextInt()));
        br.write(";");
        teclado.nextLine();
        
        System.out.println("Digite o nome do novo autor: ");
        br.write(teclado.nextLine());
        br.write(";");
        
        System.out.println("Digite a nacionalidade do novo autor: ");
        br.write(teclado.next());
        br.write(";");
        
        System.out.println("Digite o ano de nascimento do novo autor: ");
        br.write(teclado.next());
        br.write(";");
        
        br.write('0'); //seta 0 avaliação do novo autor 
   
            
        br.newLine();
        br.close();
    }  
    
    /* faz alterações no array de livros e depois armazena essas alterações no arquivo de livros */
    public static void armazenaAlteraçõesLivro() throws IOException{
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dados/livros.txt"),"UTF8"));
        for(int i = 0; i < livros.size(); i++){
            br.write(Integer.toString(livros.get(i).getId()));
            br.write(";");

            br.write(livros.get(i).getTitulo());
            br.write(";");

            br.write(Integer.toString(livros.get(i).getIdAutor()));
            br.write(";");
            
            br.write(Integer.toString(livros.get(i).getIdEditora()));
            br.write(";");
            
      
            if(livros.get(i).getGenero().equals(Genero.AUTOAJUDA)){
                br.write("0");
                br.write(";");
            }
            if(livros.get(i).getGenero().equals(Genero.DRAMA)){
                br.write("1");
                br.write(";");
            }
            if(livros.get(i).getGenero().equals(Genero.FICCAO)){
                br.write("2");
                br.write(";");
            }
            if(livros.get(i).getGenero().equals(Genero.INFANTOJUVENIL)){
                br.write("3");
                br.write(";");
            }
            if(livros.get(i).getGenero().equals(Genero.JOVEM_ADULTO)){
                br.write("4");
                br.write(";");
            }
            if(livros.get(i).getGenero().equals(Genero.NAO_FICCAO)){
                br.write("5");
                br.write(";");
            }
            if(livros.get(i).getGenero().equals(Genero.POLICIAL)){
                br.write("6");
                br.write(";");
            }
            if(livros.get(i).getGenero().equals(Genero.QUADRINHOS)){
                br.write("7");
                br.write(";");
            }
            if(livros.get(i).getGenero().equals(Genero.ROMANCE)){
                br.write("8");
                br.write(";");
            }
            if(livros.get(i).getGenero().equals(Genero.SUSPENSE)){
                br.write("9");
                br.write(";");
            }
            if(livros.get(i).getGenero().equals(Genero.TERROR)){
                br.write("10");
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
            
            
            br.newLine();
            
        }
        br.close();
    
    }
    
     /* faz alterações no array de autores e depois armazena essas alterações no arquivo de autores */
    static void armazenaAlteraçõesAutor() throws IOException {
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dados/autores.txt"),"UTF8"));
        for(int i = 0; i < autores.size(); i++){
            br.write(Integer.toString(autores.get(i).getId()));
            br.write(";");

            br.write(autores.get(i).getNome());
            br.write(";");

            br.write(autores.get(i).getNacionalidade());
            br.write(";");
            
            br.write(autores.get(i).getAnoNascimento());
            br.write(";");
            
            br.write(Double.toString(autores.get(i).getAvaliacao()));
            
            br.newLine();
            
        }
        br.close();
  
    }
    
}