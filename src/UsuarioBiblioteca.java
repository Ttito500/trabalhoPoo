import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class UsuarioBiblioteca implements Serializable {
    private String nome;
    private final int idUsuario;
    //vou guardar aqui a data de devolução e o item. Vou usar unix timestamp, acredito qie funcionaria em um sistema pequeno,
    // já que muito provavelmente não vão ser feitos dois emprestimos no mesmo segundo pela mesma pessoa.
    private Map<Long, ItemBiblioteca> dataEmprestimos = new TreeMap<>();
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
        //segundos em um mes
        long tempoEmprestimo = 10L; //2592000L;

        if (!emprestimos.containsKey(item.getId())){
            this.emprestimos.put(item.getId(), item);

            long dataDevolucao = System.currentTimeMillis() + tempoEmprestimo;
            setDataEmprestimos(dataDevolucao, item);
        } else {
            throw new MsgException("fail: item já emprestado à " + nome);
        }
    }

    public void setDataEmprestimos(Long dataDevolucao, ItemBiblioteca item){
        long key = 0;
        for (Map.Entry<Long, ItemBiblioteca> entry : dataEmprestimos.entrySet()) {
            if (entry.getValue().equals(item)) {
                key = entry.getKey();
                break;
            }
        }
        if (key != 0) {dataEmprestimos.remove(key);} //remove itens iguais
        dataEmprestimos.put(dataDevolucao, item); //adciona item
    }

    public Map<Integer, ItemBiblioteca> getEmprestimos() {
        return emprestimos;
    }

    public Map<Long, ItemBiblioteca> getDataEmprestimos() {
        return dataEmprestimos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Usuário:\n");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        stringBuilder.append("IDusr: ").append(idUsuario);
        stringBuilder.append(", Nome: ").append(nome).append("\n\n");
        stringBuilder.append("Emprestimos:\n");

        for (Map.Entry<Long, ItemBiblioteca> entry : dataEmprestimos.entrySet()) {
            stringBuilder.append("ID: ").append(entry.getValue().getId());
            stringBuilder.append(", Título: ").append(entry.getValue().getTitulo());

            Date dataDevolucao = new Date(entry.getKey());
            stringBuilder.append(", devolução: ").append(dateFormat.format(dataDevolucao)).append("\n");
        }

        return stringBuilder.toString();
    }
}
