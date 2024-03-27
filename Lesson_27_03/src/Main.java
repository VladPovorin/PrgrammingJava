import java.util.Scanner;

class Student{ // суперкласс, родитель
    String fam, name, otch;
    int age;
    Student(String fam, String name, String otch, int age){
        this.fam = fam;
        this.name = name;
        this.otch = otch;
        this.age = age;
    }
    void show(){
        System.out.println("Студент: "+fam+" "+name+" "+otch+" Возраст:"+age);
    }
    public String toString(){
        return "Студент: "+fam+" "+name+" "+otch+" Возраст:"+age;
    }
}

class Asp extends Student { // подкласс, потомок
    int arcticle;
    Asp(String fam, String name, String otch, int age, int arcticle){
        super(fam, name, otch, age);
        this.arcticle = arcticle;
    }
    void show(){
        System.out.println("Аспирант: "+fam+" "+name+" "+otch+" Возраст:"+age+" Статей:"+arcticle);
    }
    public String toString(){
        return "Аспирант: "+fam+" "+name+" "+otch+" Возраст:"+age+" Статей:"+arcticle;
    }

}

class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N=");
        int N = sc.nextInt();

        System.out.print("Студенты или аспиранты? (0 или 1?)");
        int k = sc.nextInt();

        System.out.println("**********************");

        Student st[] = new Student[N];

        for (int i=0; i<N; i++){
            sc.nextLine();
            System.out.print("Фамилия: ");
            String fam = sc.nextLine();
            System.out.print("Имя: ");
            String name = sc.nextLine();
            System.out.print("Отчество: ");
            String otch = sc.nextLine();
            System.out.print("Возраст: ");
            int age = sc.nextInt();
            if (k==0)
                st[i] = new Student(fam, name, otch, age);
            else {
                System.out.print("Статей: ");
                int article = sc.nextInt();
                st[i] = new Asp(fam, name, otch, age, article);
            }
            if (i<N-1) System.out.println("-------------------");
        }

        System.out.println("**********************");

        for(Student s : st){
            System.out.println(s);
        }

    }
}