import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VideoStoreTest
{
	public static final String CUSTOMER_NAME = "Customer Name";
	public static final Movie REGULAR_MOVIE1 = new Movie("Regular1", Movie.REGULAR);
	public static final Movie REGULAR_MOVIE2 = new Movie("Regular2", Movie.REGULAR);
	public static final Movie REGULAR_MOVIE3 = new Movie("Regular3", Movie.REGULAR);
	public static final Movie CHILDRENS_MOVIE = new Movie("Childrens", Movie.CHILDRENS);
	public static final Movie NEW_RELEASE_MOVIE1 = new Movie("NewRelease1", Movie.NEW_RELEASE);
	public static final Movie NEW_RELEASE_MOVIE2 = new Movie("NewRelease2", Movie.NEW_RELEASE);
	private Customer statement;

	public static final double DELTA = 0.001;


	@BeforeEach
	protected void setUp ()  {
		statement = new Customer (CUSTOMER_NAME);
	}

	@Test
	public void testSingleNewReleaseStatement () {
		statement.addRental (new Rental (NEW_RELEASE_MOVIE1, 3));
		statement.generate();
		assertEquals (9.0, statement.getTotalAmount(), DELTA);
		assertEquals (2, statement.getFrequentRenterPoints());
	}

	@Test
	public void testDualNewReleaseStatement () {
		statement.addRental (new Rental (NEW_RELEASE_MOVIE1, 3));
		statement.addRental (new Rental (NEW_RELEASE_MOVIE2, 3));
		statement.generate();
		assertEquals (18.0, statement.getTotalAmount(), DELTA);
		assertEquals (4, statement.getFrequentRenterPoints());
	}

	@Test
	public void testSingleChildrensStatement () {
		statement.addRental (new Rental (CHILDRENS_MOVIE, 3));
		statement.generate();
		assertEquals (1.5, statement.getTotalAmount(), DELTA);
		assertEquals (1, statement.getFrequentRenterPoints());
	}

	@Test
	public void testMultipleRegularStatement () {
		statement.addRental (new Rental (REGULAR_MOVIE1, 1));
		statement.addRental (new Rental (REGULAR_MOVIE2, 2));
		statement.addRental (new Rental (REGULAR_MOVIE3, 3));

		statement.generate();
		assertEquals (7.5, statement.getTotalAmount(), DELTA);
		assertEquals (3, statement.getFrequentRenterPoints());
	}
	@Test
	public void testMultipleRegularStatementFormat () {
		statement.addRental (new Rental (REGULAR_MOVIE1, 1));
		statement.addRental (new Rental (REGULAR_MOVIE2, 2));
		statement.addRental (new Rental (REGULAR_MOVIE3, 3));

		assertEquals ("Rental Record for Customer Name\n" +
				"\tRegular1\t2.0\n" +
				"\tRegular2\t2.0\n" +
				"\tRegular3\t3.5\n" +
				"You owed 7.5\n" +
				"You earned 3 frequent renter points\n",
				statement.generate());

	}
}
