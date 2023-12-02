import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class UsuarioBiblioteca implements Serializable {
    private String nome;
    private int idUsuario;
    private Map<Integer, ItemBiblioteca> emprestimos = new TreeMap<>();

    public UsuarioBiblioteca(String nome, int idUsuario) {
        this.nome = nome;
        this.idUsuario = idUsuario;
        this.emprestimos = new TreeMap<>();
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

    public void setEmprestimos(ItemBiblioteca item) {
        this.emprestimos.put(item.getId(), item);
    }

    @Override
    public String toString() {
        return "UsuarioBiblioteca{" +
                "nome='" + nome + '\'' +
                ", emprestimos=" + emprestimos +
                '}';
    }
}
