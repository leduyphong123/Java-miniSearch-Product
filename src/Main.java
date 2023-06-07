import comparator.ProductNameComparator;
import entity.Product;
import entity.Search;
import service.ProductService;
import service.SearchFatory;
import service.impl.ProductServiceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static ProductService productServiceImpl = new ProductServiceImpl();
    public static Scanner input = new Scanner(System.in);
    public static int idProductDefault = 1;
    public static final int likeProductDefault = 0;

    public static void main(String[] args) {
        int key = -1;
        do {
            System.out.println("----------MENU----------");
            System.out.println("1.New Product");
            System.out.println("2.View Product");
            System.out.println("3.Search name");
            System.out.println("4.Search price");
            key = input.nextInt();
            input.nextLine();
            switch (key) {
                case 1:
                    newProduct();
                    break;
                case 2:
                    viewListProduct();
                    break;
                case 3:
                    searchProduct("name");
                    break;
                case 4:
                    searchProduct("price");
                    break;
                default:
                    break;
            }
        } while (key != 0);

    }

    private static void searchProduct(String type) {
        Search search = SearchFatory.getSearchFatory(type);
        List<Product> listProduct;
        if (type.equals("name")) {
            System.out.println("Nhap name can tim");
            listProduct = search.searchListProduct(input.nextLine());
        } else {
            System.out.println("Nhap gia can tim");
            listProduct = search.searchListProduct(input.nextLong());
        }
        for (Product list : listProduct) {
            System.out.println(list);
        }
    }

    private static void newProduct() {
        System.out.println("Nhap name");
        String name = input.nextLine();
        System.out.println("Nhap price");
        long price = input.nextLong();
        input.nextLine();
        System.out.println("Nhap date");
        String date = input.nextLine();
        System.out.println("Nhap nha san xuat");
        String nsx = input.nextLine();
        Product product = new Product( name, price, date, nsx, likeProductDefault);
        boolean result = productServiceImpl.newProduct(product);

        alertMessenger(result, "new product");
    }

    private static void viewListProduct() {
        System.out.println("view list product");
        List<Product> listProduct = productServiceImpl.getProductAll();
        if ( listProduct==null){
            System.out.println("chua co product nao");
            return;
        }
        ProductNameComparator productNameComparator = new ProductNameComparator();
        Collections.sort(listProduct, productNameComparator);
        for (Product list : listProduct) {
            System.out.println(list);
        }
    }

    private static void alertMessenger(boolean result, String messenger) {
        if (result) {
            System.out.println(messenger + " succes");
        } else {
            System.out.println(messenger + " error");
        }
    }
}