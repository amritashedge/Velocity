package Utility;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterization 
{
	public static String getData(int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream
		("C:\\Automation\\KiteZerodha\\src\\test\\resources\\ZerodhaLoginCredientials.xlsx");
		String value=WorkbookFactory.create(file)
				.getSheet("Zerodha").getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}

}
