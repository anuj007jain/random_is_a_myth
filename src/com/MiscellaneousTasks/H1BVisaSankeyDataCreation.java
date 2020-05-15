package com.MiscellaneousTasks;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class H1BVisaSankeyDataCreation {

    static Map<StateCompanyYear, Integer> stateCompanyYearCount = new HashMap();
    static Map<CompanyIncomeYear, Integer> companyIncomeYearCount = new HashMap<>();

    static class StateCompanyYear {

        String state;
        String company;
        String year;

        public StateCompanyYear(String state, String company, String year) {
            this.state = state;
            this.company = company;
            this.year = year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StateCompanyYear that = (StateCompanyYear) o;
            return Objects.equals(state, that.state) &&
                    Objects.equals(company, that.company) &&
                    Objects.equals(year, that.year);
        }

        @Override
        public int hashCode() {
            return Objects.hash(state, company, year);
        }
    }

    static class CompanyIncomeYear {

        String company;
        String income;
        String year;

        public CompanyIncomeYear(String company, String income, String year) {
            this.company = company;
            this.income = income;
            this.year = year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CompanyIncomeYear that = (CompanyIncomeYear) o;
            return Objects.equals(company, that.company) &&
                    Objects.equals(income, that.income) &&
                    Objects.equals(year, that.year);
        }

        @Override
        public int hashCode() {
            return Objects.hash(company, income, year);
        }
    }

    public static void main(String[] args) throws IOException {

        String csvFile = "src/com/RandomTasks/h1b_kaggle.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        br = new BufferedReader(new FileReader(csvFile));
        br.readLine();

        List<String> states = Arrays.asList("WASHINGTON", "TEXAS", "CALIFORNIA", "GEORGIA", "ILLINOIS", "NEW YORK");
        List<String> companies = Arrays.asList("INFOSYS LIMITED", "TATA CONSULTANCY SERVICES LIMITED", "WIPRO LIMITED",
                "DELOITTE CONSULTING LLP", "MICROSOFT CORPORATION", "APPLE INC.", "GOOGLE INC.", "AMAZON CORPORATE LLC",
                "FACEBOOK, INC.");
        List<String> years = Arrays.asList("2011", "2012", "2013", "2014", "2015", "2016");
        List<String> incomeRanges = Arrays.asList(">120K", ">100K and <120K", ">80K and <100K", ">60K and <80K", "<60K");

        for (String company : companies) {
            for (String year : years) {
                for (String state: states) {
                    stateCompanyYearCount.put(new StateCompanyYear(state, company, year), 0);
                }
                for (String incomeRange : incomeRanges) {
                    companyIncomeYearCount.put(new CompanyIncomeYear(company, incomeRange, year), 0);
                }
            }
        }

        while ((line = br.readLine()) != null) {
            // use comma as separator
            String[] data = line.split("\"");
//            System.out.println(data.length);
            if (data.length != 15) {
                System.out.println(Arrays.asList(data));
                continue;
            }
            String state = data[13].split(",")[1].trim();
            if (!states.contains(state)) {
                continue;
            }
            String company = data[5];
            if (!companies.contains(company)) {
                continue;
            }
            if (data[12].split(",")[1].equals("NA")) {
                continue;
            }
            String income = getIncome(Double.parseDouble(data[12].split(",")[1]));
            String year = data[12].split(",")[2];
//            System.out.println(state+" "+company+" "+income);
            if (stateCompanyYearCount.get(new StateCompanyYear(state, company, year)) ==  null) {
                stateCompanyYearCount.put(new StateCompanyYear(state, company, year), 1);
            } else {
                stateCompanyYearCount.put(new StateCompanyYear(state, company, year), stateCompanyYearCount.get(new StateCompanyYear(state, company, year)) + 1);
            }
            if (companyIncomeYearCount.get(new CompanyIncomeYear(company, income, year)) ==  null) {
                companyIncomeYearCount.put(new CompanyIncomeYear(company, income, year), 1);
            } else {
                companyIncomeYearCount.put(new CompanyIncomeYear(company, income, year), companyIncomeYearCount.get(new CompanyIncomeYear(company, income, year)) + 1);
            }
        }

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet1");// creating a blank sheet
        int rowNum = 0;
        addHeaderColumnsSheet1(sheet.createRow(rowNum++));
        for (StateCompanyYear cc :  stateCompanyYearCount.keySet()) {
            XSSFRow row = sheet.createRow(rowNum++);
            addDataToRowSheet1(cc, row);
        }
        sheet = workbook.createSheet("sheet2");// creating a blank sheet
        rowNum = 0;
        addHeaderColumnsSheet2(sheet.createRow(rowNum++));
        for (CompanyIncomeYear ci :  companyIncomeYearCount.keySet()) {
            XSSFRow row = sheet.createRow(rowNum++);
            addDataToRowSheet2(ci, row);
        }
        FileOutputStream out = new FileOutputStream(new File("H1B_Data_State.xlsx")); // file name with path
        workbook.write(out);
        out.close();
    }

    private static void addDataToRowSheet1(StateCompanyYear cc, XSSFRow row) {
        XSSFCell cell = row.createCell(0);
        cell.setCellValue(cc.state);
        cell = row.createCell(1);
        cell.setCellValue(cc.company);
        cell = row.createCell(2);
        cell.setCellValue(cc.year);
        cell = row.createCell(3);
        cell.setCellValue(stateCompanyYearCount.get(cc));
    }

    private static void addDataToRowSheet2(CompanyIncomeYear ci, XSSFRow row) {
        XSSFCell cell = row.createCell(0);
        cell.setCellValue(ci.company);
        cell = row.createCell(1);
        cell.setCellValue(ci.income);
        cell = row.createCell(2);
        cell.setCellValue(ci.year);
        cell = row.createCell(3);
        cell.setCellValue(companyIncomeYearCount.get(ci));
    }

    private static void addHeaderColumnsSheet1(XSSFRow row) {
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("State");
        cell = row.createCell(1);
        cell.setCellValue("Company");
        cell = row.createCell(2);
        cell.setCellValue("Year");
        cell = row.createCell(3);
        cell.setCellValue("Count");
    }

    private static void addHeaderColumnsSheet2 (XSSFRow row) {
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("Company");
        cell = row.createCell(1);
        cell.setCellValue("Income");
        cell = row.createCell(2);
        cell.setCellValue("Year");
        cell = row.createCell(3);
        cell.setCellValue("Count");
    }

    private static String getIncome(Double income) {
        if (income < 60000) {
            return "<60K";
        }
        if (income < 80000) {
            return ">60K and <80K";
        }
        if (income < 100000) {
            return ">80K and <100K";
        }
        if (income < 120000) {
            return ">100K and <120K";
        }
        return ">120K";
    }

}

