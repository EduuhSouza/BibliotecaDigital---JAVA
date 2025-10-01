import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Book> books = new ArrayList<>();
        int option;

        // Interface do terminal opções
        do {
            System.out.println("\n======== Biblioteca Digital ========");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Buscar livro");
            System.out.println("3 - Remover livro");
            System.out.println("4 - Listar todos os livros");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (option) {
                // ADICIONAR LIVRO
                case 1:
                    System.out.print("Digite o Título do livro: ");
                    String title = scanner.nextLine();

                    System.out.print("Digite o Autor: ");
                    String author = scanner.nextLine();

                    System.out.print("Digite o Ano de lançamento: ");
                    int year = scanner.nextInt();

                    books.add(new Book(title, author, year));
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                // BUSCAR LIVRO
                case 2:
                    System.out.print("Digite o título para procurar: ");
                    String search = scanner.nextLine();

                    boolean found = false;
                    for (Book book : books) {
                        if (book.getTitle().equalsIgnoreCase(search)) {
                            System.out.println("Livro encontrado: " + book);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Livro não encontrado!");
                    }
                    break;

                // REMOVER LIVRO
                case 3:
                    System.out.print("Digite o título do livro para remover: ");
                    String remove = scanner.nextLine();
                    Book bookRemove = null;

                    for (Book book : books) {
                        if (book.getTitle().equalsIgnoreCase(remove)) {
                            bookRemove = book;
                            break;
                        }
                    }
                    if (bookRemove != null) {
                        books.remove(bookRemove);
                        System.out.println("Livro removido com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    break;

                // LISTAR TODOS OS LIVROS
                case 4:
                    System.out.println("\n---- Lista de livros ----");
                    if (books.isEmpty()) {
                        System.out.println("Nenhum livro registrado.");
                    } else {
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println((i + 1) + ". " + books.get(i));
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saindo da Biblioteca digital...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
    }
}