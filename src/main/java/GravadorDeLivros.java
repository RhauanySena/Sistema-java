
import java.io.*;
import java.util.ArrayList;
import java.util.List;

    public class GravadorDeLivros {

        private static final String NOME_ARQUIVO = "biblioteca.txt";

        public static void salvar(List<Livro> livros) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
                for (Livro livro : livros) {
                    writer.write(livro.toCsvString());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Erro ao salvar os livros: " + e.getMessage());
            }
        }

        public static List<Livro> carregar() {
            List<Livro> livros = new ArrayList<>();
            File arquivo = new File(NOME_ARQUIVO);
            if (arquivo.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
                    String linha;
                    while ((linha = reader.readLine()) != null) {
                        Livro livro = Livro.fromCsvString(linha);
                        if (livro != null) {
                            livros.add(livro);
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Erro ao carregar os livros: " + e.getMessage());
                }
            }
            return livros;
        }
    }

