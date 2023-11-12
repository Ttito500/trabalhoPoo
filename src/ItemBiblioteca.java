public abstract class ItemBiblioteca {
    protected int id;
    protected int qtd;
    protected String titulo;
    protected int status; //se tiver emprestado, tem a data de emprestimo dentro. Se não, -1.

    public ItemBiblioteca(int qtd, String titulo, int id) {
        this.qtd = qtd;
        this.titulo = titulo;
        this.id = id;
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

    public int getStatus() {
        return status;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
