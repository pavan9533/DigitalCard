package Backend_TestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import TestBase.BaseClass;

public class Dashboard extends BaseClass{
	@Test
	public void dashboard() {
		application.validateElementPresent("dashboardLogoLeft_xpath");
		application.validateElementPresent("dashboardTitle_xpath");
		application.validateElementPresent("languageSelector_xpath");
		application.validateElementPresent("profileIcon_xpath");
		application.validateElementPresent("loginUserTitle_xpath");
		application.validateElementPresent("dashboardLogoRight_xpath");
		application.validateElementPresent("dashboardLeftMenu_xpath");
		application.validateElementPresent("dashboardOptionLeftMenu_xpath");
		application.validateElementPresent("configurationOptionLeftMenu_xpath");
		application.validateElementPresent("securityOptionLeftMenu_xpath");
		application.validateElementPresent("reportsOptionLeftMenu_xpath");
		application.validateElementPresent("nonPersonaOptionLeftMenu_xpath");
		application.validateElementPresent("dashboardCompanyText_xpath");
		application.validateElementPresent("dashboardFromDateText_xpath");
		application.validateElementPresent("dashboardToDateText_xpath");
		application.validateElementPresent("dashboardIpAddressText_xpath");
		application.validateElementPresent("dashboardFilterbutton_xpath");
		application.validateElementPresent("employeeBulkDownloadButton_xpath");
		application.validateElementPresent("dashboardSearchText_xpath");
		application.validateElementPresent("dashboardEmployeeSearch_xpath");
		application.validateDashboardTableHeaders("dashboardEmployeeTable_xpath");
		application.wait(5);
	}
	
	@Test
	public void bulkEmployeeDownload() {
//		application.selectFromDown("dashboardSelectCompany_xpath", "company", "Dashboard");
//		application.wait(2);
		application.selectDateFromInput("dashboardFromDate_xpath","fromDate", "Dashboard");
		application.wait(2);
		application.selectDateFromInput("dashboardToDate_xpath", "toDate", "Dashboard");
		application.wait(2);
//		application.selectFromDown("dashboardIpAddressType_xpath", "IPType" , "Dashboard");
//		application.wait(5);
		
		application.validateElementPresent("dashboardFilterbutton_xpath");
		application.click("dashboardFilterbutton_xpath");
		try {
			try {
			application.type("dashboardEmployeeSearch_xpath", readExcelData("InvalidSearchEmployee", "Dashboard"));
			}catch(Exception e ) {
				test.log(Status.INFO, "Invalid Search Employee is not defined in Test data sheet.");
			}
			application.validateEmployeeNoData();
			application.wait(5);
			application.clear("dashboardEmployeeSearch_xpath");
			application.wait(5);
			try {
			application.type("dashboardEmployeeSearch_xpath", readExcelData("ValidSearchEmployee", "Dashboard"));
			application.wait(5);
			}catch(Exception e) {
				test.log(Status.INFO, "Valid Search Employee is not defined in Test data sheet.");
			}
			application.click("employeeBulkDownloadButton_xpath");
			application.wait(5);
		}catch(Exception e) {
			test.log(Status.INFO, "Employee name not defined in the test data sheet.");
		}
		application.wait(3);
	    List<String> languages = application.getTextFromExcel("SelectLanguage", "ManageLicensee");
		    if (languages.isEmpty()) {
		        test.log(Status.INFO, "Language is not defined in the test data sheet.");
		        application.wait(5);
		        return; 
		    }
		    
	}
	@Test
	public void changeLanguage() {
		application.wait(3);
	    List<String> languages = application.getTextFromExcel("SelectLanguage", "Dashboard");
	    if (languages.isEmpty()) {
	        test.log(Status.FAIL, "Language is not defined in the test data sheet.");
	        application.wait(5);
	        return; 
	    }
	    
	    String language = languages.get(0).toLowerCase(); 
	    
	    application.click("languageSelector_xpath");
	    switch (language) {
	        case "english":
	            application.validateElementPresent("selectEnglish_xpath");
	            application.click("selectEnglish_xpath");
	            test.log(Status.INFO, "English Language is Selected.");
	            break;
	        case "hindi":
	            application.validateElementPresent("selectHindi_xpath");
	            application.click("selectHindi_xpath");
	            test.log(Status.INFO, "Hindi Language is Selected.");
	            break;
	        case "japanese":
	            application.validateElementPresent("selectJapanese_xpath");
	            application.click("selectJapanese_xpath");
	            test.log(Status.INFO, "Japanese Language is Selected.");
	            break;
	        default:
	            test.log(Status.INFO, "Unsupported language: " + language);
	            break;
	    }
	    application.wait(5);
	    generateScreenshots("Change Language");
	}
}
