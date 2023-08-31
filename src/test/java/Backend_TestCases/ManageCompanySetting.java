package Backend_TestCases;

import java.util.List;

import org.testng.annotations.Test;

import TestBase.BaseClass;

public class ManageCompanySetting extends BaseClass{
	@Test
	public void openManageCompanySetting() {
		application.click("configurationOptionLeftMenu_xpath");
		application.wait(2);
		application.click("manageCompanySetting_xpath");
		application.wait(5);
	}
	@Test
	public void validateManageCompanySettingPage() {
		application.validateElementPresent("manageCompanySettingShowEntriesFilter_xpath");
		application.validateElementPresent("manageCompanySettingSearch_xpath");
		application.validateElementPresent("manageCompanySettingCreateCompany_xpath");
		application.validateManageCompanyTableHeaders("manageCompanySettingTableHeader_xpath");
		application.scrollByValue("10000");
		application.validateElementPresent("manageCompanySettingShowingResults_xpath");
		application.validateElementPresent("manageCompanySettingPagination_xpath", "Pagination");
	}
	
	@Test
	public void createCompany() {
		application.wait(5);
		application.click("manageCompanySettingCreateCompany_xpath");
		application.wait(5);
		application.validateElementPresent("createCompanyLicenseeText_xpath");
		application.validateMandatoryIconForLabel("Licensee");
		application.validateElementPresent("createCompanyDomainText_xpath");
		application.validateMandatoryIconForLabel("Company Domain");
		application.validateElementPresent("createCompanyDomainNote_xpath", "Company Domain Note");
		application.validateCompareText("createCompanyDomainNote_xpath", "Domain should start with http:// or https:// or www and space is not allowed");
		application.validateElementPresent("createCompanyNameText_xpath");
		application.validateMandatoryIconForLabel("Company Name");
		application.validateElementPresent("createCompanyDefaultCompanyText_xpath");
		application.validateElementPresent("createCompanyDescriptionText_xpath");
		application.validateElementPresent("createCompanyWebsiteUrlText_xpath");
		application.validateMandatoryIconForLabel("Website URL");
		application.validateElementPresent("createCompanyWebsiteURLNote_xpath", "Website URL Note");
		application.validateCompareText("createCompanyWebsiteURLNote_xpath", "URL should start with http:// or https:// or www and space is not allowed");
		application.validateElementPresent("createCompanyAddress1Text_xpath");
		application.validateElementPresent("createCompanyAddress2Text_xpath");
		application.validateElementPresent("createCompanyCountryText_xpath");
		application.validateElementPresent("createCompanyStateText_xpath");
		application.validateElementPresent("createCompanyCityText_xpath");
		application.validateElementPresent("createCompanyPincodeText_xpath");
		application.scrollTo("createCompanyEmailAddressText_xpath");
		application.validateElementPresent("createCompanyEmailAddressText_xpath");
		application.validateMandatoryIconForLabel("Email Address");
		application.validateElementPresent("createCompanySTDCodeText_xpath");
		application.validateMandatoryIconForLabel("STD Code");
		application.validateElementPresent("createCompanyLandLineText_xpath");
		application.validateMandatoryIconForLabel("Landline Number");
		application.validateElementPresent("createCompanyCorrectionText_xpath");
		application.validateMandatoryIconForLabel("Correction Request Email Id");
		application.validateElementPresent("createCompanyDefaultLanguageText_xpath");
		application.validateMandatoryIconForLabel("Default Language");
		application.validateElementPresent("createCompanyFacebookText_xpath");
		application.validateElementPresent("createCompanyYoutubeText_xpath");
		application.validateElementPresent("createCompanyTwitterText_xpath");
		application.validateElementPresent("createCompanyInstagramText_xpath");
		application.validateElementPresent("createCompanyWhatsappDescText_xpath");
		application.validateElementPresent("createCompanySMSText_xpath");
		application.validateMandatoryIconForLabel("SMS Content");
		application.scrollTo("createCompanyQRCodeText_xpath");
		application.validateElementPresent("createCompanyWhatsappMessageContentText_xpath");
		application.validateMandatoryIconForLabel("Company Whatsapp Message Content");
		application.validateElementPresent("createCompanyEmpWhatsappText_xpath");
		application.validateMandatoryIconForLabel("Employee Whatsapp Message Content");
		application.validateElementPresent("createCompanyWhatsappContentNote_xpath", "Employee Whatsapp message Content");
		application.validateContainsText("createCompanyWhatsappContentNote_xpath","Note");
		application.validateElementPresent("createCompanyEnquiryText_xpath");
		application.validateMandatoryIconForLabel("Company Enquiry Form Link");
		application.validateElementPresent("createCompanyEnquiryFormNote_xpath", "Enquiry Form Note");
		application.validateCompareText("createCompanyEnquiryFormNote_xpath", "URL should start with http:// or https:// or www and space is not allowed");
		application.validateElementPresent("createCompanyEmpProfilePicText_xpath");
		application.validateElementPresent("createCompanyWhatsappPreviewText_xpath");
		application.validateContainsText("createCompanyWhatsappPreviewRecommendedNote_xpath", "256x256 pixels (300KBs or less)");
		application.validateElementPresent("createCompanyQRCodeText_xpath");
		application.validateContainsText("createCompanyQRCodeRecommendedNote_xpath", "130x130 px (300KBs or less)");
		application.validateElementPresent("createCompanyCompanyLogoText_xpath");
		application.validateMandatoryIconForLabel("Company Logo");
		application.validateContainsText("createCompanyLogoRecommendedNote_xpath", "width 280px (300KBs or less)");
		application.validateElementPresent("createCompanySaveButton_xpath","Create Company Popup Save Button");
		application.validateElementPresent("createCompanyCancelButton_xpath", "Create Company Popup Cancel  button");
		application.click("createCompanySaveButton_xpath");
		
		
		//validate errors
		application.scrollTo("createCompanyLicenseeText_xpath");
		application.validateElementPresent("createCompanyLicenseeError_xpath", "Licensee Error");
		application.validateCompareText("createCompanyLicenseeError_xpath", "Licensee is required");
		application.validateElementPresent("createCompanyDomainError_xpath", "Company Domain Error");
		application.validateCompareText("createCompanyDomainError_xpath", "Company domain is required field");
		application.validateElementPresent("createCompanyNameError_xpath", "Company Name Error");
		application.validateCompareText("createCompanyNameError_xpath", "Company name is required.");
		application.validateElementPresent("createCompanyWebsiteURLError_xpath", "Website URL Error");
		application.validateCompareText("createCompanyWebsiteURLError_xpath", "Website URL is required");
		application.scrollTo("createCompanyEmailAddressText_xpath");
		application.validateElementPresent("createCompanyEmailError_xpath", "Email required Error.");
		application.validateCompareText("createCompanyEmailError_xpath", "Email is required.");
		application.validateElementPresent("createCompanySTDError_xpath", "STD Code Error.");
		application.validateCompareText("createCompanySTDError_xpath", "STD code is required");
		application.validateElementPresent("createCompanyLandlineError_xpath", "Landline number Error");
		application.validateCompareText("createCompanyLandlineError_xpath", "Landline number is required");
		application.validateElementPresent("createCompanyCorrectionReqError_xpath", "Correction request Email Error.");
		application.validateCompareText("createCompanyCorrectionReqError_xpath", "Email is required");
		application.validateElementPresent("createCompanyDefaultLangError_xpath", "Default Language Error");
		application.validateCompareText("createCompanyDefaultLangError_xpath", "Default language is required");
		application.validateElementPresent("createCompanySMSError_xpath", "SMS Content Error");
		application.validateCompareText("createCompanySMSError_xpath", "SMS Content is required");
		application.scrollTo("createCompanySMSError_xpath");
		application.validateElementPresent("createCompanyWhastappMsgContentError_xpath", "Whatsapp Message Content Error");
		application.validateCompareText("createCompanyWhastappMsgContentError_xpath", "Company Whatsapp Message Content is required");
		application.validateElementPresent("createCompanyEmpWhastappMsgContentError_xpath", "Employee Whatsapp Message Content Error");
		application.validateCompareText("createCompanyEmpWhastappMsgContentError_xpath", "Employee Whatsapp Message Content is required");
		application.validateElementPresent("createCompanyEnquiryFormError_xpath", "Company Enquiry Form Error");
		application.validateCompareText("createCompanyEnquiryFormError_xpath", "Company Enquiry Form Link is required");
		
		
		
		
	}
}
