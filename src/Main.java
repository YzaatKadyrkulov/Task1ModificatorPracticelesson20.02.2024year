import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static  void main(String[] args) {
        /**
         * Создайте клаcc Product.
         * Поля (name description, price, createdAt)
         * Создайте два дочерних класса
         * Electronics
         * поля(brand, color, isNew, memory) и
         *  Book (authorFullName)
         * User (firstName, lastName, email, password, products)
         * Для старта сайта выбираем 3 операции
         * -Register
         * -Login
         * -Exit
         * После входа в аккаунт пользователю должны быть доступны
         * следующие методы:
         * -Add new Product
         * -Get All Products
         * -Get All Books
         * -Get All Electronics
         */
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    currentUser = registerUser(scanner);
                    break;
                case 2:
                    currentUser = loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (currentUser != null) {
                while (true) {
                    System.out.println("1. Add new Product");
                    System.out.println("2. Get All Products");
                    System.out.println("3. Get All Books");
                    System.out.println("4. Get All Electronics");
                    System.out.println("5. Logout");
                    System.out.print("Choose an option: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            addNewProduct(currentUser, scanner);
                            break;
                        case 2:
                            getAllProducts(currentUser);
                            break;
                        case 3:
                            getAllBooks(currentUser);
                            break;
                        case 4:
                            getAllElectronics(currentUser);
                            break;
                        case 5:
                            currentUser = null;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                    if (currentUser == null) {
                        break;
                    }
                }
            }
        }
    }

    private static User registerUser(Scanner scanner) {
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        return new User(firstName, lastName, email, password);
    }

    private static User loginUser(Scanner scanner) {
        User[]users = new User[]{};
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();



        for (User user : users) {
            if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome back, " + user.getFirstName() + "!");
                return user;
            }
        }

        System.out.println("Login failed. Incorrect email or password.");
        return null;
    }




    private static void addNewProduct(User currentUser, Scanner scanner) {
        System.out.println("Enter product details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Is it a book or an electronic device? (B/E): ");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("B")) {
            System.out.print("Author's full name: ");
            String authorFullName = scanner.nextLine();
            currentUser.addProduct(new Book(name, description, price, authorFullName));
        } else if (type.equalsIgnoreCase("E")) {
            System.out.print("Brand: ");
            String brand = scanner.nextLine();
            System.out.print("Color: ");
            String color = scanner.nextLine();
            System.out.print("Is it new? (true/false): ");
            boolean isNew = scanner.nextBoolean();
            scanner.nextLine();
            System.out.print("Memory: ");
            String memory = scanner.nextLine();
            currentUser.addProduct(new Electronics(name, description, price, brand, color, isNew, memory));
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void getAllProducts(User currentUser) {
        System.out.println("All Products:");
        for (Product product : currentUser.getAllProducts()) {
            if (product != null) {
                System.out.println(product.getName());
            }
        }
    }

    private static void getAllBooks(User currentUser) {
        System.out.println("All Books:");
        for (Book book : currentUser.getAllBooks()) {
            if (book != null) {
                System.out.println(book.getName() + " by " + book.getAuthorFullName());
            }
        }
    }

    private static void getAllElectronics(User currentUser) {
        System.out.println("All Electronics:");
        for (Electronics electronics : currentUser.getAllElectronics()) {
            if (electronics != null) {
                System.out.println(electronics.getName());
            }
        }
    }
}
