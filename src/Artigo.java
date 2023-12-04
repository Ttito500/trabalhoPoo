import java.io.Serializable;

public class Artigo extends ItemBiblioteca implements Serializable {
    protected String doi;

    public Artigo(String doi, int qtd, String titulo, int id) {
        super(qtd, titulo, id);
        this.doi = doi;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String Doi) {
        this.doi = doi;
    }

    @Override
    public String toString() {
        return "Artigo{" +
                "id=" + id +
                ", qtd=" + qtd +
                ", titulo='" + titulo + '\'' +
                ", dataEmprestimo=" + dataEmprestimo +
                ", qtdDisponiveis=" + qtdDisponiveis +
                ", qtdEmpretados=" + qtdEmpretados +
                ", qtdAtrasados=" + qtdAtrasados +
                '}';
    }
}
