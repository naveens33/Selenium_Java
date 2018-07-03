package testng;
import org.automationtesting.excelreport.Xl;

public class GenerateReport {

	public static void main (String arg[]) throws Exception {
		Xl.generateReport("excel-report.xlsx");
	}

}
