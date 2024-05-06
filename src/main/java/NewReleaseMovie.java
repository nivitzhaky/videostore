public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    double determineAmount(int daysRented) {
        return daysRented * 3;

    }

    @Override
    int determineFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
