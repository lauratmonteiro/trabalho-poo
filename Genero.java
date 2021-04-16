public class Genero implements Comparable<Genero> {
    
    private String nomeGenero;

    /* Construtor */

    public Genero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    /* Setters e getters */

    public String getNomeGenero() {
        return nomeGenero;
    }

    /* Outros métodos */

    @Override
    public String toString() {
        return "Gênero do livro: " + this.nomeGenero + ".\n";
    }

    @Override
    public int compareTo(Genero outroGenero) {
        return this.nomeGenero.compareTo(outroGenero.nomeGenero);
    } // função pra ordenar os generos alfabeticamente

}
