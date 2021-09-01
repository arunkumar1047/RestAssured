package parameterization;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssign8 {
	
	@Test
	
		@Given("set http path")
		public void set_http_path() {
		    
		}

		@When("parameterize the values")
		public void parameterize_the_values() throws IOException{
			Response response;
		    String path="C:\\Users\\USER\\Documents\\Book1.xlsx";
		    FileInputStream file=new FileInputStream(path);
		    XSSFWorkbook workbook=new XSSFWorkbook(file);
		    XSSFSheet sheet= workbook.getSheetAt(0);
		    int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		    for(int i=1;i<=rowcount;i++) {
		      String id=sheet.getRow(i).getCell(0).getStringCellValue();
		      response=RestAssured.get("http://api.exchangeratesapi.io/v1/latest?access_key=7169dac9c0fa2d550590cf3a5ea5cfac");
		      String responseBody=response.getBody().asString();
		      response.then().log().all();
		      System.out.println("Response Body is:"  + responseBody);
		      System.out.println(id);
		      

		      //Excel sheet

		      XSSFRow row=sheet.getRow(i);
		      XSSFCell cell=row.createCell(4);
		      cell.setCellValue(responseBody);
		      FileOutputStream file1= new FileOutputStream(path);
		      workbook.write(file1);
		    }
		    workbook.close();
		   
		}
	    @Test
		@Then("Generate the report")
		public void generate_the_report() {
			System.out.println("Parameterisation is validated");
		 
		}


	}


