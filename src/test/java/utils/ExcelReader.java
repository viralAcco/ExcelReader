package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

//import org.junit.jupiter.params.provider.Arguments;

public class ExcelReader {
  public static final String FILE_PATH = "C:\\GradProgram\\GradleSession\\excel-reader-master\\src\\test\\resources\\excel-filer\\testdata.xlsx";

  public static void main(String[] args) throws IOException, InvalidFormatException {

    // Creating a Workbook from an Excel file (.xls or .xlsx)
    Workbook workbook = WorkbookFactory.create(new File(FILE_PATH));

    // Retrieving the number of sheets in the Workbook
    System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
    Iterator<Sheet> sheetIterator = workbook.sheetIterator();
    System.out.println("Retrieving Sheets using Iterator");
    while (sheetIterator.hasNext()) {
      Sheet sheet = sheetIterator.next();
      System.out.println("=> " + sheet.getSheetName());
    }
    Sheet sheet = workbook.getSheetAt(0);

    // Create a DataFormatter to format and get each cell's value as String
    DataFormatter dataFormatter = new DataFormatter();

    System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
    for (Row row: sheet) {
      for(Cell cell: row) {
        String cellValue = dataFormatter.formatCellValue(cell);
        System.out.print(cellValue + "\t");
      }
      System.out.println();
    }
    workbook.close();
  }
}