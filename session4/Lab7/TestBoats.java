public class TestBoats{
    public static void main (String[] args){
        Boat b1 = new Boat();
        Sailboat b2 = new Sailboat();
        RowBoat b3 = new RowBoat();
        b2.setLength(32);
        b2.move();
        b3.move();
        b1.move();
    }
}
public class Boat{
    private int length;
    public void setLength(int len){
        length = len;
    }
    public int getLength(){
        return length;
    }
    public void move (){
        System.out.println("Поднять паруса!");
    }
}

public class Sailboat extends Boat{
    public void move(){
        System.out.print("Драйф ");
    }
}

public class RowBoat extends Sailboat{
    public void rowTheBoat(){
        System.out.print("Давай, Наташа");
    }
}

