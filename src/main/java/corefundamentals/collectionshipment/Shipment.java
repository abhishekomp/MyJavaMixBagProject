package corefundamentals.collectionshipment;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product> {

    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    public static final int MISSING_PRODUCT = -1;

    private List<Product> productList = new ArrayList<>();
    private List<Product> lightVanProducts = new ArrayList<>();
    private List<Product> heavyVanProducts = new ArrayList<>();

    public void add(Product product) {
        productList.add(product);
    }

    public List<Product> getLightVanProducts() {
        return lightVanProducts;
    }

    public List<Product> getHeavyVanProducts() {
        return heavyVanProducts;
    }

    @Override
    public Iterator<Product> iterator() {
        return productList.iterator();
    }

    public boolean replace(Product oldProduct, Product newProduct) {
        int position = productList.indexOf(oldProduct);
        if(position == MISSING_PRODUCT) {
            return false;
        }
        else {
            productList.set(position, newProduct);
            return true;
        }
        //TODO
        //productList.replaceAll();
    }

    public void prepare() {

        //Sort the product list
        //Collections.sort(productList, Product.BY_WEIGHT);

        productList.sort(Product.BY_WEIGHT);

        //find the Split point
        int splitPoint = findSplitPoint();

        //create two subviews of the list
        lightVanProducts = Collections.unmodifiableList(productList.subList(0, splitPoint));
        heavyVanProducts = productList.subList(splitPoint, productList.size());

    }

    private int findSplitPoint() {
        int size = productList.size();
        for(int i = 0; i < size; i++) {
            Product product = productList.get(i);
            if(product.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
                return i;
            }
        }
        return 0;
    }
}
