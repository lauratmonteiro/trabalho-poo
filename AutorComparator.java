import java.util.Comparator;

public class AutorComparator implements Comparator<Autor> {

    @Override
    public int compare(Autor autor, Autor outroAutor) {
        return autor.getAvaliacao().compareTo(outroAutor.getAvaliacao());
    }
    
}
