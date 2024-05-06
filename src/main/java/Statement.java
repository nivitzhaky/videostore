
import java.util.ArrayList;
import java.util.List;

public class Statement
{

	private String customerName;
	private List<Rental> rentals = new ArrayList<>();
	private double totalAmount;
	private int frequentRenterPoints;


	public Statement(String customerName) {
		this.customerName = customerName;
	}

	public String generate() {
		initCounters();
		String 	result 	= header();
		result += rentalLines();
		result += footer();
		return result;
	}

	private String rentalLines() {
		String result = "";
		for (Rental rental : rentals)
			result += rentalLine(rental);
		return result;
	}

	private String rentalLine(Rental rental) {
		String 	result 		= "";
		double 	rentalAmount = rental.determineAmount();
		frequentRenterPoints += rental.determineFrequentRenterPoints();
		result += formatRentalLine(rental, rentalAmount);
		totalAmount += rentalAmount;
		return result;
	}

	private static String formatRentalLine(Rental rental, double rentalAmount) {
		return "\t" + rental.getMovie().getTitle() + "\t"
				+ rentalAmount + "\n";
	}

	private String footer() {
		return  "You owed " + totalAmount + "\n" +
				"You earned " + frequentRenterPoints + " frequent renter points\n";

	}

	private void initCounters() {
		totalAmount = 0;
		frequentRenterPoints = 0;
	}

	private String header() {
		return "Rental Record for " + getCustomerName() + "\n";
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public int getFrequentRenterPoints() {
		return frequentRenterPoints;
	}

	public void addRental (Rental rental) {
		rentals.add (rental);
	}

	public String getCustomerName() {
		return customerName;
	}
}
