import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VideoStoreTest
{
	private Statement statement;

	public static final String NEW_RELEASE_1 = "New Release1";
	public static final Movie NEW_RELEASE1 = new NewReleaseMovie(NEW_RELEASE_1, Movie.NEW_RELEASE);
	public static final String NEW_RELEASE_2 = "New Release2";
	public static final Movie NEW_RELEASE2 = new NewReleaseMovie(NEW_RELEASE_2, Movie.NEW_RELEASE);
	public static final String CHILDRENS1 = "Childrens";
	public static final Movie CHILDRENS = new ChildrensMovie(CHILDRENS1, Movie.CHILDRENS);
	public static final String REGULAR_1 = "Regular1";
	public static final Movie REGULAR1 = new RegularMovie(REGULAR_1, Movie.REGULAR);
	public static final String REGULAR_2 = "Regular2";
	public static final Movie REGULAR2 = new RegularMovie(REGULAR_2, Movie.REGULAR);
	public static final String REGULAR_3 = "Regular3";
	public static final Movie REGULAR3 = new RegularMovie(REGULAR_3, Movie.REGULAR);


	@BeforeEach
	protected void setUp ()  {
		statement = new Statement("Customer Name");
	}

	@Test
	public void testSingleNewReleaseStatement () {
		statement.addRental (new Rental (NEW_RELEASE1, 3));
		statement.generate();
		assertEquals(statement.getTotalAmount(), 9.0);
		assertEquals(statement.getFrequentRenterPoints(), 2);
	}

	@Test
	public void testDualNewReleaseStatement () {
		statement.addRental (new Rental (NEW_RELEASE1, 3));
		statement.addRental (new Rental (NEW_RELEASE2, 3));
		statement.generate();
		assertEquals(statement.getTotalAmount(), 18.0);
		assertEquals(statement.getFrequentRenterPoints(), 4);
	}

	@Test
	public void testSingleChildrensStatement () {
		statement.addRental (new Rental (CHILDRENS, 3));
		statement.generate();
		assertEquals(statement.getTotalAmount(), 1.5);
		assertEquals(statement.getFrequentRenterPoints(), 1);
	}

	@Test
	public void testMultipleRegularStatement () {
		statement.addRental (new Rental (REGULAR1, 1));
		statement.addRental (new Rental (REGULAR2, 2));
		statement.addRental (new Rental (REGULAR3, 3));
		statement.generate();
		assertEquals(statement.getTotalAmount(), 7.5);
		assertEquals(statement.getFrequentRenterPoints(), 3);
	}

	@Test
	public void testMultipleRegularStatementFormat () {
		statement.addRental (new Rental (REGULAR1, 1));
		statement.addRental (new Rental (REGULAR2, 2));
		statement.addRental (new Rental (REGULAR3, 3));

		assertEquals ("Rental Record for Customer Name\n" +
				"\t" + REGULAR_1 + "\t2.0\n" +
				"\t" + REGULAR_2 + "\t2.0\n" +
				"\t"+  REGULAR_3+ "\t3.5\n" +
				"You owed 7.5\n" +
				"You earned 3 frequent renter points\n",
				statement.generate());
	}
}
