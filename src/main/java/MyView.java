import java.util.*;

public class MyView {

    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public MyView() {
        menu = new LinkedHashMap<>();

        menu.put("1", "  1 - Calculator");
        menu.put("Q", "  Q - Exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::pressButton1);

    }

    private void pressButton1() {
        System.out.println("Enter an expression (expression must have similar operations) : ");
        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();


        test=test.replaceAll("[^0-9]+", " ");
        int[] numbers = Arrays.stream(test.split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println("Select operation type : ");
        System.out.println("1 - '+'");
        System.out.println("2 - '-'");
        System.out.println("3 - '/'");
        System.out.println("4 - '*'");

        Scanner scanner1 = new Scanner(System.in);
        String operation = scanner1.nextLine();

        if(operation.equals("1")) {
            double result = 0;
            for (int i = 0; i < numbers.length; i++) {
                result += numbers[i];
            }
            System.out.println("Result : " + result);
        } else if (operation.equals("2")){
            double result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result -= numbers[i];
            }
            System.out.println("Result : " + result);
        }  else if (operation.equals("3")){
            double result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result /= numbers[i];
            }
            System.out.println("Result : " + result);
        } else if (operation.equals("4")){
            double result = 1;
            for (int i = 0; i < numbers.length; i++) {
                result *= numbers[i];
            }
            System.out.println("Result : " + result);
        } else {
            System.out.println("Wrong operation type , please try again :");
        }


    }

    private void outputMenu() {
        System.out.println("\nWELCOME TO MY APPLICATION:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }

}