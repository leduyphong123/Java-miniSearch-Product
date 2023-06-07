package entity;

import java.util.List;

public interface Search {
    List<Product> searchListProduct(String type);
    List<Product> searchListProduct(long price);
}
