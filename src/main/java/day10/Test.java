package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Fruit> list = new ArrayList<>();
        list.add(new Fruit(2000));
        list.add(new Fruit(3000));
        list.add(new Fruit(1000));
        System.out.println("원본 : " + list); // [[ Apple: 2000 ], [ Orange: 3000 ], [ Banana: 1000 ]]

        //price순 오름차순으로 정렬
        Collections.sort(list, new FruitPriceComparator());
        System.out.println("price 순 오름차순 : " + list);
        // [[ Banana: 1000 ], [ Apple: 2000 ], [ Orange: 3000 ]]
        // price순 내림차순으로 정렬
         Collections.sort(list, new FruitPriceComparator().reversed());
         System.out.println("price 순 내림차순 : " + list);
//         [[ Orange: 3000 ], [ Apple: 2000 ], [ Banana: 1000 ]]

    }

}

class FruitPriceComparator implements Comparator<Fruit> {
    public int compare(Fruit f1, Fruit f2) {
        if (f1.price > f2.price) {
            return 1;
        } else if (f1.price < f2.price) {
            return -1;
        }
        return 0;
    }
}

class Fruit {
    int price;

    public Fruit(int price) {
        this.price = price;
    }

    public String toString() {
        return this.price + " ";
    }
}
