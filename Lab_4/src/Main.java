import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите четырехзначное число: ");
        int n = Math.abs(scanner.nextInt());
        int sum = ((n/1000)%10) + ((n/100)%10) + ((n/10)%10) + ((n%10));
        if (sum%2 == 0){
            System.out.println("Сумма цифр данного числа четна");
        }
        else{
            System.out.println("Сумма цифр данного числа нечетна");
        }
    }
}