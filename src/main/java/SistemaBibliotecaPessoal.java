import java.util.List;

    public interface SistemaBibliotecaPessoal {
        void adicionarLivro(Livro livro) throws Exception;
        void removerLivro(String isbn) throws Exception;
        Livro pesquisarLivrosPorTitulo(String titulo);
        List<Livro> pesquisarLivrosPorAutor(String autor);
        List<Livro> pesquisarLivrosPorGenero(String genero);
        List<Livro> listarTodosLivros();
    }

