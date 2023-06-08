import comparator.ProductIdComparator;
import comparator.ProductNameComparator;
import entity.Product;
import entity.Search;
import service.ProductService;
import service.SearchFatory;
import service.impl.ProductServiceImpl;

import java.io.*;
import java.util.*;

public class Main {
    public static ProductService productServiceImpl = new ProductServiceImpl();
    public static Scanner input = new Scanner(System.in);
    public static int idProductDefault = 1;
    public static final int likeProductDefault = 0;

    public static void main(String[] args) {
        File file = new File("data/idProductDefault.csv");
        if (!file.exists()) {
            writeIdProductDefault(1);
        }
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

    private static void writeIdProductDefault(int id) {
        FileWriter fw;
        BufferedWriter bw;
        try {
            fw = new FileWriter("data//idProductDefault.csv", true);
            bw = new BufferedWriter(fw);
            bw.write(String.valueOf(id));
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " error");
        }
    }

    private static int readIdProductDefaul() {
        FileReader fr;
        BufferedReader br;
        List<String> idProduct = new ArrayList<>();
        try {
            fr = new FileReader("data//idProductDefault.csv");
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                idProduct.add(line);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.getMessage();
        }
        int max = Integer.valueOf(idProduct.get(0));
        for (int i = 1; i < idProduct.size(); i++) {
            if (max < Integer.valueOf(idProduct.get(i))) {
                max = Integer.valueOf(idProduct.get(i));
            }
        }
        return max;
    }

    private static void searchProduct(String type) {
        Search search = SearchFatory.getSearchFatory(type);
        List<Product> listProduct;
        System.out.println("Nhap thong so can tim");
        listProduct = search.searchListProduct(input.nextLine());
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
        Product product = new Product(readIdProductDefaul(), name, price, date, nsx, likeProductDefault);
        boolean result = productServiceImpl.newProduct(product);
        if (result) {
            writeIdProductDefault(readIdProductDefaul() + 1);
        }
        alertMessenger(result, "new product");
    }

    private static void viewListProduct() {
        System.out.println("view list product");
        List<Product> listProduct = productServiceImpl.getProductAll();
        if (listProduct == null) {
            System.out.println("chua co product nao");
            return;
        }
//        ProductNameComparator productNameComparator = new ProductNameComparator();
        ProductIdComparator productIdComparator =new ProductIdComparator();
        Collections.sort(listProduct, productIdComparator);
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