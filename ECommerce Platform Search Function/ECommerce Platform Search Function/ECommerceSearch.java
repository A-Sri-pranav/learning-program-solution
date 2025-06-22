
import java.util.*;

class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductName() {
        return productName.toLowerCase();
    }

    public String toString() {
        return productId + ": " + productName + " (" + category + ")";
    }

    @Override
    public int compareTo(Product other) {
        return this.getProductName().compareTo(other.getProductName());
    }
}

public class ECommerceSearch {

    public static Product linearSearch(List<Product> productList, String searchName) {
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(searchName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(List<Product> productList, String searchName) {
        int left = 0, right = productList.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            Product midProduct = productList.get(mid);
            String midName = midProduct.getProductName();

            if (midName.equalsIgnoreCase(searchName)) {
                return midProduct;
            } else if (midName.compareTo(searchName.toLowerCase()) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Shoes", "Footwear"));
        products.add(new Product(3, "Watch", "Accessories"));
        products.add(new Product(4, "Smartphone", "Electronics"));
        products.add(new Product(5, "Backpack", "Bags"));

        System.out.println("Linear Search Result:");
        Product result1 = linearSearch(products, "Watch");
        System.out.println(result1 != null ? result1 : "Product not found");

        Collections.sort(products);

        System.out.println("\nBinary Search Result:");
        Product result2 = binarySearch(products, "Watch");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}
