package util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFile {

    public void ReadExcelFile() {

    }

    public void readExcel(String filePath, String nombreHoja) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkBook.getSheet(nombreHoja);

        int cantFila = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
        for (int i = 0; i < cantFila; i++) {
            XSSFRow fila = newSheet.getRow(i);
            for (int j = 0; j < fila.getLastCellNum(); j++) {
                System.out.println(fila.getCell(j).getStringCellValue() + "**");
            }
        }
    }

    public String readCellValue(String filePath, String nombreHoja, int fila, int columna) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkBook.getSheet(nombreHoja);

        XSSFRow row = newSheet.getRow(fila);
        XSSFCell cell = row.getCell(columna);
        String value = cell.getStringCellValue();
        return value;
    }
}
