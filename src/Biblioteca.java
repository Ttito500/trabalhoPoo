import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;

public class Biblioteca implements Serializable {
    private Map<Integer, ItemBiblioteca> itens = new TreeMap<>();

    private Map<Integer, UsuarioBiblioteca> usuarios = new TreeMap<>();

    public void addItem(ItemBiblioteca item){
        itens.put(item.getId(), item);
    }

    public ItemBiblioteca getItem(int id){
        return itens.get(id);
    }

    public void deleteItem(int id){
        if (itens.containsKey(id)) {
            itens.remove(id);
        } else {
            throw new MsgException("fail: item não encontrado");
        }
    }

    public void updateItem(ItemBiblioteca newItem) {
        if (itens.containsKey(newItem.getId())) {
            ItemBiblioteca item = getItem(newItem.getId());
            if (item instanceof Artigo && newItem instanceof Artigo) {
                Artigo artigo = (Artigo) item;
                Artigo newArtigo = (Artigo) newItem;

                artigo.setDoi(newArtigo.getDoi());
                artigo.setQtd(newArtigo.getQtd());
                artigo.setTitulo(newArtigo.getTitulo());
            } else if (item instanceof Livro && newItem instanceof Livro) {
                Livro livro = (Livro) item;
                Livro newLivro = (Livro) newItem;

                livro.setIsbn(newLivro.getIsbn());
                livro.setQtd(newLivro.getQtd());
                livro.setTitulo(newLivro.getTitulo());
            }
        } else {
            throw new MsgException("fail: item não encontrdo");
        }
    }

    public void addUsuario(UsuarioBiblioteca usuario){
        usuarios.put(usuario.getIdUsuario(), usuario);
    }


    public void emprestar(int idUsuario, int idItem){
        ItemBiblioteca item = itens.get(idItem);
        item.setStatus(Status.EMPRESTADO);
        item.setDataEmprestimo(System.currentTimeMillis());
        usuarios.get(idUsuario).setEmprestimos(item);
    }

    public void devolver(int idUsuario, int idItem){
        ItemBiblioteca item = itens.get(idItem);
        item.setStatus(Status.DISPONIVEL);
        usuarios.get(idUsuario).getEmprestimos().remove(item);
    }
/*
    public float checkUsuario(int idUsuario){
        UsuarioBiblioteca usuarioBiblioteca = usuarios.get(idUsuario);
        for (ItemBiblioteca item : )
    }
*/
    public String showItens() {
        StringBuilder result = new StringBuilder("Biblioteca Contents:\n");

        for (ItemBiblioteca item : itens.values()) {
            result.append(item.toString()).append("\n");
        }

        return result.toString();
    }

    public String showUsuarios(){
        StringBuilder result = new StringBuilder("Biblioteca Contents:\n");

        for (UsuarioBiblioteca usuario : usuarios.values()) {
            result.append(usuario.toString()).append("\n");
        }

        return result.toString();
    }
}
