import java.util.*;


class College implements Comparable<College> {
    int id, workshop_count;
    String name;
    boolean has_IT_spec;
    College( int id,String name, int workshop_count, boolean has_IT_spec){
        this.id = id;
        this.name = name;
        this.workshop_count = workshop_count;
        this.has_IT_spec = has_IT_spec;
    }

    public String toString() {
        return "Идентификатор: "+id+" название техникума: " + name + " колличество мастерских: "
                +workshop_count+" есть ли IT специальности: "+(has_IT_spec==true?"Да":"Нет");
    }

    int get_id(){
        return  id;
    }
    int get_workshop_count(){
        return  workshop_count;
    }
    String get_name(){
        return  name;
    }
    boolean get_has_IT_spec(){
        return  has_IT_spec;
    }

    public int compareTo(College c) {
        if (get_workshop_count() == c.get_workshop_count())
            return 0;
        else if (get_workshop_count()>c.get_workshop_count())
            return 1;
        else
            return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_RESET = "\u001B[0m";
        String[] названияТехникумов = {
                "Московский техникум связи",
                "Санкт-Петербургский техникум железнодорожного транспорта",
                "Уральский техникум металлургии",
                "Сибирский техникум информационных технологий",
                "Дальневосточный техникум судостроения",
                "Казанский техникум нефтехимии",
                "Челябинский техникум машиностроения",
                "Краснодарский техникум пищевой промышленности",
                "Воронежский техникум строительства",
                "Новосибирский техникум экономики и управления"
        };

        System.out.println("Введите число: ");
        int N = scanner.nextInt();
        ArrayList arr = new ArrayList();
        System.out.println(ANSI_RED_BACKGROUND+ "Неотсортированный список техникумов: "+ANSI_RESET);
        for (int i = 0; i < N; i++) {
            arr.add(new College(i+1,
                    названияТехникумов[r.nextInt(9)],
                    r.nextInt(50)+1,
                    r.nextBoolean()));
            System.out.println(arr.get(i));
        }
        Collections.sort(arr);
        System.out.println("Отсортированный список техникумов: ");
        for (Object x : arr){
            System.out.println(x);
        }
        System.out.println("Введите позицию для добавления техникума: ");
        int i = scanner.nextInt();
        arr.add(i,new College(N+1,
                названияТехникумов[r.nextInt(9)],
                r.nextInt(50)+1,
                r.nextBoolean()));
        System.out.println("Список техникумов после добавления: ");
        for (Object x : arr){
            System.out.println(x);
        }
        System.out.println("Введите позицию для удаления техникума: ");
        i = scanner.nextInt();
        arr.remove(i);
        System.out.println("Список техникумов после удаления: ");
        for (Object x : arr){
            System.out.println(x);
        }
        System.out.println("Введите позицию для замены техникума: ");
        i = scanner.nextInt();
        arr.set(i,new College(N+1,
                названияТехникумов[r.nextInt(9)],
                r.nextInt(50)+1,
                r.nextBoolean()));
        System.out.println("Список техникумов после замены: ");
        for (Object x : arr){
            System.out.println(x);
        }
        System.out.println(ANSI_RED_BACKGROUND+"---------Работа с TreeMap---------"+ANSI_RESET);
        TreeMap t = new TreeMap();
        System.out.println("Введите число: ");
        int n = scanner.nextInt();
        for (int j = 0; j < n; j++) {
            t.put(j+1,new College(j+1,
                    названияТехникумов[r.nextInt(9)],
                    r.nextInt(50)+1,
                    r.nextBoolean()));
            System.out.println(t.get(j+1));
        }

        System.out.println("Введите номер для поиска техникума: ");
        i = scanner.nextInt();
        System.out.println("Список техникумов после добавления: ");
        System.out.println(t.get(i));

        System.out.println("Введите номер для удаления техникума: ");
        i = scanner.nextInt();
        t.remove(i);
        System.out.println("Список техникумов после удаления: ");
        for (Object x : t.values()){
            System.out.println(x);
        }
    }
}