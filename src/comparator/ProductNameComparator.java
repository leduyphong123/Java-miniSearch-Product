package comparator;

import entity.Product;

import java.util.Comparator;

public class ProductNameComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        if (p1.getName().compareTo(p2.getName())>0){
            return 1;
        }else if (p1.getName().compareTo(p2.getName())<0){
            return -1;
        }else {
            return 0;
        }
    }
}
