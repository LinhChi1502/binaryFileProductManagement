import jdk.jshell.SourceCodeAnalysis;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void menu() {
        var fileName = "product.txt";
        System.out.println("------------------MENU---------------------");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Hiển thị danh sách sản phẩm");
        System.out.println("3. Tìm kiếm sản phẩm");
        System.out.println("0. Thoát khỏi chương trình");
        System.out.println("Mời bạn chọn: ");
        int choice = new Scanner(System.in).nextInt();
        ProductManagement management = new ProductManagement();

        switch (choice) {
            case 0 -> {
                System.out.println("Cảm ơn bạn đã sử dụng chương trình này!");
            }
            case 1 -> {
                System.out.println("Mời nhập mã: ");
                String code = new Scanner(System.in).nextLine();

                System.out.println("Mời nhập tên: ");
                String name = new Scanner(System.in).nextLine();

                System.out.println("Mời nhập nhà sản xuất: ");
                String manufacturer = new Scanner(System.in).nextLine();

                System.out.println("Mời nhập giá:");
                double price = new Scanner(System.in).nextDouble();

                System.out.println("Mời nhập mô tả: ");
                String otherNote = new Scanner(System.in).nextLine();

                LinkedList<Product> products = management.readProductFromFile(fileName);
                Product product = new Product(code, name, manufacturer, price, otherNote);
                products.add(product);

                management.writeProductToFile(products, fileName);
            }

            case 2 -> {
                LinkedList<Product> products = management.readProductFromFile(fileName);
                for (Product product: products) {
                    System.out.println(product);
                }
            }
            case 3 -> {
                System.out.println("Mời nhập tên");
                String name = new Scanner(System.in).nextLine();
                LinkedList<Product> results = management.searchProductByName(name, fileName);
                for (Product product: results) {
                    System.out.println(product);
                }
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }
}

