package comparator;

import entity.Product;

import java.awt.desktop.PrintFilesEvent;
import java.util.Comparator;

public class ProductIdComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        if(p1.getId()-p2.getId()<0){
            return -1;
        }else if (p1.getId()-p2.getId()>0){
            return 1;
        }else {
            return 0;
        }
    }
}
