import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = 0;
        boolean isValid = false;

        do {
            try {
                System.out.print("Введите колличество сопротивлений N = ");
                N = sc.nextInt();
                if (N <= 0) {
                    throw new IllegalArgumentException("Значение должно быть больше нуля");
                }
                isValid = true;
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
                sc.nextLine(); // очистить буфер ввода
            }
        } while (!isValid);
        boolean isInvalid = false;
        double re_sum = 0;
        int R = 0;
        for (int i = 0; i < N; i++) {
            do {
                try {
                    System.out.print("Введите значене в Омах для "+(i+1)+"-го сопротивления R["+(i+1)+"] = ");
                    R = sc.nextInt();
                    if (R <= 0) {
                        throw new IllegalArgumentException("Значение должно быть больше нуля");
                    }
                    isInvalid = false;
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                    sc.nextLine(); // очистить буфер ввода
                    isInvalid = true;
                }
            } while (isInvalid);

            re_sum += (double) 1 /R;
        }


        String res = String.format("%.2f", (1/re_sum));
        System.out.print("Значение сопротивления цепи: " + res +" ОМ");


    }
}