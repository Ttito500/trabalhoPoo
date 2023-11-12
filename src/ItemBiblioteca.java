public abstract class ItemBiblioteca {
    protected int id = 0;
    protected int qtd;
    protected String titulo;
    protected int status; //se tiver emprestado, tem a data de emprestimo dentro. Se não, -1.

    public ItemBiblioteca(int qtd, String titulo) {
        this.qtd = qtd;
        this.titulo = titulo;
    }

    public int getId() {
        id++;
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
