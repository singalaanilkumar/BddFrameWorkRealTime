package FileComparsion;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelToTextConvertAndComparsion {
    public static final String EXCEL_FILE_PATH = "C:\\Users\\as61837\\Documents\\GitHub\\BddWithEform\\document.xlsx";
    public static final String TEXT_fILE = "TextConvertedFromExcel.txt";
    static String excel = " ";
    static String text = " ";

    public static void ExcelToText(String excelFIle, String TEXT_fILE) throws IOException {
        try {
            FileInputStream file = new FileInputStream(new File(excelFIle));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            FileWriter output = new FileWriter(new File(TEXT_fILE));
            for (Row row : sheet) {
                for (Cell cell : row) {
                    output.write(cell.toString() + "\t");
                }
                output.write("\n");
            }
            output.close();
            workbook.close();
            System.out.println("Excel to text file conversion successfully completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void TextToExcelConverter(String textfile, String excelFile) throws IOException {
        // Read the text file
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(textfile), "UTF-8"));
        String line;
        List<String[]> data = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] row = line.split("\t");
            data.add(row);
        }
        reader.close();

        // Create a new Excel workbook
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        // Populate the Excel sheet with the data
        int rowIndex = 0;
        for (String[] rowData : data) {
            Row row = sheet.createRow(rowIndex++);
            int cellIndex = 0;
            for (String cellData : rowData) {
                Cell cell = row.createCell(cellIndex++);
                cell.setCellValue(cellData);
            }
        }

        // Write the workbook to an Excel file
        FileOutputStream outputStream = new FileOutputStream(excelFile);
        workbook.write(outputStream);
        System.out.println("text file to excel file conversion successfully completed");
        workbook.close();
        outputStream.close();
    }

    public static void CompareFile(String excelFIle, String textFile) throws IOException {

// Define the delimiter to use in the output file
        String delimiter = "|"; // Use pipeline as delimiter

        XSSFWorkbook workbook = null;
        try {
// Open the Excel file for reading
            FileInputStream inputWorkbook = new FileInputStream(excelFIle);


// Load the Excel file into a workbook object
            workbook = new XSSFWorkbook(inputWorkbook);

// Get the first worksheet in the workbook
            XSSFSheet worksheet = workbook.getSheetAt(0);

// Create a writer object to write to the output file
            BufferedWriter writer = new BufferedWriter(new FileWriter(textFile));

// Loop through each row in the worksheet
            for (int i = 0; i < worksheet.getPhysicalNumberOfRows(); i++) {

                XSSFRow row = worksheet.getRow(i);

// Loop through each cell in the row and write its value to the output file
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    XSSFCell cell = row.getCell(j);
                    String cellValue = "";

// Check the cell type and get its value
                    if (cell.getCellType() == CellType.NUMERIC) {
                        cellValue = String.valueOf(cell.getNumericCellValue());


                    } else if (cell.getCellType() == CellType.STRING) {
                        cellValue = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                        cellValue = String.valueOf(cell.getBooleanCellValue());
                    }
                    excel = excel + cellValue;

// Write the cell value to the output file, followed by the delimiter
                    writer.write(cellValue);
                    text = text + cellValue;
                    writer.write(delimiter);

                }
                excel = excel.replaceAll("\\s", "");
                text = text.replaceAll("\\s", "");
                if (excel.equalsIgnoreCase(text)) {
                    Cell cell = row.createCell(6);
                    cell.setCellValue("PASS");

                } else {
                    System.out.println(excel);
                    System.out.println(text);
                    Cell cell = row.createCell(row.getPhysicalNumberOfCells() + 1);
                    cell.setCellValue("Fail");
                }
// Write a newline character to separate rows in the output file
                writer.newLine();
                excel = " ";
                text = "";
            }
            if (writer != null || inputWorkbook != null) {
                writer.close();
                inputWorkbook.close();
            }

            System.out.println("ExcelFile And TextFile Compared The Data");


        } catch (IOException e) {
            e.printStackTrace();
        }


        FileOutputStream outputStream = new FileOutputStream(new File("ComparedDataExcel.xlsx"));

//write data in the excel file
        workbook.write(outputStream);

//close output stream
        outputStream.close();


    }
}
