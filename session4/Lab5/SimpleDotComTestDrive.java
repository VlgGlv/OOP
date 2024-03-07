import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleDotComTestDrive {
    public static void main (String[] args){
        Ship ship = new Ship();

        int[] locations = {0,1, 2, 3, 4, 5, 6};
        ArrayList<Integer> shoot_loc = IntStream.range(0, 7).boxed().collect(Collectors.toCollection(ArrayList::new));

        while (ship.check_live()) {
            int userGuess = shoot_loc.get((int)(Math.random() * (shoot_loc.size() - 1)));

            System.out.println("Игрок стреляет по клетке: " + Integer.toString(userGuess));

            ship.get_hit(userGuess);
            shoot_loc.remove(Integer.valueOf(userGuess));
        }
        System.out.println("Игра окончена.");
    }
}


class Ship{

    HashMap<Integer, Boolean> position = new HashMap<Integer,Boolean>();

    public Ship(){
        set_ship(); //init
    }


    void set_ship(){

        int size = (int)(Math.random() * 4);
        int zero_position = (int)(Math.random()*(6 - size));
        int i = 0;

        while (i <= size){
            position.put(zero_position, false);
            i++;
            zero_position++;
        }

        System.out.println("Создан корабль размером: " + Integer.toString(size + 1));
        System.out.print("Корабль расположен на клетках:");

        for (int key : position.keySet()){
            System.out.print(" " + Integer.toString(key));
        }
        System.out.println("");
    }


    public Boolean check_live(){
        int live = position.size();

        for (Integer key : position.keySet()){
            if (position.get(key) == false){
                return true; //alive
            }
        }
        return false; //die
    }


    public void get_hit(int shoot){
        if (position.containsKey(shoot)){
            position.put(shoot, true);
            System.out.println("Попал!");
        } else {
            System.out.println("Мимо!");
        }

        if (check_live() == false){
            System.out.println("Потопил!");
        }
    }
}
