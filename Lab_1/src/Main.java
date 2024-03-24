import java.util.Random;
import java.util.Scanner;

class Animal{
    private String name, animal_class;
    private int avg_weight;
    public static int calls = 0;
    Animal () {
        name = "Undefined name";
        animal_class = "Undefined class";
        avg_weight = 1;
        calls ++;
    }
    Animal(String name, String animal_class, int avg_weight) {
        this.name = name;
        this.animal_class = animal_class;
        this.avg_weight = avg_weight;
        calls ++;
    }
    Animal (Animal animalObject) {
        this.name = animalObject.name;
        this.animal_class = animalObject.animal_class;
        this.avg_weight = animalObject.avg_weight;
        calls ++;
    }
    public String getName(){
        return this.name;
    }
    public String getAnimal_class(){
        return this.animal_class;
    }
    public int getAvg_weight(){
        return this.avg_weight;
    }
    public  void show(){
        System.out.println("Имя: " + name + "\t класс: " + animal_class + "\t средний вес: " + avg_weight);
    }
    public static  void show_calls(){
        System.out.println("Существует " + calls + " объектов этого класса.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_RESET = "\u001B[0m";

        System.out.print("N=");
        int n = scanner.nextInt();

        String[] animalNames = {"Лев", "Зебра", "Слон", "Тигр", "Кенгуру", "Панда",
                "Гепард", "Орел", "Коала", "Жираф","Кошка","Ворона","Кит","Мышь"};
        String[] animalClasses = {"Млекопитающие", "Птицы", "Рептилии", "Амфибии",
                "Насекомые", "Рыбы", "Беспозвоночные", "Пресмыкающиеся", "Позвоночные", "Беспозвоночные"};

        Animal[] arr = new Animal[n];
        for(int i = 0;i < n;i++ ){

            System.out.println("Введите имя животного:");
            String name = scanner.next();

            System.out.println("Введите класс животного:");
            String animal_class = scanner.next();

            System.out.println("Введите средний вес животного:");
            int weight = scanner.nextInt();

            //Для удобства и тестирования
//            String name = animalNames[r.nextInt(0,9)];
//            String animal_class = animalClasses[r.nextInt(0,9)];
//            int weight = r.nextInt(10)+1;

            arr[i] = new Animal(name,animal_class,weight);

            //d[i].show();

        }
        System.out.println("\n Животные, которых Вы ввели: ");
        for(int i = 0;i < n;i++ ){
            arr[i].show();
        }
        double max = 0;
        int countAvgWeight = 0;
        int countAnimalsWithLatter = 0;
        for(int i = 0;i < n;i++ ){
            if (max<arr[i].getAvg_weight()){
                max = arr[i].getAvg_weight();
            }
        }
        for(int i = 0;i < n;i++ ){
            if (arr[i].getAvg_weight() != max){
                countAvgWeight ++;
            }
            if (arr[i].getName().contains("е") || arr[i].getName().contains("Е") || arr[i].getName().contains("з") || arr[i].getName().contains("З")){
                countAnimalsWithLatter ++;
            }
        }
        if (countAvgWeight == 0){
            System.out.println("\n"+ANSI_RED_BACKGROUND+"Нет животных,средний вес которых не максимальный "+ANSI_RESET);
        }
        else{
            System.out.println("\n Животные, средний вес которых не максимальный: ");
        }
        for(int i = 0;i < n;i++ ){
            if (arr[i].getAvg_weight() != max){
                arr[i].show();
            }
        }
        if (countAnimalsWithLatter == 0){
            System.out.println("\n"+ANSI_RED_BACKGROUND+"Нет животных, в имени которых есть буква 'е' или 'з' "+ANSI_RESET);
        }
        else{
            System.out.println("\n Животные, в имени которых есть буква 'е' или 'з': ");
        }
        for(int i = 0;i < n;i++ ){
            if (arr[i].getName().contains("е") || arr[i].getName().contains("Е") || arr[i].getName().contains("з") || arr[i].getName().contains("З")){
                arr[i].show();
            }
        }

        Animal.show_calls();
        scanner.close();
    }
}
