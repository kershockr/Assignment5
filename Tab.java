import java.text.DecimalFormat;

// totaling all of the ordered items

public class Tab 
{

	private Aggregator aggregator;
	
	public Tab(Aggregator agg)
	{
		aggregator = agg;
	}
	
	public double getTotal()
	{
		double total = 0;
		for(Item item : aggregator.getMyItems())
			total += item.getPrice();
		return total;
	}
	
	public double getTaxAmount()
	{
		return getTotal() * SystemInterface.TAX;
	}
	
	public double getTotalWithTax()
	{
		return getTotal() + getTaxAmount();
	}
	
	@Override
	public String toString() 
	{
		DecimalFormat df = new DecimalFormat("$#,###,##0.00");
		String str = "\n" + charPrint('=', 125) + "\nMY TAB\n" + charPrint('=', 125) + "\n";
		for(Item item : aggregator.getMyItems())
			str += item + "\n";
		str += charPrint('-', 125) + "\n";
		str += String.format("%-109sTotal: %s\n", "", df.format(getTotal()));
		str += String.format("%-111sTax: %s\n", "", df.format(getTaxAmount()));
		str += String.format("%-109sTotal: %s\n", "", df.format(getTotalWithTax()));
		str += "\n";
		return str;
	}
	
	private String charPrint(char c, int num)
	{
		String s = "";
		for(int i = 0; i < num; i++)
			s += c;
		return s;
	}
	
}
