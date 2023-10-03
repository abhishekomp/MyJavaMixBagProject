package corefundamentals.collectionshipment;

import java.util.*;

public class WeightAwareCatalogue implements Iterable<Product>{

    private NavigableSet<Product> products = new TreeSet<>(Product.BY_WEIGHT);


    public void addProducts(List<Product> productList) {
        products.addAll(productList);
    }

    public Set<Product> findLighterProducts(Product product) {
        return products.headSet(product, false);
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
