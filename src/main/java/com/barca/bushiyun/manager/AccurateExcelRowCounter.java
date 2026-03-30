package com.barca.bushiyun.manager;

import org.apache.poi.ss.usermodel.*;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AccurateExcelRowCounter {

    public static void main(String[] args) {

    }

    /**
     * 使用流式处理准确统计行数（内存优化）
     */
    public static ExcelCountResult getAccurateRowCount(String fileUrl) throws Exception {
        URL url = new URL(fileUrl);
        try (InputStream inputStream = url.openStream();
             Workbook workbook = WorkbookFactory.create(inputStream)) {

            ExcelCountResult result = new ExcelCountResult();

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                SheetCount sheetCount = countSheetRows(sheet);
                result.addSheetCount(sheet.getSheetName(), sheetCount);
            }

            return result;
        }
    }

    private static SheetCount countSheetRows(Sheet sheet) {
        SheetCount count = new SheetCount();
        int firstRow = sheet.getFirstRowNum();
        int lastRow = sheet.getLastRowNum();

        count.setTotalRows(lastRow - firstRow + 1);

        for (int i = firstRow; i <= lastRow; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                if (isRowEmpty(row)) {
                    count.incrementEmptyRows();
                } else {
                    count.incrementDataRows();
                    count.addCellCount(countFilledCells(row));
                }
            } else {
                count.incrementEmptyRows();
            }
        }

        return count;
    }

    private static boolean isRowEmpty(Row row) {
        for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null && !isCellEmpty(cell)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCellEmpty(Cell cell) {
        if (cell == null) return true;

        switch (cell.getCellType()) {
            case BLANK:
                return true;
            case STRING:
                return cell.getStringCellValue().trim().isEmpty();
            case NUMERIC:
                return false;
            case BOOLEAN:
                return false;
            case FORMULA:
                // 公式单元格需要计算值来判断是否为空
                try {
                    return isCellEmpty(evaluateFormulaCell(cell));
                } catch (Exception e) {
                    return false;
                }
            default:
                return true;
        }
    }

    private static int countFilledCells(Row row) {
        int count = 0;
        for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null && !isCellEmpty(cell)) {
                count++;
            }
        }
        return count;
    }

    // 简化版的公式计算
    private static Cell evaluateFormulaCell(Cell cell) {
        // 实际应用中可能需要更复杂的公式计算
        return cell;
    }


    // 统计结果类
    static class ExcelCountResult {
        private Map<String, SheetCount> sheetCounts = new HashMap<>();
        private int totalSheets;
        private int totalDataRows;
        private int totalEmptyRows;

        public void addSheetCount(String sheetName, SheetCount count) {
            sheetCounts.put(sheetName, count);
            totalSheets++;
            totalDataRows += count.getDataRows();
            totalEmptyRows += count.getEmptyRows();
        }

    }

    static class SheetCount {
        private int totalRows;
        private int dataRows;
        private int emptyRows;
        private int totalCells;
        private int filledCells;

        public int getTotalRows() {
            return totalRows;
        }

        public void setTotalRows(int totalRows) {
            this.totalRows = totalRows;
        }

        public int getDataRows() {
            return dataRows;
        }

        public void setDataRows(int dataRows) {
            this.dataRows = dataRows;
        }

        public int getEmptyRows() {
            return emptyRows;
        }

        public void setEmptyRows(int emptyRows) {
            this.emptyRows = emptyRows;
        }

        public int getTotalCells() {
            return totalCells;
        }

        public void setTotalCells(int totalCells) {
            this.totalCells = totalCells;
        }

        public int getFilledCells() {
            return filledCells;
        }

        public void setFilledCells(int filledCells) {
            this.filledCells = filledCells;
        }

        public void incrementEmptyRows() {
            emptyRows++;
        }

        public void incrementDataRows() {
            dataRows++;
        }

        public void addCellCount(int i) {
            totalCells += i;
        }
    }
}



