package com.advaita.Utilities;




import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtils(String filePath, String sheetName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, List<String>> getAllColumnData() {
        Map<String, List<String>> columnData = new HashMap<>();
        if (sheet == null) {
            System.out.println("Sheet is null. Cannot read data.");
            return columnData;
        }

        int maxCols = getMaxColumns();

        DataFormatter formatter = new DataFormatter();

        for (int col = 0; col < maxCols; col++) {
            Cell headerCell = sheet.getRow(0).getCell(col, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String header = formatter.formatCellValue(headerCell);

            List<String> columnValues = new ArrayList<>();
            int maxRows = getMaxRowsForColumn(col);
            for (int row = 1; row <maxRows; row++) {
                Row dataRow = sheet.getRow(row);
                if (dataRow == null) {
                    columnValues.add(""); // Add empty string for null rows
                } else {
                    Cell cell = dataRow.getCell(col, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String cellData = formatter.formatCellValue(cell).trim(); // Trim cell data
                    if (!cellData.isEmpty()) {
                        columnValues.add(cellData); // Add non-empty cell data
                    }
                }
            }

            columnData.put(header, columnValues);
        }

        return columnData;
    }

    private int getMaxRowsForColumn(int col) {
        int maxRows = 0;
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int row = 0; row < rowCount; row++) {
            Row dataRow = sheet.getRow(row);
            if (dataRow != null) {
                int lastCell = dataRow.getLastCellNum();
                if (col < lastCell) {
                    maxRows = Math.max(maxRows, row + 1);
                }
            }
        }
        return maxRows;
    }

    private int getMaxColumns() {
        int maxCols = 0;
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int r = 0; r < rowCount; r++) {
            int lastColumn = sheet.getRow(r).getLastCellNum();
            if (lastColumn > maxCols) {
                maxCols = lastColumn;
            }
        }
        return maxCols;
    }

    public List<String> getColumnDataByName(String columnName) {
        Map<String, List<String>> columnData = getAllColumnData();
        return columnData.getOrDefault(columnName, new ArrayList<>());
    }
}
