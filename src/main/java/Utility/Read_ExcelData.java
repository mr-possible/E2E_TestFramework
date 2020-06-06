package Utility;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class Read_ExcelData {
    private String path = null;
    private FileInputStream fis = null;
    private FileOutputStream fileOut = null;
    private String fileLocation;
    private XSSFWorkbook workbook;
    private XSSFSheet worksheet;
    private XSSFRow row = null;
    private XSSFCell cell = null;
    private ArrayList<String> dataSet;

    public Read_ExcelData(String fileLocation) {
        this.fileLocation = fileLocation;
        try {
            fis = new FileInputStream(fileLocation);
            workbook = new XSSFWorkbook(fis);
            worksheet = workbook.getSheetAt(0);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // returns the data from a cell
    public String getCellData(String sheetName, String colName, int rowNum) {
        try {
            if (rowNum <= 0)
                return "";

            int index = workbook.getSheetIndex(sheetName);
            int col_Num = -1;
            if (index == -1)
                return "";

            worksheet = workbook.getSheetAt(index);
            row = worksheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                // System.out.println(row.getCell(i).getStringCellValue().trim());
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
            }
            if (col_Num == -1)
                return "";

            worksheet = workbook.getSheetAt(index);
            row = worksheet.getRow(rowNum - 1);
            if (row == null)
                return "";
            cell = row.getCell(col_Num);

            if (cell == null)
                return "";

            if (cell.getCellType().name().equals("STRING"))
                return cell.getStringCellValue();

            else if ((cell.getCellType().name().equals("NUMERIC")) || (cell.getCellType().name().equals("FORMULA"))) {

                String cellText = String.valueOf(cell.getNumericCellValue());
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // format in form of M/D/YY
                    double d = cell.getNumericCellValue();

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(HSSFDateUtil.getJavaDate(d));
                    cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
                }

                return cellText;
            } else if (cell.getCellType().BLANK != null)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        } catch (Exception e) {
            e.printStackTrace();
            return "row " + rowNum + " or column " + colName + " does not exist in xls";
        }
    }

    // returns true if data is set successfully else false
    public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            if (rowNum <= 0)
                return false;

            int index = workbook.getSheetIndex(sheetName);
            int colNum = -1;
            if (index == -1)
                return false;

            worksheet = workbook.getSheetAt(index);

            row = worksheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                // System.out.println(row.getCell(i).getStringCellValue().trim());
                if (row.getCell(i).getStringCellValue().trim().equals(colName))
                    colNum = i;
            }
            if (colNum == -1)
                return false;

            worksheet.autoSizeColumn(colNum);
            row = worksheet.getRow(rowNum - 1);
            if (row == null)
                row = worksheet.createRow(rowNum - 1);

            cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);


            cell.setCellValue(data);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // find whether sheets exists
    public boolean doesSheetExists(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            index = workbook.getSheetIndex(sheetName.toUpperCase());
            if (index == -1)
                return false;
            else
                return true;
        } else
            return true;
    }

    public int returnNumberOfSheets() throws IOException {
        int countOfSheets = workbook.getNumberOfSheets();
        return countOfSheets;
    }

    public int returnNumberOfRows(String sheetName) {
        // returns the row count in a sheet
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1)
            return 0;
        else {
            worksheet = workbook.getSheetAt(index);
            int number = worksheet.getLastRowNum() + 1;
            return number;

        }
    }

    public int returnNumberOfColumns(String sheetName) {
        // check if sheet exists
        if (!doesSheetExists(sheetName))
            return -1;
        worksheet = workbook.getSheet(sheetName);
        row = worksheet.getRow(0);

        if (row == null)
            return -1;

        return row.getLastCellNum();
    }

    public String WriteStatusIntoColumn(String filePath, String rowName, String colName, String result) {
        //This function will write Pass/Fail/Skip as per the result of the execution.

        return null;
    }


}