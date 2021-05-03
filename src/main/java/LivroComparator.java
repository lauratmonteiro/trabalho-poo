
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */

/*Ordena os livros em ordem decrescente de avaliação */
public class LivroComparator implements Comparator<Livro>{
    @Override
    public int compare(Livro livro, Livro outroLivro) {
        if(livro.getAvaliacao() > outroLivro.getAvaliacao()){
            return -1;
        }
        if(livro.getAvaliacao() < outroLivro.getAvaliacao()){
            return 1;
        }
        return 0;
        
    }

}
