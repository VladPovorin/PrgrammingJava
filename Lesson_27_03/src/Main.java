import java.util.Scanner;
abstract class UchebnoeZavedenie{
    String name;
    boolean isNew;
    UchebnoeZavedenie(String name, boolean isNew ){
        this.name = name;
        this.isNew = isNew;
    }
    abstract public String toString();
}
class School extends UchebnoeZavedenie{
    int pupils;
    School(String name, boolean isNew, int pupils ){
        super(name, isNew);
        this.pupils = pupils;
    }
    public String toString() {
        return "Название школы: "+name+" Новое ли?: "+(isNew?"Да":"Нет")+" число школьников: "+pupils;
    }

}
class College extends UchebnoeZavedenie{
    boolean hasITSpeciality;
    College(String name, boolean isNew, boolean hasITSpeciality ){
        super(name, isNew);
        this.hasITSpeciality = hasITSpeciality;
    }
    public String toString() {
        return "Название колледжа: "+name+" Новое ли?: "+(isNew?"Да":"Нет")+" Есть ли IT пециальности?: "+(hasITSpeciality?"Да":"Нет");
    }
}
class University extends UchebnoeZavedenie{
    int rating;
    University(String name, boolean isNew, int rating){
        super(name, isNew);
        this.rating = rating;
    }
    public String toString() {
        return "Название Вуза: "+name+" Новое ли?: "+(isNew?"Да":"Нет")+" Рейтинг: "+rating;
    }
}

class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N=");
        int N = sc.nextInt();

        System.out.println("**********************");

        UchebnoeZavedenie arr[] = new UchebnoeZavedenie[N];

        for (int i=0; i<N; i++){
            sc.nextLine();
            System.out.print("Название: ");
            String fam = sc.nextLine();
            System.out.print("Новое ли?: ");
            boolean isNew = sc.nextBoolean();
            System.out.print("Школа, колледж или университет? (0, 1 или 2?)");
            int k = sc.nextInt();
            if (k==0) {
                System.out.print("Введите колличество школьников: ");
                int pupils = sc.nextInt();
                arr[i] = new School(fam, isNew, pupils);
            }
            else if(k==1) {
                System.out.print("Есть ли IT пециальности?: ");
                boolean hasITspeciality = sc.nextBoolean();

                arr[i] = new College(fam, isNew, hasITspeciality);
            }
            else{
                System.out.print("Рейтинг: ");
                int rating = sc.nextInt();
                arr[i] = new University(fam, isNew, rating);
            }
            if (i<N-1) System.out.println("-------------------");
        }

        System.out.println("**********************");

        for(UchebnoeZavedenie u : arr){
            System.out.println(u);
        }

    }
}