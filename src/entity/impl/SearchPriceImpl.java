package entity.impl;

import entity.Product;
import entity.Search;
import service.ProductService;
import service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchPriceImpl implements Search {
    public List<Product> searchListProduct(String type) {
        return null;
    }

    public List<Product> searchListProduct(long price) {
        List<Product> result=new ArrayList<>();
        ProductService productServiceImpl=new ProductServiceImpl();
        List<Product> listProduct= productServiceImpl.getProductAll();

        for (Product list:listProduct){
            if (list.getPrice()>=price){
                result.add(list);
            }
        }
        return result;
    }
}
