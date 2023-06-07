package service;

import entity.Search;
import entity.impl.SearchNameImpl;
import entity.impl.SearchPriceImpl;

import java.util.List;

public class SearchFatory {
    public static Search getSearchFatory(String type){
        if (type.equals("name")){
            return new SearchNameImpl();
        }else if (type.equals("price")){
            return new SearchPriceImpl();
        }
        return null;
    }
}
