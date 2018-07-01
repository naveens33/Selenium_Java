package testng;
import org.automationtesting.excelreport.Xl;

public class GenerateReport {

	public static void funGenerateReport() throws Exception {
		Xl.generateReport("excel-report.xlsx");
	}

}
