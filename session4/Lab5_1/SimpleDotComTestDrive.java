import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class SimpleDotComTestDrive {
    public static void main (String[] args){
        Ship ship = new Ship();
        Pool pool = new Pool();
        Player player = new Player();

        while (ship.check_live()){
            Bullet bullet = player.shoot(pool);
        }
        System.out.println("Игра окончена.");
    }
}


class Pool{
    HashMap<String, HashMap> pool = new HashMap<String, HashMap>();
    HashMap<String, HashMap> shoot_pool = new HashMap<String, HashMap>();

    Integer[] tag_nums = {1, 2, 3, 4, 5, 6};
    String[] tag_abc = {"a","b","c","d","e","f"};

    public Pool(){  //init
        create_pool();
    }

    void create_pool(){
        System.out.println("Создание поля...");
        for (String tag : tag_abc){
            HashMap<Integer, Boolean> str_pool = Arrays.stream(tag.nums).collect(Collectors.toMap(i -> i, i -> false));
            pool.put(tag, str_pool);
            System.out.println(pool.get(tag));
        }
        shoot_pool = pool;
        System.out.print("Поле создано.");
    }

    void get_hit(Bullet shoot){
        String abc = shoot.getAbc();
        Integer num = shoot.getNum();

        if (pool.get(abc).get(num) == false){
            pool.get(abc).put(num, true);
            shoot_pool.get(abc).remove(num, false);
            shoot_pool.removeIf(key -> shoot_pool.get(key).isEmpty());

        } else {
            System.out.println("По этой клетке уже стреляли");
        }
    }
}

class Player{
    boolean hit = false;
    boolean mayhit = false;
    String[] direct = {"v", "h"};
    Bullet <String, Integer>last_cell = new Bullet<String, Integer>();

    Bullet<String, Integer> shoot(Pool pool){
        String abc = pool.shoot_pool.keySet().iterator().next();
        Integer num = (int)(shoot_pool.get(abc).keySet().iterator().next());
        Bullet<String, Integer> fire = new Bullet(abc, num);
        System.out.println("Игрок стреляет по клетке " + abc + num);

        return fire;
    }
}

class Ship{

    HashMap<Integer, Boolean> position = new HashMap<Integer,Boolean>();

    public Ship(){
        create_ship(); //init
    }


    void create_ship(){
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

class Bullet<A, B> {
    private final A abc;
    private final B num;

    public Bullet(A abc, B num) {
        this.abc = abc;
        this.num = num;
    }

    A getAbc(){
        return this.abc;
    }

    B getNum(){
        return this.num;
    }
}

