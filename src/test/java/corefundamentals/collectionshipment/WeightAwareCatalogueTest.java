package corefundamentals.collectionshipment;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class WeightAwareCatalogueTest {

    Product door = new Product("Wooden Door", 10);
    Product floorPanel = new Product("Floor Panel", 20);
    Product window = new Product("Glass Window", 30);
    Product windowFrame = new Product("Window Frame", 40);
    Product doorFrame = new Product("Door Frame", 50);

    WeightAwareCatalogue weightAwareCatalogue = new WeightAwareCatalogue();

    @Test
    void findLighterProducts_than_30() {
        List<Product> products = List.of(door, floorPanel, window, windowFrame, doorFrame);
        weightAwareCatalogue.addProducts(products);
        Set<Product> lighterProducts = weightAwareCatalogue.findLighterProducts(window);
        System.out.println("lighterProducts = " + lighterProducts);
        assertThat(lighterProducts, contains(door, floorPanel));
    }
}