package com.kali.kali.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;;*/

public class ExcelTest {
/*

	public static void main(String[] args) throws IOException {
		prasannaProgram();
	}

	public static void prasannaProgram() throws IOException {

		String excelFilePath = "C:/Users/mahan.k.palavelli/Desktop/prasanna/Auto_template2.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(excelFilePath);
		Sheet firstSheet = workbook.getSheetAt(2);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() != 0) {
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					cell.getColumnIndex();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						actualMethod(cell.getStringCellValue(), cell.getColumnIndex());
						// System.out.print(cell.getStringCellValue());
						break;
					*/
/*
					 * case Cell.CELL_TYPE_BOOLEAN:
					 * System.out.print(cell.getBooleanCellValue()); break;
					 *//*

					*/
/*
					 * case Cell.CELL_TYPE_NUMERIC:
					 * System.out.print(cell.getNumericCellValue()); break;
					 *//*

					}
					// System.out.print(" - ");
				}
				// System.out.println();
			}
		}
		inputStream.close();

	}

	private static void actualMethod(String str, int columnIndex) {}
*/
}
