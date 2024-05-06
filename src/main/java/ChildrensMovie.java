public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    double determineAmount(int daysRented) {
        double rentalAmount = 1.5;
        if (daysRented > 3)
            rentalAmount += (daysRented - 3) * 1.5;
        return rentalAmount;
    }

    @Override
    int determineFrequentRenterPoints(int daysRented) {
        return  1;
    }
}
