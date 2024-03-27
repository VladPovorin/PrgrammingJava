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
class Scinetist extends Asp{

    int patents;
    Scinetist (String fam, String name, String otch, int age, int arcticle,int patents){
        super(fam, name, otch, age,arcticle);
        this.patents = patents;
    }

    void show(){
        System.out.println("Ученый: "+fam+" "+name+" "+otch+" Возраст:"+age+" Статей:"+arcticle+" Патентов:"+patents);
    }
    public String toString(){
        return "Ученый: "+fam+" "+name+" "+otch+" Возраст:"+age+" Статей:"+arcticle+" Патентов:"+patents;
    }

}

class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N=");
        int N = sc.nextInt();



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
            System.out.print("Студенты, аспиранты или ученые? (0, 1 или 2?)");
            int k = sc.nextInt();
            if (k==0)
                st[i] = new Student(fam, name, otch, age);
            else if(k==1) {
                System.out.print("Статей: ");
                int article = sc.nextInt();

                st[i] = new Asp(fam, name, otch, age, article);
            }
            else{
                System.out.print("Статей: ");
                int article = sc.nextInt();
                System.out.print("Патентов: ");
                int patents = sc.nextInt();
                st[i] = new Scinetist(fam, name, otch, age, article, patents);
            }
            if (i<N-1) System.out.println("-------------------");
        }

        System.out.println("**********************");

        for(Student s : st){
            System.out.println(s);
        }

    }
}