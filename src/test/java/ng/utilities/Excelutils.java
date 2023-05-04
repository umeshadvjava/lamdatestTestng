package ng.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Excelutils {

    public static void main(String[] args) throws IOException {

        String [][] data = getData("E:\\Chintu\\Study\\Framework\\project\\lamdatestTestng\\src\\test\\resources\\testdata\\DataProvider1.xlsx","Sheet1");
        List<List<String>> list = Arrays.stream(data).map(Arrays::asList).collect(Collectors.toList());
        list.stream().forEach(s-> System.out.println(s));
      //  printData();
    }

      public static String [][] getData(String filePath, String sheetName) throws IOException {
        String data[][]=null;
        DataFormatter formatter = new DataFormatter();
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
        XSSFSheet sh = xssfWorkbook.getSheet(sheetName);
        int rowCount = sh.getPhysicalNumberOfRows();
        Row row = sh.getRow(0);
        int colCount = row.getLastCellNum();
        data = new String[rowCount-1][colCount];
        for (int i = 0; i <rowCount-1 ; i++) {
              Row row1 = sh.getRow(i+1);
            for (int j = 0; j<colCount ; j++) {
                data[i][j] = formatter.formatCellValue(row1.getCell(j));
            }
        }

        return  data;
    }
}
