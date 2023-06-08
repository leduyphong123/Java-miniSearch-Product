package entity.impl;

import entity.Product;
import entity.Search;
import service.ProductService;
import service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchNameImpl implements Search {

    @Override
    public List<Product> searchListProduct(String type) {
        List<Product> result=new ArrayList<>();
        ProductService productServiceImpl=new ProductServiceImpl();
        List<Product> listProduct= productServiceImpl.getProductAll();
        String NAME_REGEX="^"+type +".*|^[a-zA-Z].*"+type+"$";
        Pattern pattern=Pattern.compile(NAME_REGEX);
        Matcher matcher;
        for (Product list:listProduct){
            matcher = pattern.matcher(list.getName());
            if (matcher.matches()){
                result.add(list);
            }
        }
        return result;
    }

}
