import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(String name) {
         return products.stream()
                 .filter(product -> product.getName().equals(name))
                 .findFirst()
                 .orElse(null);
    }

    public List<Product> getProductsByPlace(String place) {
        return products.stream()
                .filter(product -> product.getPlace().equals(place))
                .toList();
    }

    public List<Product> getProductsNotUnderWarrenty(int currentYear) {
        return products.stream()
                .filter(product -> product.getWarrenty() < currentYear)
                .toList();
    }

    public List<Product> getProductsContainsWord(String word) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(word) ||
                        product.getType().toLowerCase().contains(word) ||
                        product.getPlace().toLowerCase().contains(word))
                .toList();
    }
}


