package com.MiscellaneousTasks;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class CovidData {
    String date;
    String state;
    Integer positive;
    Integer negative;
    String pending;
    Integer hospitalizedCurrently;
    Integer hospitalizedCumulative;
    Integer inIcuCurrently;
    Integer inIcuCumulative;
    Integer onVentilatorCurrently;
    Integer onVentilatorCumulative;
    Integer recovered;
    String hash;
    String dateChecked;
    Integer death;
    Integer hospitalized;
    Integer total;
    Integer totalTestResults;
    Integer posNeg;
    String fips;
    Integer deathIncrease;
    Integer hospitalizedIncrease;
    Integer negativeIncrease;
    Integer positiveIncrease;
    Integer totalTestResultsIncrease;
}

public class CovidExcelConversion {

    public static void main(String[] args) throws IOException, ParseException {
        File file = new File("src/com/RandomTasks/Covid.txt");
        Scanner sc = new Scanner(file);
        String txt = sc.nextLine();
        Gson gson = new Gson();
        List<CovidData> data = gson.fromJson(txt, new TypeToken<List<CovidData>>(){}.getType());

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet1");// creating a blank sheet
        int rowNum = 0;
        addHeaderColumns(sheet.createRow(rowNum++));
        for (CovidData covidData :  data) {
            XSSFRow row = sheet.createRow(rowNum++);
            addDataToRow(covidData, row);
        }
        FileOutputStream out = new FileOutputStream(new File("CovidData.xlsx")); // file name with path
        workbook.write(out);
        out.close();
    }

    private static void addHeaderColumns(XSSFRow row) {
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("date");
        cell = row.createCell(1);
        cell.setCellValue("state");
        cell = row.createCell(2);
        cell.setCellValue("positive");
        cell = row.createCell(3);
        cell.setCellValue("negative");
        cell = row.createCell(4);
        cell.setCellValue("pending");
        cell = row.createCell(5);
        cell.setCellValue("hospitalizedCurrently");
        cell = row.createCell(6);
        cell.setCellValue("hospitalizedCumulative");
        cell = row.createCell(7);
        cell.setCellValue("inIcuCurrently");
        cell = row.createCell(8);
        cell.setCellValue("inIcuCumulative");
        cell = row.createCell(9);
        cell.setCellValue("onVentilatorCurrently");
        cell = row.createCell(10);
        cell.setCellValue("onVentilatorCumulative");
        cell = row.createCell(11);
        cell.setCellValue("recovered");
        cell = row.createCell(12);
        cell.setCellValue("hash");
        cell = row.createCell(13);
        cell.setCellValue("dateChecked");
        cell = row.createCell(14);
        cell.setCellValue("death");
        cell = row.createCell(15);
        cell.setCellValue("hospitalized");
        cell = row.createCell(16);
        cell.setCellValue("total");
        cell = row.createCell(17);
        cell.setCellValue("totalTestResults");
        cell = row.createCell(18);
        cell.setCellValue("posNeg");
        cell = row.createCell(19);
        cell.setCellValue("fips");
        cell = row.createCell(20);
        cell.setCellValue("deathIncrease");
        cell = row.createCell(21);
        cell.setCellValue("hospitalizedIncrease");
        cell = row.createCell(22);
        cell.setCellValue("negativeIncrease");
        cell = row.createCell(23);
        cell.setCellValue("positiveIncrease");
        cell = row.createCell(24);
        cell.setCellValue("totalTestResultsIncrease");
    }

    private static void addDataToRow(CovidData covidData, XSSFRow row) throws ParseException {
        XSSFCell cell = row.createCell(0);
        if (covidData.date != null) {
            Date date = new SimpleDateFormat("yyyyMMdd").parse(covidData.date);
            cell.setCellValue(date);
        }
        cell = row.createCell(1);
        if (covidData.state != null) {
            cell.setCellValue(covidData.state);
        }
        cell = row.createCell(2);
        if (covidData.positive != null) {
            cell.setCellValue(covidData.positive);
        }
        cell = row.createCell(3);
        if (covidData.negative != null) {
            cell.setCellValue(covidData.negative);
        }
        cell = row.createCell(4);
        if (covidData.pending != null) {
            cell.setCellValue(covidData.pending);
        }
        cell = row.createCell(5);
        if (covidData.hospitalizedCurrently != null) {
            cell.setCellValue(covidData.hospitalizedCurrently);
        }
        cell = row.createCell(6);
        if (covidData.hospitalizedCumulative != null) {
            cell.setCellValue(covidData.hospitalizedCumulative);
        }
        cell = row.createCell(7);
        if (covidData.inIcuCurrently != null) {
            cell.setCellValue(covidData.inIcuCurrently);
        }
        cell = row.createCell(8);
        if (covidData.inIcuCumulative != null) {
            cell.setCellValue(covidData.inIcuCumulative);
        }
        cell = row.createCell(9);
        if (covidData.onVentilatorCurrently != null) {
            cell.setCellValue(covidData.onVentilatorCurrently);
        }
        cell = row.createCell(10);
        if (covidData.onVentilatorCumulative != null) {
            cell.setCellValue(covidData.onVentilatorCumulative);
        }
        cell = row.createCell(11);
        if (covidData.recovered != null) {
            cell.setCellValue(covidData.recovered);
        }
        cell = row.createCell(12);
        if (covidData.hash != null) {
            cell.setCellValue(covidData.hash);
        }
        cell = row.createCell(13);
        if (covidData.dateChecked != null) {
            cell.setCellValue(covidData.dateChecked);
        }
        cell = row.createCell(14);
        if (covidData.death != null) {
            cell.setCellValue(covidData.death);
        }
        cell = row.createCell(15);
        if (covidData.hospitalized != null) {
            cell.setCellValue(covidData.hospitalized);
        }
        cell = row.createCell(16);
        if (covidData.total != null) {
            cell.setCellValue(covidData.total);
        }
        cell = row.createCell(17);
        if (covidData.totalTestResults != null) {
            cell.setCellValue(covidData.totalTestResults);
        }
        cell = row.createCell(18);
        if (covidData.posNeg != null) {
            cell.setCellValue(covidData.posNeg);
        }
        cell = row.createCell(19);
        if (covidData.fips != null) {
            cell.setCellValue(covidData.fips);
        }
        cell = row.createCell(20);
        if (covidData.deathIncrease != null) {
            cell.setCellValue(covidData.deathIncrease);
        }
        cell = row.createCell(21);
        if (covidData.hospitalizedIncrease != null) {
            cell.setCellValue(covidData.hospitalizedIncrease);
        }
        cell = row.createCell(22);
        if (covidData.negativeIncrease != null) {
            cell.setCellValue(covidData.negativeIncrease);
        }
        cell = row.createCell(23);
        if (covidData.positiveIncrease != null) {
            cell.setCellValue(covidData.positiveIncrease);
        }
        cell = row.createCell(24);
        if (covidData.totalTestResultsIncrease != null) {
            cell.setCellValue(covidData.totalTestResultsIncrease);
        }
    }

}
