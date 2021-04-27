/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Categoria {
    //Atributo
    public String genero;

    //Construtor
    public Categoria(String generoLivro){
        this.genero = generoLivro;

    }

    //getter e setter
    //fazer validação do setter depois
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    //método
    @Override
    public String toString() {
        return "Gênero do livro: " + this.genero + '\n';
                         
    }
    
}
