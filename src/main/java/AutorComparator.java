
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
public class AutorComparator implements Comparator<Autor> {
    @Override
    public int compare(Autor autor, Autor outroAutor) {
        if(autor.getAvaliacao() > outroAutor.getAvaliacao()){
            return -1;
        }
        if(outroAutor.getAvaliacao() < outroAutor.getAvaliacao()){
            return 1;
        }
        return 0;
        
    }
}
