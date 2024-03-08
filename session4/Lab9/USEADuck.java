public class USEADuck {
    public static void main(String[] args) {
        Duck d = new Duck(42);
    }
}


public class Duck{
    int size;

    public Duck(int duckSize) {
        System.out.println("Кря");
        size = duckSize;
        System.out.println("Размер равен" + size);
    }
}

