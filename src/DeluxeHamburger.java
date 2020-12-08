class DeluxeHamburger extends Hamburger {
    public DeluxeHamburger(int breadRollType) {
        super(breadRollType, true, true, true, true, true);
    }

    @Override
    public double calcTotalPrice() {
        return 12.75;
    }

}
