package com.advaita.Utilities;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

    // Method to find the column index based on the column header name
    private static int getColumnIndex(Sheet sheet, String columnName) {
        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                return cell.getColumnIndex();
            }
        }
        return -1;
    }

    // Method to find the last row in a column
    private static int findLastRow(Sheet sheet, int columnIndex) {
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell cell = row.getCell(columnIndex);
                if (cell == null || cell.getCellType() == CellType.BLANK) {
                    return i;
                }
            }
        }
        return lastRowNum + 1;
    }

    // Method to update Excel with data based on headers in a specific sheet
    public static void updateExcelWithData(Map<String, List<String>> map, String filePath, String sheetName) {
        try (FileInputStream fileIn = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileIn)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.out.println("Sheet not found: " + sheetName);
                return;
            }

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String columnName = entry.getKey();
                List<String> values = entry.getValue();

                int columnIndex = getColumnIndex(sheet, columnName);
                if (columnIndex == -1) {
                    System.out.println("Column not found: " + columnName);
                    continue;
                }

                int startRow = findLastRow(sheet, columnIndex);

                for (int i = 0; i < values.size(); i++) {
                    Row row = sheet.getRow(startRow + i);
                    if (row == null) {
                        row = sheet.createRow(startRow + i);
                    }
                    Cell cell = row.getCell(columnIndex);
                    if (cell == null) {
                        cell = row.createCell(columnIndex);
                    }
                    cell.setCellValue(values.get(i));
                }
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> data = Map.of(
            "User Accounts", List.of("User1", "User2", "User3"),
            "Roles", List.of("Admin", "User", "Guest")
        );
        updateExcelWithData(data, "C:\\Users\\W2390\\git\\Advaita\\Advaita_TDD\\ExcelFiles\\Write.xlsx", "Sheet1");
    }
    
    
    
}
