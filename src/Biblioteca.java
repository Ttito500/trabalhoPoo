import java.util.*;

public class Biblioteca {
    private Map<Integer, ItemBiblioteca> itens = new TreeMap<>();

    public void addItem(ItemBiblioteca item){
        itens.put(item.getId(), item);
    }

    public ItemBiblioteca getItem(int id){
        return itens.get(id);
    }

    public void deleteItem(int id){
        itens.remove(id);
    }

    public int getTipo(int id){ // 1 é livro, 2 é artigo, default -1
        if (getItem(id) instanceof Livro){
            return 1;
        } else if (getItem(id) instanceof Artigo){
            return 2;
        } else {
            return -1;
        }
    }

    public void update (int id, ItemBiblioteca novoItem){
        if (itens.containsKey(id)) {
            itens.put(id, novoItem);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Biblioteca Contents:\n");

        for (ItemBiblioteca item : itens.values()) {
            result.append(item.toString()).append("\n");
        }

        return result.toString();
    }
}
