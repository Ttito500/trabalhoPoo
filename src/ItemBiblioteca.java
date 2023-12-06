import java.io.Serializable;

public abstract class ItemBiblioteca implements Serializable {
    protected final int id;
    protected int qtd;
    protected String titulo;
    protected int qtdDisponiveis, qtdEmpretados;

    public ItemBiblioteca(int qtd, String titulo, int id) {
        this.qtd = qtd;
        this.titulo = titulo;
        this.id = id;
        this.qtdDisponiveis = qtd;
        this.qtdEmpretados = 0;
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

    public int getQtdDisponiveis() {
        return qtdDisponiveis;
    }

    public int getQtdEmpretados() {
        return qtdEmpretados;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setQtdDisponiveis(int qtdDisponiveis) {
        this.qtdDisponiveis = qtdDisponiveis;
    }

    public void setQtdEmpretados(int qtdEmpretados) {
        this.qtdEmpretados = qtdEmpretados;
    }

}
