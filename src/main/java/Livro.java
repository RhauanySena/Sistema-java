import java.io.Serializable;
import java.util.Objects;


    public class Livro implements Serializable {
        private String titulo;
        private String autor;
        private String genero;

        public Livro(String titulo, String autor, String genero) {
            this.titulo = titulo;
            this.autor = autor;
            this.genero = genero;
        }

        public String toCsvString() {
            return titulo + ";" + autor + ";" + genero;
        }

        public static Livro fromCsvString(String c) {
            String[] partes = c.split(";");
            if (partes.length == 3) {
                return new Livro(partes[0], partes[1], partes[2]);
            }
            return null;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public String getGenero() {
            return genero;
        }

        public String toString() {
            return "Livro{" + ", titulo='" + titulo + '\'' +
                    ", autor='" + autor + '\'' +
                    ", genero='" + genero + '\'' + '}';
        }

        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Livro livro = (Livro) o;
            return Objects.equals(titulo, livro.titulo) && Objects.equals(autor, livro.autor) && Objects.equals(genero, livro.genero);
        }

        public int hashCode() {
            return Objects.hash(titulo, autor, genero);
        }
    }

