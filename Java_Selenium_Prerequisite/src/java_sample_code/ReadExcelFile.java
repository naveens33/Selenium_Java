package java_sample_code;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	//private static Row row;
	List<String> inflowattribute = new ArrayList();
	List<String> inflowvalue = new ArrayList();
	List<String> outflowattribute = new ArrayList();
	List<String> outlowvalue = new ArrayList();
	ReadExcelFile() throws Exception
	{
		inflowdata();
		outflowdata();
	}
	@SuppressWarnings("deprecation")
	public void inflowdata() throws Exception
	{
		File f=new File("D:\\Selenium Training\\eclipse_workspace\\demo1\\bin\\junit_demo\\Inflow_OutflowMoneyMap.xlsx");
		FileInputStream fis=new FileInputStream(f);
		@SuppressWarnings("resource")
		XSSFWorkbook xs=new XSSFWorkbook(fis);
		XSSFSheet sheet=xs.getSheetAt(0);
		//FormulaEvaluator fe=xs.getCreationHelper().createFormulaEvaluator();
		int rowcount=sheet.getPhysicalNumberOfRows();
        int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Total Number of Rows is ::"+rowcount);
        System.out.println("Total number of Col is ::"+colcount);
        for(int i=1;i<rowcount;i++){
            	String testdata=sheet.getRow(i).getCell(0).getStringCellValue();
            	inflowattribute.add(testdata);
            }
        for(int i=1;i<rowcount;i++){
        	String testdata=sheet.getRow(i).getCell(1).getStringCellValue();
        	inflowvalue.add(testdata);
        }
        xs.close();
		}
	public void outflowdata() 
	{
		
	}
	}
		