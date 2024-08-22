import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String urlPage = 'https://facebook.com'

int RandomNumber

String isPresent

RandomNumber = ((Math.random() * 100) as int)

String firstName = 'ahmad'

String lastName = 'rivaldhi'

String email = ('ahmadrivaldhi' + RandomNumber) + '@gmail.com'

String locatorCreateNewAccount = 'Object Repository/Page Register/buttonCreateNewAccount'

String locatorFieldEmail = 'Object Repository/Page Register/fieldEmail'

String locatorFieldFirstname = 'Object Repository/Page Register/fieldFirstname'

String locatorFieldLastname = 'Object Repository/Page Register/fieldLastname'

String locatorFieldPassword = 'Object Repository/Page Register/fieldPassword'

String locatorDay = 'Object Repository/Page Register/fieldDay'

String locatorMonth = 'Object Repository/Page Register/fieldMonth'

String locatorYear = 'Object Repository/Page Register/fieldYear'

String locatorMaleGender = 'Object Repository/Page Register/fieldMaleGender'

String buttonSignUp = 'Object Repository/Page Register/buttonSignUp'

//navigating to page facebook
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(urlPage)

WebUI.waitForElementVisible(findTestObject(locatorCreateNewAccount), 0)

WebUI.click(findTestObject(locatorCreateNewAccount))

boolean isShowFormRegist = WebUI.verifyElementVisible(findTestObject(locatorFieldFirstname))

if (isShowFormRegist) {
    println('success show form register account')
}

//set field regist
WebUI.setText(findTestObject(locatorFieldFirstname), firstName)

WebUI.setText(findTestObject(locatorFieldLastname), lastName)

WebUI.setText(findTestObject(locatorFieldEmail), email)

WebUI.setEncryptedText(findTestObject(locatorFieldPassword), 'QGq1NTSxdahTVhbwtiX8yQ==')

//WebUI.click(findTestObject(locatorDay))

WebUI.selectOptionByValue(findTestObject(locatorDay), "13", true)
WebUI.selectOptionByValue(findTestObject(locatorMonth), "5", true)
WebUI.selectOptionByValue(findTestObject(locatorYear), "2000", true)

WebUI.click(findTestObject(locatorMaleGender))
WebUI.click(findTestObject(buttonSignUp))

WebUI.delay(8)
WebUI.verifyTextPresent("We need more information", true)
println("success register new account")

