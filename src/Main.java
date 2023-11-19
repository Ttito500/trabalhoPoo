import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Biblioteca biblioteca = new Biblioteca();
        int id = 0;

        while (true) {
            System.out.println(" 1- Adcionar livro\n 2- Adicionar Artigo\n 3- Atualizar um item\n 4- Excluir um item\n 5- show\n 0- sair");
            String line = input();
            String[] args = line.split(" ");
            if      (args[0].equals("0"))          { break; }
            else if (args[0].equals("1")){
                biblioteca.addItem(new Livro(Integer.parseInt(args[1]), Integer.parseInt(args[2]), getTitulo(3, args), id));
                id++;
            }
            else if (args[0].equals("2")){
                biblioteca.addItem(artigo(id));
                id++;
            }
            else if (args[0].equals("3")){
                int idUpdate;
                System.out.print("id do item a mudar: ");
                idUpdate = Integer.parseInt(input());
                if (biblioteca.getItem(idUpdate) instanceof Livro){
                    //biblioteca.addItem(new Livro(Integer.parseInt(args[1]), Integer.parseInt(args[2]), getTitulo(3, args), id));
                    biblioteca.updateItem(Integer.parseInt(args[1]), new Livro(Integer.parseInt(args[2]), Integer.parseInt(args[3]), getTitulo(4, args), Integer.parseInt(args[1])));
                } else if (biblioteca.getItem(idUpdate) instanceof Artigo){
                    biblioteca.updateItem(Integer.parseInt(input()), artigo(Integer.parseInt(input())));
                }
            }
            else if (args[0].equals("4"))       { biblioteca.deleteItem(Integer.parseInt(args[1])); }
            else if (args[0].equals("5"))         { System.out.println(biblioteca); }
            else                                     { println("fail: comando invalido"); }
        }
    }

    private static String getTitulo(int i, String[] args){ // retorna o titulo, que começa a partir de i e vai ate o final de args
        StringBuilder titulo = new StringBuilder();
        for (; i < args.length; i++){
            titulo.append(args[i]);
            if (i != args.length - 1){titulo.append(" ");}
        }
        return titulo.toString();
    }

    private static Artigo artigo(int id){
        String doi;
        int qtd;
        String titulo;
        System.out.print("*DOI: ");
        doi = input();
        System.out.print("quantidade: ");
        qtd = Integer.parseInt(input());
        System.out.print("Titulo: ");
        titulo = input();
        System.out.println("artigo adicionado.");
        return new Artigo(doi, qtd, titulo, id);
    }
    private static Scanner scanner = new Scanner(System.in);
    private static String  input()                { return scanner.nextLine();        }
    private static double  number(String value)   { return Double.parseDouble(value); }
    public  static void    println(Object value)  { System.out.println(value);        }
    public  static void    print(Object value)    { System.out.print(value);          }
}