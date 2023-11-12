public class Artigo extends ItemBiblioteca {
    protected int issn;

    public Artigo(int issn, int qtd, String titulo) {
        super(qtd, titulo);
        this.issn = issn;
    }

    public int getIssn() {
        return issn;
    }

    public void setIssn(int issn) {
        this.issn = issn;
    }

    @Override
    public String toString() {
        return "Artigo{" +
                "issn=" + issn +
                ", id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
