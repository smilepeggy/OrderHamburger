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

// =============Healthy Burger Class==================
class HealthyBurger extends Hamburger {
    private Boolean egg;
    private Boolean rice;

    public HealthyBurger(Boolean lettuce, Boolean tomato, Boolean carrot, Boolean onion, Boolean egg, Boolean rice) {
        super(3, false, lettuce, tomato, carrot, onion);
//        this.name = "Healthy Burger";
        this.egg = egg;
        this.rice = rice;
    }

    private double calcBasePrice() {
        return 3.5;
    }

    @Override
    public double calcSidePrice() {
        double sidePrice = super.calcSidePrice();
        if (this.egg) sidePrice += 0.2;
        if (this.rice) sidePrice += 0.5;
        return sidePrice;
    }

    @Override
    public double calcTotalPrice() {
        return calcSidePrice() + calcBasePrice();
//        return super.calcTotalPrice();
    }
}

// =============Deluxe Burger Class==================

class DeluxeHamburger extends Hamburger {
    public DeluxeHamburger(int breadRollType) {
        super(breadRollType, true, true, true, true, true);
    }

    @Override
    public double calcTotalPrice() {
        return 12.75;
    }

}

// =============Order Class==================
class orderClass {
    private String name;
    private int hamburgerNumber;
    private String breadRollType;
    private Boolean hasMeat;
    private Boolean hasLettuce;
    private Boolean hasTomato;
    private Boolean hasCarrot;
    private Boolean hasOnion;
    private Boolean hasEgg;
    private Boolean hasRice;

    // selectHamburger
    public void selectHamburger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Bill's Burgers. We have 3 types of burgers: \n" +
                "1. Basic Burger: Hot dog bun or sesame bun, meat and 4 sides.\n" +
                "2. Healthy Burger: a brown rye bread roll with egg and rice.\n" +
                "3. Deluxe Burger: a white bread or normal bread with meat, chips and drinks.\n" +
                "Please choose one of them now 1, 2, or 3 ");
        boolean hasNext = scanner.hasNextInt();
        this.hamburgerNumber = scanner.nextInt();
        if (hasNext && (this.hamburgerNumber == 1 || this.hamburgerNumber == 2 || this.hamburgerNumber == 3)) {
            if (this.hamburgerNumber == 1) {
                this.name = "Basic Hamburger";
                scanner.nextLine();
                System.out.println("Thank you for choosing Basic Burger\n" +
                        "Hot dog bun (h)? or sesame bun (s)");
                String bunKind = scanner.nextLine();
                int bunType = bunKind.toLowerCase().equals("h") ? 1 : 2;
                System.out.println("With meat or not (with meat = 5.0, without meat = 4.5)? y/n");
                String meat = scanner.nextLine();
                this.hasMeat = meat.toLowerCase().equals("y");
                selectSide();
                selectBreadRollType(bunType);
                Hamburger basicHamburger = new Hamburger(bunType, this.hasMeat, this.hasLettuce, this.hasTomato, this.hasCarrot, this.hasOnion);

//                System.out.println(printMenu());
                System.out.println("Total Price: " + basicHamburger.calcTotalPrice());

            }
            if (this.hamburgerNumber == 2) {
                this.name = "Healthy Hamburger";
                scanner.nextLine();
                System.out.println("Thank you for choosing Healthy Hamburger\n" +
                        "with brown rye bread roll");
                int bunType = 3;
                this.hasMeat = false;
                selectSide();
                selectBreadRollType(bunType);
                HealthyBurger healthyBurger = new HealthyBurger(this.hasLettuce, this.hasTomato, this.hasCarrot, this.hasOnion, this.hasEgg, this.hasRice);
//                System.out.println(printMenu());
                System.out.println("Total Price: " + healthyBurger.calcTotalPrice());
            }
            if (this.hamburgerNumber == 3) {
                this.name = "Deluxe Hamburger";
                scanner.nextLine();
                System.out.println("Thank you for choosing Deluxe Burger\n" +
                        "White bread (w) or normal bread (n)");
                String bunKind = scanner.nextLine();
                int bunType = bunKind.toLowerCase().equals("w") ? 4 : 5;
                this.hasMeat = true;
                selectBreadRollType(bunType);
                DeluxeHamburger deluxeHamburger = new DeluxeHamburger(bunType);
                System.out.println(printMenu());
                System.out.println("Total Price: " + deluxeHamburger.calcTotalPrice());
            }
        }
    }

    // selectBreadRollType
    // 1 = Hot dog bun, 2 = Sesame bun, 3= Brown rye bread roll, 4 = White bread, 5=Normal bread
    private void selectBreadRollType(int breadRollType) {
        switch (breadRollType) {
            case 1:
                this.breadRollType = "Hod ot dog bun";
                break;
            case 2:
                this.breadRollType = "Sesame bun";
                break;
            case 3:
                this.breadRollType = "Brown rye bread roll";
                break;
            case 4:
                this.breadRollType = "White bread";
                break;
            case 5:
                this.breadRollType = "Normal bread";
                break;
        }
    }

    // selectBasicSide
    private void selectSide() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("side with lettuce? y/n (+0.12)");
        String lettuce = scanner.nextLine();
        this.hasLettuce = lettuce.toLowerCase().equals("y");
        System.out.println("side with tomato?  y/n (+0.36)");
        String tomato = scanner.nextLine();
        this.hasTomato = tomato.toLowerCase().equals("y");
        System.out.println("side with Carrot?  y/n (+0.2)");
        String carrot = scanner.nextLine();
        this.hasCarrot = carrot.toLowerCase().equals("y");
        System.out.println("side with Onion?   y/n (+0.17)");
        String onion = scanner.nextLine();
        this.hasOnion = onion.toLowerCase().equals("y");
        if (this.hamburgerNumber == 2) {
            System.out.println("side with Egg?   y/n (+0.2)");
            String egg = scanner.nextLine();
            this.hasEgg = egg.toLowerCase().equals("y");
            System.out.println("side with Rice?   y/n (+0.5)");
            String rice = scanner.nextLine();
            this.hasRice = rice.toLowerCase().equals("y");
        }
    }


    // printMenu
    public String printMenu() {
        String yourOrder = "Your Order : \n" + this.name + " with " + this.breadRollType + "\n";
        if (this.hamburgerNumber == 1 || this.hamburgerNumber == 2) {
            if (this.hasLettuce) 
                yourOrder += "Lettuce ";
            if (this.hasTomato)
                yourOrder += "Tomato ";
            if (this.hasCarrot)
                yourOrder += "Carrot ";
            if (this.hasOnion)
                yourOrder += "Onion ";
            if (this.hamburgerNumber == 2) {
                if (this.hasEgg)
                    yourOrder += "Egg ";
                if (this.hasRice)
                    yourOrder += "Rice ";
            }
        }

        if (this.hamburgerNumber == 3) {
            yourOrder += "with Lettuce, Tomato, Carrot,Onion, Chips and Drink ";
        }
        yourOrder += this.hasMeat ? "with Meat " : "without Meat ";
        return yourOrder;
    }
}
