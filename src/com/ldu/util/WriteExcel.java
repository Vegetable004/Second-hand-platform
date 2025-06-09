package com.ldu.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class WriteExcel {


    private String[] rowName;

    private List<Object[]>  dataList = new ArrayList<Object[]>();


    public WriteExcel(String[] rowName,List<Object[]>  dataList){
        this.dataList = dataList;
        this.rowName = rowName;
    }


    public InputStream export() throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet1");


        HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);
        HSSFCellStyle style = this.getStyle(workbook);


        int columnNum = rowName.length;
        HSSFRow rowRowName = sheet.createRow(0);

        for(int n=0;n<columnNum;n++){
            HSSFCell cellRowName = rowRowName.createCell(n);
            cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);
            HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
            cellRowName.setCellValue(text);
            cellRowName.setCellStyle(columnTopStyle);
        }


        for(int i=0;i<dataList.size();i++){

            Object[] obj = dataList.get(i);
            HSSFRow row = sheet.createRow(i+1);
            for(int j=0; j<obj.length; j++){
                HSSFCell  cell = null;
                cell = row.createCell(j,HSSFCell.CELL_TYPE_STRING);
                if(!"".equals(obj[j]) && obj[j] != null){
                    cell.setCellValue(obj[j].toString());
                }
                cell.setCellStyle(style);
            }
        }

        for (int colNum = 0; colNum < columnNum; colNum++) {
            int columnWidth = sheet.getColumnWidth(colNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                HSSFRow currentRow;

                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }
                if (currentRow.getCell(colNum) != null) {
                    HSSFCell currentCell = currentRow.getCell(colNum);
                    if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        int length = currentCell.getStringCellValue().getBytes().length;
                        if (columnWidth < length) {
                            columnWidth = length;
                        }
                    }
                }
            }
            if(colNum == 0){
                sheet.setColumnWidth(colNum, (columnWidth-2) * 256);
            }else{
                sheet.setColumnWidth(colNum, (columnWidth+4) * 256);
            }
        }

        String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
        String headStr = "attachment; filename=\"" + fileName + "\"";

        ByteArrayOutputStream os=new ByteArrayOutputStream();
        try {
            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] content=os.toByteArray();
        InputStream is=new ByteArrayInputStream(content);
        return is;
    }


    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {


        HSSFFont font = workbook.createFont();

        font.setFontHeightInPoints((short)11);

        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        font.setFontName("Courier New");

        HSSFCellStyle style = workbook.createCellStyle();

        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);

        style.setBottomBorderColor(HSSFColor.BLACK.index);

        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);

        style.setLeftBorderColor(HSSFColor.BLACK.index);

        style.setBorderRight(HSSFCellStyle.BORDER_THIN);

        style.setRightBorderColor(HSSFColor.BLACK.index);

        style.setBorderTop(HSSFCellStyle.BORDER_THIN);

        style.setTopBorderColor(HSSFColor.BLACK.index);

        style.setFont(font);

        style.setWrapText(false);

        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }


    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {

        HSSFFont font = workbook.createFont();

        font.setFontName("Courier New");

        HSSFCellStyle style = workbook.createCellStyle();

        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);

        style.setBottomBorderColor(HSSFColor.BLACK.index);

        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);

        style.setLeftBorderColor(HSSFColor.BLACK.index);

        style.setBorderRight(HSSFCellStyle.BORDER_THIN);

        style.setRightBorderColor(HSSFColor.BLACK.index);

        style.setBorderTop(HSSFCellStyle.BORDER_THIN);

        style.setTopBorderColor(HSSFColor.BLACK.index);

        style.setFont(font);

        style.setWrapText(false);

        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }
    public static void main(String[] args) throws Exception {
        String[] rowsName = new String[]{"序号","状态","录入人","录入时间"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] obj1=new Object[4];
        obj1[0]="1";obj1[1]="ok";obj1[2]="hello";obj1[3]="wsz";
        dataList.add(obj1);
        Object[] obj2=new Object[4];
        obj2[0]="2";obj2[1]="dsa";obj2[2]="wolrd";obj2[3]="python";
        dataList.add(obj2);
        WriteExcel ex = new WriteExcel(rowsName, dataList);
        ex.export();
    }

}
