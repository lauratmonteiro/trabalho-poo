import java.util.Comparator;

public class LivroComparator implements Comparator<Livro> {

    @Override
    public int compare(Livro livro, Livro outroLivro) {
        return livro.getAvaliacao().compareTo(outroLivro.getAvaliacao());
    }
    
}