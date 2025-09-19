import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MinhaBiblioteca implements SistemaBibliotecaPessoal {
    private List<Livro> livros;

    public MinhaBiblioteca() {
        this.livros = GravadorDeLivros.carregar();
    }

    @Override
    public void adicionarLivro(Livro livro) throws LivroJaExisteException {
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(livro.getTitulo())) {
                throw new LivroJaExisteException("Este livro já existe na sua biblioteca!");
            }
        }
        livros.add(livro);
        GravadorDeLivros.salvar(livros);
    }

    @Override
    public void removerLivro(String titulo) throws LivroNaoEncontradoException {
        Livro livroParaRemover = null;
        for (Livro k : livros) {
            if (k.getTitulo().equalsIgnoreCase(titulo)) {
                livroParaRemover = k;
                break;
            }
        }

        if (livroParaRemover != null) {
            livros.remove(livroParaRemover);
            GravadorDeLivros.salvar(livros);
            JOptionPane.showMessageDialog(null, "Livro removido com sucesso!");
        } else {
            throw new LivroNaoEncontradoException("Livro não encontrado.");
        }
    }

    @Override
    public Livro pesquisarLivrosPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                return livro;
            }
        }
        return null;
    }

    @Override
    public List<Livro> pesquisarLivrosPorAutor(String autor) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    @Override
    public List<Livro> pesquisarLivrosPorGenero(String genero) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getGenero().toLowerCase().contains(genero.toLowerCase())) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    @Override
    public List<Livro> listarTodosLivros() {
        return new ArrayList<>(livros);
    }
}
