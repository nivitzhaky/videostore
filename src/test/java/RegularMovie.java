public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    double rentalAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }

    @Override
    int frequentRenterPoints(int daysRented) {
        return 1;
    }
}
