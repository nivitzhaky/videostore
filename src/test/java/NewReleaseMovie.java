public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    double rentalAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int frequentRenterPoints(int daysRented) {
        return  (daysRented > 1) ? 2 : 1;
    }
}
