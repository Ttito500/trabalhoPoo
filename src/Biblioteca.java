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

    public void updateItem (int id, String doi, int qtd, String titulo){
        if (itens.containsKey(id)) {
            if (getItem(id) instanceof Artigo){
                
                if (doi != null) {
                    ((Artigo) getItem(id)).setDoi(doi);
                } if (qtd != 0){
                    getItem(id).setQtd(qtd);
                }
            }
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
