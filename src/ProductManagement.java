import java.io.*;
import java.util.LinkedList;

public class ProductManagement {
    public void writeProductToFile(LinkedList<Product> products, String fileName) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            outputStream.writeObject(products);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Product> readProductFromFile(String fileName) {
        try {

            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            LinkedList<Product> products = (LinkedList<Product>) objectInputStream.readObject();
            return products;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sai roi");
        }
        return null;
    }

    public LinkedList<Product> searchProductByName(String name, String fileName) {
        LinkedList<Product> list = readProductFromFile(fileName);
        LinkedList<Product> results = new LinkedList<>();
        for (Product product: list) {
            if (product.getName().equals(name)) {
                results.add(product);
            }
        }
        return results;
    }
}
