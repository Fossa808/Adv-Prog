import java.util.Scanner;
public class EmojiGrid {
    public static void main(String[] args) {
        System.out.println("Welcome to EmojiGrid!");
        System.out.println("😭 - crying");
        System.out.println("😑 - expressionless");
        System.out.println("🤦🏽‍♀️ - facepalming");

        Scanner console = new Scanner(System.in);
        System.out.print("Which emoji do you choose? ");
        String emoji = console.next();
        System.out.print("How many rows? ");
        int rows = console.nextInt();
        System.out.print("How many columns? ");
        int columns = console.nextInt();

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                switch (emoji) {
                    case "crying":
                        System.out.print("😭");                        
                        break;
                    case "expressionless":
                        System.out.print("😑");
                        break;
                    case "facepalming":
                        System.out.print("🤦🏽‍♀️");
                        break;
                }
            }
            System.out.println();
        }
    }
}
