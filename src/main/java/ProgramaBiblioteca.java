import javax.swing.JOptionPane;
import java.util.List;

public class ProgramaBiblioteca {
    static MinhaBiblioteca biblioteca = new MinhaBiblioteca();

    public static void main(String[] args) throws Exception {
        while (true) {
            String opcao = JOptionPane.showInputDialog("=== BIBLIOTECA PESSOAL === \n"
                    + "Escolha uma opção: \n" +
                    "1 - Adicionar livro\n"+
                    "2 - Remover livro\n"+
                    "3 - Pesquisar livro por titulo\n"+
                    "4 - Pesquisar livro por Autor\n"+
                    "5 - Pesquisar livro por Genero\n"+
                    "6 - Listar todos livros na biblioteca\n"+
                    "7 - sair\n"+
                    "Digite o numero da opção que deseja:");

            if (opcao == null || opcao.equals("7")) {
                break;
            }

            switch (opcao) {
                case "1":
                    String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                    String autor = JOptionPane.showInputDialog("Digite o nome do autor:");
                    String genero = JOptionPane.showInputDialog("Digite o gênero:");
                    if (titulo != null && !titulo.isEmpty() && autor != null && !autor.isEmpty() && genero != null && !genero.isEmpty()) {
                        try {
                            Livro livro = new Livro(titulo, autor, genero);
                            biblioteca.adicionarLivro(livro);
                            JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso!");
                        } catch (LivroJaExisteException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case "2":
                    String tituloRemover = JOptionPane.showInputDialog("Digite o título do livro a ser removido:");
                    if (tituloRemover != null && !tituloRemover.isEmpty()) {
                        try {
                            biblioteca.removerLivro(tituloRemover);
                        } catch (LivroNaoEncontradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Título não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case "3":
                    String tituloPesquisa = JOptionPane.showInputDialog("Digite o título do livro para pesquisa: ");
                    if (tituloPesquisa != null && !tituloPesquisa.isEmpty()) {
                        Livro resultado = biblioteca.pesquisarLivrosPorTitulo(tituloPesquisa);
                        if(resultado!=null){
                            String descricao = "Livro encontrado:\n" + "Titulo: "+resultado.getTitulo() + "\n" + "Autor: " +resultado.getAutor() + "\n" + "Genero: " +resultado.getGenero() + "\n";
                            JOptionPane.showMessageDialog(null, descricao);
                        } else {
                            JOptionPane.showMessageDialog(null, "Livro não encontrado em sua biblioteca");
                        }
                    }
                    break;

                case "4":
                    String autorPesquisa = JOptionPane.showInputDialog("Digite o nome do Autor para pesquisa: ");
                    if (autorPesquisa != null && !autorPesquisa.isEmpty()) {
                        List<Livro> resultados = biblioteca.pesquisarLivrosPorAutor(autorPesquisa);
                        if(resultados.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Não há livros deste Autor!");
                        } else {
                            StringBuilder livros= new StringBuilder();
                            for(Livro livroAutor:resultados){
                                livros.append("Titulo: ").append(livroAutor.getTitulo())
                                        .append("; Autor: ").append(livroAutor.getAutor())
                                        .append("; Genero: ").append(livroAutor.getGenero())
                                        .append("\n");
                            }
                            String mensagem = "Livros deste Autor:  \n" + livros;
                            JOptionPane.showMessageDialog(null, mensagem);
                        }
                    }
                    break;

                case "5":
                    String generoPesquisa = JOptionPane.showInputDialog("Digite um gênero para pesquisa: ");
                    if (generoPesquisa != null && !generoPesquisa.isEmpty()) {
                        List<Livro> resultados = biblioteca.pesquisarLivrosPorGenero(generoPesquisa);
                        if(resultados.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Não há livros deste gênero!");
                        } else {
                            StringBuilder livros = new StringBuilder();
                            for(Livro livroGenero:resultados){
                                livros.append("Titulo: ").append(livroGenero.getTitulo())
                                        .append("; Autor: ").append(livroGenero.getAutor())
                                        .append("\n");
                            }
                            String mensagem = "Livros com esse Genero: "+ generoPesquisa + "\n" + livros;
                            JOptionPane.showMessageDialog(null, mensagem);
                        }
                    }
                    break;

                case "6":
                    List<Livro> todosLivros = biblioteca.listarTodosLivros();
                    if(todosLivros.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Não há livros na biblioteca!");
                    } else {
                        StringBuilder livros= new StringBuilder();
                        for(Livro livrotodos:todosLivros){
                            livros.append("Titulo: ").append(livrotodos.getTitulo()).append(";  Autor: ").append(livrotodos.getAutor()).append(";  Genero: ").append(livrotodos.getGenero()).append("\n");
                        }
                        String mensagem = "Todos os livros da biblioteca:  \n " + livros;
                        JOptionPane.showMessageDialog(null, mensagem);
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        }
    }
}