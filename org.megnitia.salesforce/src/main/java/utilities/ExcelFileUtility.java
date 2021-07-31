package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//Excel other name is SS means Spread Sheet
//Access data from Existing Excel File
public class ExcelFileUtility 
{
	//properties should be private
	private File f;
	private FileInputStream fi;
	private Workbook wb;
	private FileOutputStream fo;
	private Sheet sh;
	//constructor method should be public
	public ExcelFileUtility(String filepath) throws Exception
	{
		 f = new File(filepath);//convert path as file
		 fi = new FileInputStream(f);//read permission
		 wb = WorkbookFactory.create(fi);//read permission as workbook
		 fo = new FileOutputStream(f);//write permission
	}
	//operational methods should be public
	//get Sheet name from Workbook(wb) and it will return sheet object
	public void openSheet(String sheetname)
	{
		sh = wb.getSheet(sheetname);//return sheet object
	}
	//get total rows count in that sheet
	public int getRowsCount()
	{
		int nor = sh.getPhysicalNumberOfRows();//it will give number of rows
		return(nor);//need to return number of rows
	}
	//get number of columns
	//in which row you want to get no.of columns
	public int getColumnsCount(int rowindex)
	{
		int noc = sh.getRow(rowindex).getLastCellNum();//it will return no.of columns 
		return(noc);//need to return no.of columns 
	}
	//create column in first row  ans set column name as with today date and time
	public void createResultColumn(int celindex)
	{
		SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt = new Date();
		//create result column in first row by default with given cell index
		Cell rc = sh.getRow(0).createCell(celindex);//cell created
		//set cell name as a date and time in given format
		rc.setCellValue(sf.format(dt));//date and time is coming as column name
	}
	//get cell value
	public String getCellValue(int rowindex,int colindex)
	{
		DataFormatter df = new DataFormatter();
		//in poi DataFormatter class will take any type of data in Excel file it will take as a string
		//for this purpose using DataFormatter class
		String value = df.formatCellValue(sh.getRow(rowindex).getCell(colindex));
		return(value);
	}
	//set cell valu
	public void setCellValue(int rowindex,int colindex,String value)
	{
		Cell c = sh.getRow(rowindex).createCell(colindex);
		c.setCellValue(value);
		sh.autoSizeColumn(colindex);//for auto-fit
		
	}
	//save and close Excel
	public void saveAndCloseExcel() throws Exception
	{
		wb.write(fo);//save workbook(fo means write permission)
		wb.close();//close workbook
		fo.close();//close write permission
		fi.close();//close read permission
	}

}
