package org.advancedautomation.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtils {

	public static int totalRow;

	public List<Map<String, String>> getValues(String filePath, String sheetName)
			throws InvalidFormatException, IOException {
		Workbook workbook = WorkbookFactory.create(new File(filePath));
		Sheet sheet = workbook.getSheet(sheetName);
		// workbook.close();
		return readDataSheet(sheet);

	}

	private List<Map<String, String>> readDataSheet(Sheet sheet) {
		Row row;
		Cell cell;
		totalRow = sheet.getLastRowNum();
		List<Map<String, String>> getRowValue = new ArrayList<Map<String, String>>();
		for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
			row = sheet.getRow(currentRow);
			int totalColumn = row.getLastCellNum();
			LinkedHashMap<String, String> columnData = new LinkedHashMap<String, String>();
			for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {

				cell = row.getCell(currentColumn);
				String columnHeader = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
				columnData.put(columnHeader, cell.getStringCellValue());
			}
			getRowValue.add(columnData);
		}
		return getRowValue;

	}

	public int countRow() {
		return totalRow;
	}

}
