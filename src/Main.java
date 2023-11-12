import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            String line = input();
            println("$" + line);
            String[] args = line.split(" ");
            if      (args[0].equals("end"))          { break; }
            else if (args[0].equals("addLivro"))      {
                StringBuilder titulo = new StringBuilder();
                for (int i = 3; i < args.length; i++){
                    titulo.append(args[i]);
                    if (i != args.length - 1){titulo.append(" ");}

                }
                biblioteca.addItem(new Livro(Integer.parseInt(args[1]), Integer.parseInt(args[2]), titulo.toString()));
            }
            else if (args[0].equals("show"))         { System.out.println(biblioteca); }
            else                                     { println("fail: comando invalido"); }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()                { return scanner.nextLine();        }
    private static double  number(String value)   { return Double.parseDouble(value); }
    public  static void    println(Object value)  { System.out.println(value);        }
    public  static void    print(Object value)    { System.out.print(value);          }
}