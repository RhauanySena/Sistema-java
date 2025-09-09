package model;
public class cadastros {
    private String Titulo;
    private String Autor;
    private String Genero;
    private boolean lido;

    public cadastros(String titulo, String autor, String genero, boolean lido) {
        this.Titulo = titulo;
        this.Autor = autor;
        this.Genero = genero;
        this.lido = lido;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }

    @Override
    public String toString() {
        return "cadastros{" +
                "Titulo='" + Titulo + '\'' +
                ", Autor='" + Autor + '\'' +
                ", Genero='" + Genero + '\'' +
                ", lido=" + lido +
                '}';
    }
}


