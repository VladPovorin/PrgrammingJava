import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int N = 14;//1
        Scanner scanner = new Scanner(System.in);//1
        System.out.println("Введите число звонков: ");//1
        int calls = Math.abs(scanner.nextInt());//1
        int res = 0;//1
        scanner.nextLine();//1
        if (calls <= 10){//2
            res = N;//3
        } else if (calls >= 30) {//4
            res = 3*N;//5
        } else{//6
            res = 2*N;//6
        }

        System.out.println("Введите среднее время разговора (минут): ");//7
        int call_time = Math.abs(scanner.nextInt());//7
        if (call_time > 5){//8
            res = (int) Math.ceil(res * 1.2);//9
        }
        System.out.println("Достаточно "+res+" операторов.");//10
    }
}