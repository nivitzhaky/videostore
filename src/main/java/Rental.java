
public class Rental
{
	private Movie movie;
	private int daysRented;

	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
	}

	double rentalAmount() {
		return movie.rentalAmount(daysRented);
	}

	int frequentRenterPoints() {
		return movie.frequentRenterPoints(daysRented);
	}

	public Movie getMovie () {
		return movie;
	}
}
