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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Biblioteca Contents:\n");

        for (ItemBiblioteca item : itens.values()) {
            result.append(item.toString()).append("\n");
        }

        return result.toString();
    }
}
