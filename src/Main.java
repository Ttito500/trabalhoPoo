import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Biblioteca biblioteca = new Biblioteca();
        int id = 0;

        while (true) {
            String line = input();
            println("$" + line);
            String[] args = line.split(" ");
            if      (args[0].equals("end"))          { break; }
            else if (args[0].equals("addLivro")){
                biblioteca.addItem(new Livro(Integer.parseInt(args[1]), Integer.parseInt(args[2]), getTitulo(3, args), id));
                id++;
            }
            else if (args[0].equals("addArtigo")){
                biblioteca.addItem(new Artigo(args[1], Integer.parseInt(args[2]), getTitulo(3, args), id));
                id++;
            }
            else if (args[0].equals("update")){
                if (biblioteca.getItem(Integer.parseInt(args[1])) instanceof Livro){
                    //biblioteca.addItem(new Livro(Integer.parseInt(args[1]), Integer.parseInt(args[2]), getTitulo(3, args), id));
                    biblioteca.update(Integer.parseInt(args[1]), new Livro(Integer.parseInt(args[2]), Integer.parseInt(args[3]), getTitulo(4, args), Integer.parseInt(args[1])));
                } else if (biblioteca.getItem(Integer.parseInt(args[1])) instanceof Artigo){
                    //biblioteca.addItem(new Artigo(args[1], Integer.parseInt(args[2]), getTitulo(3, args), id));
                    biblioteca.update(Integer.parseInt(args[1]), new Artigo(args[2], Integer.parseInt(args[3]), getTitulo(4, args), Integer.parseInt(args[1])));
                }
            }
            else if (args[0].equals("delete"))       { biblioteca.deleteItem(Integer.parseInt(args[1])); }
            else if (args[0].equals("show"))         { System.out.println(biblioteca); }
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
    private static Scanner scanner = new Scanner(System.in);
    private static String  input()                { return scanner.nextLine();        }
    private static double  number(String value)   { return Double.parseDouble(value); }
    public  static void    println(Object value)  { System.out.println(value);        }
    public  static void    print(Object value)    { System.out.print(value);          }
}