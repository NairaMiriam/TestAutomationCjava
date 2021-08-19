package util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelFile {

    public void WriteExcelFile() {

    }

    public void writeCellValue(String filePath, String hoja, int fila, int celda, String textoGuardar) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet= workbook.getSheet(hoja);

        XSSFRow newFila=sheet.getRow(fila);

        XSSFCell celdaSiguient=newFila.createCell(celda);
        celdaSiguient.setCellValue(textoGuardar);

        inputStream.close();
        FileOutputStream outputStream= new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();
    }
}
