import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

    public class MinhaBiblioteca implements SistemaBibliotecaPessoal {
        private List<Livro> livros;

        public MinhaBiblioteca() {
            this.livros = GravadorDeLivros.carregar();
        }

        public void adicionarLivro(Livro livro) throws Exception{
            for (Livro l : livros) {
                if (l.getTitulo().equals(livro.getTitulo())) {
                    throw new Exception("Este livro já existe na sua biblioteca!");
                }
            }
            livros.add(livro);
            GravadorDeLivros.salvar(livros);
        }

        public void removerLivro(String titulo) throws Exception {
            Livro livroParaRemover = null;
            for (Livro k : livros) {
                if (k.getTitulo().equals(titulo)) {
                    livroParaRemover = k;
                    break;
                }
            }

            if (livroParaRemover != null) {
                livros.remove(livroParaRemover);
                GravadorDeLivros.salvar(livros);
                JOptionPane.showMessageDialog(null, "Livro removido com sucesso!");
            } else {
                throw new Exception("Livro não encontrado");
            }
        }

        public Livro pesquisarLivrosPorTitulo(String titulo) {
            for (Livro livro : livros) {
                if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                    return livro;
                }
            }
            return null;
        }

        public List<Livro> pesquisarLivrosPorAutor(String autor) {
            List<Livro> resultado = new ArrayList<>();
            for (Livro livro : livros) {
                if (livro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                    resultado.add(livro);
                }
            }
            return resultado;
        }

        public List<Livro> pesquisarLivrosPorGenero(String genero) {
            List<Livro> resultado = new ArrayList<>();
            for (Livro livro : livros) {
                if (livro.getGenero().toLowerCase().contains(genero.toLowerCase())) {
                    resultado.add(livro);
                }
            }
            return resultado;
        }

        public List<Livro> listarTodosLivros() {
            return new ArrayList<>(livros);
        }
    }

