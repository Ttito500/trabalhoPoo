import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Biblioteca biblioteca = loadData(); // carrega os dados se existirem
        int keyItem = 0;
        int keyUsuario = 0;
        if (biblioteca == null) {
            biblioteca = new Biblioteca();
        } else {
            keyItem = biblioteca.ultimoIdItens();
            keyUsuario = biblioteca.ultimoIdUsuarios();
        }
        int menu = 0;
        boolean loop = true;
        while (loop) {
            while (menu == 0 && loop) {
                System.out.println("MENU ITENS\n\n 1- Adcionar livro\n 2- Adicionar Artigo\n 3- Atualizar um item\n 4- Excluir um item\n 5- show\n 6- Menu usuários\n 0- sair");
                String line = input();
                String[] args = line.split(" ");
                if (args[0].equals("0")) {
                    saveData(biblioteca);
                    loop = false;
                } else if (args[0].equals("1")) {
                    biblioteca.addItem(livro(keyItem));
                    keyItem++;
                } else if (args[0].equals("2")) {
                    biblioteca.addItem(artigo(keyItem));
                    keyItem++;
                } else if (args[0].equals("3")) {
                    int idUpdate;
                    System.out.print("id do item a mudar: ");
                    idUpdate = number(input());
                    if (biblioteca.getItem(idUpdate) instanceof Artigo) {
                        try {
                            biblioteca.updateItem(artigo(idUpdate));
                        } catch (Exception e) {
                            System.out.println(e.toString());;
                        }
                    } else if (biblioteca.getItem(idUpdate) instanceof Livro) {
                        try {
                            biblioteca.updateItem(livro(idUpdate));
                        } catch (Exception e) {
                            System.out.println(e.toString());;
                        }
                    }
                } else if (args[0].equals("4")) {
                    System.out.print("id do item para remover: ");
                    try {
                        biblioteca.deleteItem(number(input()));
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                } else if (args[0].equals("5")) {
                    System.out.println(biblioteca.showItens());
                } else if (args[0].equals("6")) {
                    menu++;
                } else {
                    println("fail: comando invalido");
                }
            }
            while (menu == 1 && loop) {
                System.out.println("MENU USUÁRIOS\n\n 1- Adcionar usuario\n 2- Emprestar item\n 3- Devolver item\n 4- pagar divida\n 5- show\n 6- Menu itens\n 7- Adiar devolução\n 0- sair");
                String line = input();
                String[] args = line.split(" ");
                if (args[0].equals("0")) {
                    saveData(biblioteca);
                    loop = false;
                }else if (args[0].equals("1")) {
                    biblioteca.addUsuario(usuario(keyUsuario));
                    keyUsuario++;
                } else if (args[0].equals("2")) {
                    System.out.print("id do usuário: ");
                    int idUsuario = number(input());
                    System.out.print("id do item: ");
                    int idItem = number(input());
                    try {
                        biblioteca.emprestar(idUsuario, idItem);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                } else if (args[0].equals("3")) {
                    System.out.print("id do usuário: ");
                    int idUsuario = number(input());
                    System.out.print("id do item: ");
                    int idItem = number(input());
                    try {
                        biblioteca.devolver(idUsuario, idItem);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                } else if (args[0].equals("4")) {
                    System.out.print("id do usuário: ");
                    int idUsuario = number(input());
                    try {
                        System.out.println(biblioteca.pagarDivida(idUsuario));
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }else if (args[0].equals("5")) {
                    System.out.println(biblioteca.showUsuarios());
                } else if (args[0].equals("6")) {
                    menu--;
                }else if (args[0].equals("7")) {
                    System.out.print("id do usuário: ");
                    int idUsuario = number(input());
                    System.out.print("id do item: ");
                    int idItem = number(input());
                    biblioteca.adiarEmprestimo(idUsuario, idItem);
                }else if (args[0].equals("9")) {
                    System.out.print("id do usuário: ");
                    int idUsuario = number(input());
                    System.out.print("id do item: ");
                    int idItem = number(input());
                    biblioteca.testDebito(idUsuario, idItem);
                } else {
                    println("fail: comando invalido");
                }
            }
        }
    }

    private static Artigo artigo(int id){
        String doi;
        int qtd;
        String titulo;
        System.out.print("DOI: ");
        doi = input();
        System.out.print("quantidade: ");
        qtd = number(input());
        System.out.print("titulo: ");
        titulo = input();
        return new Artigo(doi, qtd, titulo, id);
    }
    private static Livro livro(int id){
        int isbn;
        int qtd;
        String titulo;
        System.out.print("isbn: ");
        isbn = number(input());
        System.out.print("quantidade: ");
        qtd = number(input());
        System.out.print("titulo: ");
        titulo = input();
        return new Livro(isbn, qtd, titulo, id);
    }

    public static UsuarioBiblioteca usuario(int id){
        String nome;
        System.out.print("nome: ");
        nome = input();
        return new UsuarioBiblioteca(nome, id);
    }
    private static Scanner scanner = new Scanner(System.in);
    private static String  input()                { return scanner.nextLine();        }
    private static int  number(String value)   { return Integer.parseInt(value); }
    public  static void    println(Object value)  { System.out.println(value);        }
    public  static void    print(Object value)    { System.out.print(value);          }

    private static void saveData(Biblioteca biblioteca) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("DadosBiblioteca.txt"))) {
            outputStream.writeObject(biblioteca);
            System.out.println("dados salvos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Biblioteca loadData() {
        Biblioteca biblioteca = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("DadosBiblioteca.txt"))) {
            biblioteca = (Biblioteca) inputStream.readObject();
            System.out.println("dados carregados");
        } catch (IOException | ClassNotFoundException e) {
            // erro arquivo n pode ser lido
        }
        return biblioteca;
    }
}