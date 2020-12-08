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
