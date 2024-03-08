public class MakeHippo {
    public static void main (String [] args) {
        Hippo h = new Hippo("Баффи");
        System.out.println(h.getName());
    }
}


public class Hippo extends Animal {
    public Hippo(String name) {
        super(name);
    }
}


public abstract class Animal {
    private String name;
    public String getName() {
        return name;
    }
    public Animal(String theName) {
        name = theName;
    }
}

