import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Biblioteca biblioteca = new Biblioteca();
        int id = 0;

        while (true) {
            try {
                System.out.println(" 1- Adcionar livro\n 2- Adicionar Artigo\n 3- Atualizar um item\n 4- Excluir um item\n 5- show\n 0- sair");
                String line = input();
                String[] args = line.split(" ");
                if (args[0].equals("0")) {
                    break;
                } else if (args[0].equals("1")) {
                    biblioteca.addItem(livro(id));
                    id++;
                } else if (args[0].equals("2")) {
                    biblioteca.addItem(artigo(id));
                    id++;
                } else if (args[0].equals("3")) {
                    int idUpdate;
                    System.out.print("id do item a mudar: ");
                    idUpdate = number(input());
                    if (biblioteca.getItem(idUpdate) instanceof Artigo) {
                        biblioteca.updateItem(artigo(idUpdate));
                    } else if (biblioteca.getItem(idUpdate) instanceof Livro) {
                        biblioteca.updateItem(livro(idUpdate));
                    }
                } else if (args[0].equals("4")) {
                    System.out.print("id do item a mudar: ");
                    biblioteca.deleteItem(number(input()));
                } else if (args[0].equals("5")) {
                    System.out.println(biblioteca);
                } else {
                    println("fail: comando invalido");
                }
            } catch (MsgException m){
                System.out.println(m.getMessage());
            }
        }
    }

    private static Artigo artigo(int id){
        String doi;
        int qtd;
        String titulo;
        System.out.print("*DOI: ");
        doi = input();
        System.out.print("quantidade: ");
        qtd = number(input());
        System.out.print("Titulo: ");
        titulo = input();
        return new Artigo(doi, qtd, titulo, id);
    }
    private static Livro livro(int id){
        int isbn;
        int qtd;
        String titulo;
        System.out.print("*isbn: ");
        isbn = number(input());
        System.out.print("quantidade: ");
        qtd = number(input());
        System.out.print("Titulo: ");
        titulo = input();
        return new Livro(isbn, qtd, titulo, id);
    }
    private static Scanner scanner = new Scanner(System.in);
    private static String  input()                { return scanner.nextLine();        }
    private static int  number(String value)   { return Integer.parseInt(value); }
    public  static void    println(Object value)  { System.out.println(value);        }
    public  static void    print(Object value)    { System.out.print(value);          }
}