public class Livro extends ItemBiblioteca {
    protected int isbn;

    public Livro(int isbn, int qtd, String titulo) {
        super(qtd, titulo);
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
                "isbn=" + isbn +
                ", id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
