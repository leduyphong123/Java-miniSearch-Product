package comparator;

import entity.Product;

import java.util.Comparator;

public class ProductDateComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        if (p1.getDate().compareTo(p2.getDate())>0){
            return 1;
        }else if(p1.getDate().compareTo(p2.getDate())<0){
            return -1;
        }else {
            return 0;
        }
    }
}
