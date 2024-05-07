

public abstract class Movie
{

	private String title;

	public Movie (String title) {
		this.title 		= title;
	}

	
	public String getTitle () {
		return title;
	}

	abstract double rentalAmount(int daysRented);

	abstract int frequentRenterPoints(int daysRented);
}
