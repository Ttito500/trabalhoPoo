import java.io.Serializable;

public abstract class ItemBiblioteca implements Serializable {
    protected int id;
    protected int qtd;
    protected String titulo;
    protected Status status;
    protected long dataEmprestimo;

    public ItemBiblioteca(int qtd, String titulo, int id) {
        this.qtd = qtd;
        this.titulo = titulo;
        this.id = id;
        this.status = Status.DISPONIVEL;
    }

    public int getId() {
        return id;
    }

    public int getQtd() {
        return qtd;
    }

    public String getTitulo() {
        return titulo;
    }

    public Status getStatus() {
        return status;
    }

    public long getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setStatus(Status status) {////
        this.status = status;
    }

    public void setDataEmprestimo(long dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
}
