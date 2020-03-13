import java.net.MalformedURLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter API key: ");
        String api_key = input.nextLine();


        new DropdownBox(api_key);
    }
}
