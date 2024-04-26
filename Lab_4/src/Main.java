import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//1
        System.out.println("Введите четырехзначное число: ");//1
        int n = Math.abs(scanner.nextInt());//1
        int sum = ((n/1000)%10) + ((n/100)%10) + ((n/10)%10) + ((n%10));//1
        System.out.println("Сумма цифр данного числа равна: "+sum);
        if (sum%2 == 0 /*2*/ && (sum < 13 /*3*/  || sum > 17 /*4*/)){
            System.out.println("Сумма цифр данного числа удовлетворяет\n условию(четна и меньше 13 или больше 17)");//5
        }
        else{//6
            System.out.println("Сумма цифр данного числа не удовлетворяет\n условию(нечетна и не меньше 13 или не больше 17)");//6
        }
    }//7
}