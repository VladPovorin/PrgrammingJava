import java.util.Random;
import java.util.Scanner;

abstract class Animal{
    protected String name, family;
    Animal(String name, String family){
        this.name = name;
        this.family = family;
    }
    public String getName(){
        return this.name;
    }
    public String getFamily(){
        return this.family;
    }

}

class Bird extends Animal{
    protected double wingSize;
    Bird(String name, String family, double wingSize) {
        super(name,family);
        this.wingSize = wingSize;
    }
    public double getWingSize(){
        return this.wingSize;
    }
    public String toString(){
        return "Имя: "+name+" Семейство: "+family+" Длинна крыла, см: "+wingSize;
    }
}
class Mammal extends Animal{
    protected double maxVelocity;
    Mammal(String name, String family, double maxVelocity) {
        super(name,family);
        this.maxVelocity = maxVelocity;
    }
    public double getMaxVelocity(){
        return this.maxVelocity;
    }
    public String toString(){
        return "Имя: "+name+" Семейство: "+family+" Максимальная скорость, км/ч: "+maxVelocity;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_RESET = "\u001B[0m";


        String[] birdsNames = {"Воробей", "Орел", "Колибри", "Сова", "Пингвин", "Павлин", "Фламинго", "Дятел"};
        String[] birdsFamilies = {"Воробьиные", "Соколиные", "Колибриевые", "Совиные", "Пингвиновые", "Павлиновые",
                "Фламингообразные", "Дятловые"};

        System.out.print("Введите количество птиц = ");
        int n_bird = scanner.nextInt();
        scanner.nextLine(); // очистка символа переноса строки

        Bird[] arr_bird = new Bird[n_bird];
        for(int i = 0;i < n_bird;i++ ){

//            System.out.println("Введите имя:");
//            String name = scanner.nextLine();
//
//            System.out.println("Введите семейство:");
//            String family = scanner.nextLine();
//
//            System.out.println("Введите размер крыла, см:");
//            double wingSize = scanner.nextDouble();


            //Для удобства и тестирования
            String name = birdsNames[r.nextInt(0,birdsNames.length)];
            String family = birdsFamilies[r.nextInt(0,birdsFamilies.length)];
            double wingSize = r.nextDouble()*100;

            arr_bird[i] = new Bird(name,family,wingSize);

        }

        String[] mammalNames = {"Тигр", "Слон", "Лев", "Медведь", "Кенгуру", "Обезьяна", "Кит", "Зебра"};;
        String[] mammalFamilies = {"Кошачьи", "Собачьи", "Медвежьи", "Копытные", "Грызуны", "Китообразные"};

        System.out.print("Введите количество млекопитающих = ");
        int n_mammal = scanner.nextInt();
        scanner.nextLine(); // очистка символа переноса строки

        Mammal[] arr_mammal = new Mammal[n_mammal];
        for(int i = 0;i < n_mammal;i++ ){

//            System.out.println("Введите имя:");
//            String name = scanner.nextLine();
//
//            System.out.println("Введите семейство:");
//            String family = scanner.nextLine();
//
//            System.out.println("Введите максимальную скорость, км:");
//            double maxVelocity = scanner.nextDouble();

            //Для удобства и тестирования
            String name = mammalNames[r.nextInt(0,mammalNames.length)];
            String family = mammalFamilies[r.nextInt(0,mammalFamilies.length)];
            double maxVelocity = r.nextDouble()*100;

            arr_mammal[i] = new Mammal(name,family,maxVelocity);

        }
        System.out.println("\n Птицы, которых Вы ввели: ");
        for(Animal a:arr_bird){
            System.out.println(a);
        }
        System.out.println("\n Млекопитающие, которых Вы ввели: ");
        for(Animal a:arr_mammal){
            System.out.println(a);
        }

        double sum_task_1 = 0;

        for(Bird a:arr_bird){
            sum_task_1 += a.getWingSize();

        }
        double avgWingSize = sum_task_1/n_bird;
        int count_task_1 = 0;
        for(Bird a:arr_bird){
            if (a.wingSize>=avgWingSize){
                count_task_1++;
            }
        }
        if (count_task_1 == 0){
            System.out.println("\n"+ANSI_RED_BACKGROUND+" Нет птиц, длинна крыла которых не менее средней длинны: "+ANSI_RESET);
        } else{
            System.out.println("\n Птицы, длинна крыла которых не менее средней длинны (седняя длинна крыла = "+avgWingSize+"): ");
        }
        for(Bird a:arr_bird){
            if (a.wingSize>=avgWingSize){
                System.out.println(a);
            }

        }

        int count_task_2 = 0;
        for(Mammal a:arr_mammal){
            if (a.maxVelocity>10 && a.maxVelocity<=20){
                count_task_2++;
            }
        }
        if (count_task_2 == 0){
            System.out.println("\n"+ANSI_RED_BACKGROUND+" Нет млекопитающих, скорость которых в диапазоне от 10 до 20: "+ANSI_RESET);
        } else{
            System.out.println("\n Млекопитающие, скорость которых в диапазоне от 10 до 20: ");
        }
        for(Mammal a:arr_mammal){
            if (a.maxVelocity>10 && a.maxVelocity<=20){
                System.out.println(a);
            }
        }

        scanner.close();
    }
}