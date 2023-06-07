package service.impl;

import entity.Product;
import service.ProductService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private List<Product> listProduct;

    public ProductServiceImpl() {
        listProduct = new ArrayList<>();
    }

    @Override
    public boolean newProduct(Product product) {
        FileWriter fw;
        BufferedWriter bw;
        try {
            fw = new FileWriter("data//product.csv", true);
            bw = new BufferedWriter(fw);
            bw.write(String.valueOf(product.getId()));
            bw.write(",");
            bw.write(product.getName());
            bw.write(",");
            bw.write(String.valueOf(product.getPrice()));
            bw.write(",");
            bw.write(product.getDate());
            bw.write(",");
            bw.write(product.getNsx());
            bw.write(",");
            bw.write(String.valueOf(product.getLike()));
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Product> getProductAll() {
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("data//product.csv");
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String result[]=line.split(",");
                Product product = new Product(
                        Integer.valueOf(result[0]),
                        result[1],
                        Long.valueOf(result[2]),
                        result[3],
                        result[4],
                        Integer.valueOf(result[5])
                );
                listProduct.add(product);
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            return null;
        }
        return listProduct;
    }
}
