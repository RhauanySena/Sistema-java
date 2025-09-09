package app;
import model.cadastros;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class BibliotecaPessoal {
   private static List<cadastros> livros = new ArrayList<>();

   public static void main(String [] args) {
      while (true) {
         String opcao = JOptionPane.showInputDialog("BIBLIOTECA PESSOAL \n"
                 + "Escolha uma opção: \n" +
                 "1 - Adicionar Livro \n" +
                 "2 - Ver todos os livros \n" +
                 "3 - Pesquisar Livro \n" +
                 "4 - Remover Livros \n " +
                 "5 - Sair \n" +
                 "Digite o numero da opção:");

         if (opcao == null) break;
         switch (opcao){
            case "1":
               adicionarlivros();
               break;
            case "2":
              listarLivros();
               break;
            case "3":
               pesquisarlivros();
               break;
            case "4":
               removerlivros();
               break;
            case "5":
               sair();
               break;
         }

      }

   }
   static void adicionarlivros(){
      String livro = JOptionPane.showInputDialog("digite o nome do livro:");
      String Autor = JOptionPane.showInputDialog("Digite o nome do Autor");
      String Genero = JOptionPane.showInputDialog("Digite o Genero do livro");
      boolean lido = JOptionPane.showConfirmDialog(null "Voce já leu esse livro?");
      livros.add(livro);

   }
   static void listarLivros(){
      if (livros.isEmpty()) {
         JOptionPane.showMessageDialog(null, "Nenhum livro na biblioteca!");
         return;
      }

      String lista = " SEUS LIVROS:\n";
      for (int i = 0; i < livros.size(); i++) {
         lista += (i+1) + "." + livros.get(i) + "\n";
      }
      JOptionPane.showMessageDialog(null, lista);

   }

   static void pesquisarlivros(){
      String pesquisa = JOptionPane.showInputDialog("qual livro voce está buscando?");
      for (cadastros i : livros ) {
         if(i.getTitulo().equalsIgnoreCase(pesquisa)){
                  System.out.println("Livro encontrado:" + i );
         }
      }
   }

   static void removerlivros(){
      if (livros.isEmpty()) {
         JOptionPane.showMessageDialog(null, "Não há livros para remover!");
         return;
      }

      String livroRemover = JOptionPane.showInputDialog("Digite o nome EXATO do livro que quer remover:");

      if (livroRemover == null || livroRemover.trim().isEmpty()) {
         return;
      }

      livroRemover = livroRemover.trim();

      boolean encontrou = false;
      for (int i = 0; i < livros.size(); i++) {
         if (livros.get(i).equalsIgnoreCase(livroRemover)) {
            livros.remove(i);
            JOptionPane.showMessageDialog(null, "Livro removido: " + livroRemover);
            encontrou = true;
            break;
         }
      }

      if (!encontrou) {JOptionPane.showMessageDialog(null, "Livro não encontrado!\n" + "Digite o nome exato do livro.");
 }


}


}