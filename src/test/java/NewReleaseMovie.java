public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    double rentalAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int frequentRenterPoints(int daysRented) {
        return  (getPriceCode() == NEW_RELEASE && daysRented > 1) ? 2 : 1;
    }
}
