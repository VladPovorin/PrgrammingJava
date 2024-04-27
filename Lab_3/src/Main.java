import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class Footballer{
    private String fio;
    private String cmd_name;
    private int goals;
    Footballer(String fio, String cmd_name, int goals) {
        this.fio = fio;
        this.cmd_name = cmd_name;
        this.goals = goals;
    }
    public String get_fio(){
        return this.fio;
    }
    public String get_cmd_name(){
        return this.cmd_name;
    }
    public int get_goals(){
        return this.goals;
    }
    public String toString(){
        return "ФИО: "+fio+" Название команды: "+cmd_name+" число голов: "+goals;
    }
}

public class Main {
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Footballer[] arr_footballers = new Footballer[0];
        int n = 0;
        System.out.println("Нажмите любую клавишу...");
        while(true){
            try {
                if (scanner.hasNextLine()) {
                    scanner.nextLine(); // Удаляем символ переноса строки, если он есть
                }
                System.out.println("Введите количество футболистов = ");
                n = scanner.nextInt();
                if (n == 0) {
                    throw new Exception(ANSI_RED_BACKGROUND + "Количество футболистов не может быть равным нулю!" + ANSI_RESET);
                }
                arr_footballers = new Footballer[n];
                break;
            } catch (InputMismatchException ex) {
                System.out.println(ANSI_RED_BACKGROUND + "Введены некорректные данные! Ожидалось целое число." + ANSI_RESET);
            } catch (Exception ex) {
                System.out.println(ANSI_RED_BACKGROUND + "Введены некорректные данные! " + ex.getMessage() + ANSI_RESET);
            }
        }


        String fio,cmd_name;
        int goals;

        for(int i = 0; i<n; i++){
            while(true){
                try {
                    System.out.println("Введите ФИО "+(i+1)+"-го футболиста = ");
                    fio = scanner.next();
                    break;
                }
                catch (Exception ex){
                    System.out.println(ANSI_RED_BACKGROUND+"Введены некорректные данные!"+ANSI_RESET);
                    scanner.nextLine();// очистка символа переноса строки
                }
            }
            while(true){
                try {
                    System.out.println("Введите название команды "+(i+1)+"-го футболиста = ");
                    cmd_name = scanner.next();
                    break;
                }
                catch (Exception ex){
                    System.out.println(ANSI_RED_BACKGROUND+"Введены некорректные данные!"+ANSI_RESET);
                    scanner.nextLine();// очистка символа переноса строки
                }
            }
            while(true){
                try {
                    if (scanner.hasNextLine()) {
                        scanner.nextLine(); // Удаляем символ переноса строки, если он есть
                    }
                    System.out.println("Введите число голов "+(i+1)+"-го футболиста = ");
                    goals = scanner.nextInt();
                    if (goals < 0) {
                        throw new Exception(ANSI_RED_BACKGROUND + "Количество голов не может быть отрицательным!" + ANSI_RESET);
                    }
                    break;
                }catch (InputMismatchException ex) {
                    System.out.println(ANSI_RED_BACKGROUND + "Введены некорректные данные! Ожидалось целое положительное число." + ANSI_RESET);
                } catch (Exception ex){
                    System.out.println(ANSI_RED_BACKGROUND + "Введены некорректные данные! " + ex.getMessage() + ANSI_RESET);
                }
            }
            arr_footballers[i] = new Footballer(fio,cmd_name,goals);
        }
        for(Footballer f:arr_footballers){
            System.out.println(f);
        }
        try{
            System.out.println("Среднее арефметическое голов футболисто у которых число голов не больше 15 равно: " + avg_goals(arr_footballers));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static double avg_goals(Footballer arr[]) throws Exception{
        double sum = 0;
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].get_goals() < 15){
                sum += arr[i].get_goals();
                k ++;
            }
        }
        if ((sum == 0) || (k == 0)){throw new Exception(ANSI_RED_BACKGROUND + "Не найдено ни одного футболиста с количеством голов не более 15!" + ANSI_RESET);}
        return sum/k;
    }

}