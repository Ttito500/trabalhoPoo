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

    public void updateItem(Artigo newItem) {
        if (itens.containsKey(newItem.getId())) {
            ItemBiblioteca item = getItem(newItem.getId());
            if (item instanceof Artigo) {
                Artigo artigo = (Artigo) item;

                artigo.setDoi(newItem.getDoi());
                artigo.setQtd(newItem.getQtd());
                artigo.setTitulo(newItem.getTitulo());
            } else if (item instanceof Livro) {
                Livro livro = (Livro) item;

                livro.setIsbn(newItem.getIsbn());
                livro.setQtd(newItem.getQtd());
                livro.setTitulo(newItem.getTitulo());
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
