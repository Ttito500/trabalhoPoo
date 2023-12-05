import java.io.Serializable;

public class Livro extends ItemBiblioteca implements Serializable {
    protected int isbn;

    public Livro(int isbn, int qtd, String titulo, int id) {
        super(qtd, titulo, id);
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", qtd=" + qtd +
                ", titulo='" + titulo + '\'' +
                ", qtdDisponiveis=" + qtdDisponiveis +
                ", qtdEmpretados=" + qtdEmpretados +
                ", qtdAtrasados=" + qtdAtrasados +
                '}';
    }
}
