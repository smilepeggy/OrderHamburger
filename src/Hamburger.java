import java.util.Scanner;

public class Hamburger {
    //    private String name;
    private int breadRollType; // 1 = Hot dog bun, 2=sesame bun, 3=a brown rye bread roll, 4 = white bread, 5=normal bread
    private Boolean meat;
    private Boolean lettuce;
    private Boolean tomato;
    private Boolean carrot;
    private Boolean onion;

    public Hamburger(int breadRollType, Boolean meat, Boolean lettuce, Boolean tomato, Boolean carrot, Boolean onion) {
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.lettuce = lettuce;
        this.tomato = tomato;
        this.carrot = carrot;
        this.onion = onion;
    }


    private double calcBasePrice() {
        return 4.5;
    }

    public double calcSidePrice() {
        double sidePrice = 0;
        if (this.meat) sidePrice += 0.5;
        if (this.lettuce) sidePrice += 0.12;
        if (this.tomato) sidePrice += 0.36;
        if (this.carrot) sidePrice += 0.2;
        if (this.onion) sidePrice += 0.17;
        return sidePrice;
    }

    public double calcTotalPrice() {
        return calcSidePrice() + calcBasePrice();
    }


}

// =============Deluxe Burger Class==================

