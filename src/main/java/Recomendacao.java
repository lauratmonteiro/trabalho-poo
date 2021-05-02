
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Recomendacao {
    
    // método para recomendar livros 
    public static void recomendaLivros() {
        LivroComparator  comparator = new LivroComparator() ;
        List<Livro> livrosRecomendados = new ArrayList<Livro>();
        livrosRecomendados  = Catalogo.getLivros();
        Collections.sort(livrosRecomendados, comparator);
        System.out.println("--------- TOP 10 livros recomendados ---------- ");
        for(int i = 0; i < 10; i++) 
            System.out.println(livrosRecomendados.get(i).getTitulo());
     
    }
    
    //método para recomendar autores
    public static void recomendaAutores() {
        AutorComparator  comparator = new AutorComparator() ;
        List<Autor> autoresRecomendados = new ArrayList<Autor>();
        autoresRecomendados = Catalogo.getAutores();
        Collections.sort(autoresRecomendados, comparator);
        System.out.println("--------- TOP 10 autores recomendados ---------- ");
        for(int i = 0; i < 10; i++) 
            System.out.println(autoresRecomendados.get(i).getNome());
     
    }

}
