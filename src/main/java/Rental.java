
public class Rental
{
	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie () {
		return movie;
	}

	private Movie movie;
	private int daysRented;

	double rentalAmount() {
		return movie.rentalAmount(daysRented);
	}

	int frequentRenterPoints() {
		return movie.frequentRenterPoints(daysRented);
	}
}
