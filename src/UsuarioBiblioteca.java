import java.util.LinkedList;

public class UsuarioBiblioteca {
    private String nome;
    private int idUsuario;
    private LinkedList<ItemBiblioteca> emprestimos;

    public UsuarioBiblioteca(String nome, int idUsuario) {
        this.nome = nome;
        this.idUsuario = idUsuario;
        this.emprestimos = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
