package com.advaita.Utilities;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class ExcelUserManagement {
    private static final String FILE_PATH = System.getProperty("user.dir")+"\\ExcelFiles\\UserManagementData.xlsx";
    private static Workbook workbook;
    private static Sheet userSheet;
    private static Sheet roleSheet;

    public ExcelUserManagement() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                workbook = new XSSFWorkbook();
                userSheet = workbook.createSheet("UserAccounts");
                roleSheet = workbook.createSheet("UserRoles");
                createHeader(userSheet, "User Accounts");
                createHeader(roleSheet, "User Roles");
                saveWorkbook();
            } else {
                FileInputStream fis = new FileInputStream(FILE_PATH);
                workbook = new XSSFWorkbook(fis);
                userSheet = workbook.getSheet("UserAccounts");
                roleSheet = workbook.getSheet("UserRoles");
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createHeader(Sheet sheet, String headerName) {
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue(headerName);
    }

    public void addUserAccount(String userAccount) {
        int rowCount = userSheet.getLastRowNum();
        Row row = userSheet.createRow(rowCount + 1);
        row.createCell(0).setCellValue(userAccount);
        saveWorkbook();
    }

    public void addUserRole(String userRole) {
        int rowCount = roleSheet.getLastRowNum();
        Row row = roleSheet.createRow(rowCount + 1);
        row.createCell(0).setCellValue(userRole);
        saveWorkbook();
    }

    public List<String> readUserAccounts() {
        List<String> userAccounts = new ArrayList<>();
        for (int i = 1; i <= userSheet.getLastRowNum(); i++) {
            Row row = userSheet.getRow(i);
            userAccounts.add(row.getCell(0).getStringCellValue());
        }
        return userAccounts;
    }

    public List<String> readUserRoles() {
        List<String> userRoles = new ArrayList<>();
        for (int i = 1; i <= roleSheet.getLastRowNum(); i++) {
            Row row = roleSheet.getRow(i);
            userRoles.add(row.getCell(0).getStringCellValue());
        }
        return userRoles;
    }

    public void removeUserAccount(String userAccount) {
        removeRow(userSheet, userAccount);
    }

    public void removeUserRole(String userRole) {
        removeRow(roleSheet, userRole);
    }

    private void removeRow(Sheet sheet, String value) {
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row.getCell(0).getStringCellValue().equals(value)) {
                sheet.removeRow(row);
                saveWorkbook();
                return;
            }
        }
    }

    private void saveWorkbook() {
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            workbook.write(fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
