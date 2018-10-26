package com.automationpractice.framework;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;


@Listeners(com.automationpractice.framework.TestBase.class)
public class TestBase implements ITestListener, WebDriverEventListener {
	
	private ExtentTest parent;
	protected static ExtentTest reporter;
	
	protected EventFiringWebDriver driver;
	private WebDriver sdriver;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void init(@Optional("chrome") String browser) {
		
		Reporter.getInstance();
		
		
		switch (browser) {
		
	
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "lib\\chromedriver-windows-32bit.exe");
			sdriver = new ChromeDriver();
			break;
			
		case "internetexplorer":
			System.setProperty("webdriver.ie.driver", "lib\\internetexplorerdriver-windows-32bit.exe");
			sdriver = new InternetExplorerDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "lib\\chromedriver-windows-32bit.exe");
			sdriver = new ChromeDriver();
			break;
		}
		
		driver = new EventFiringWebDriver(sdriver);
		driver.register(this);
		
	
		/*if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "lib\\chromedriver-windows-32bit.exe");
			driver = new ChromeDriver();	
		}else if(browser.equalsIgnoreCase("internetexplorer")) {
			System.setProperty("webdriver.ie.driver", "lib\\internetexplorerdriver-windows-32bit.exe");
			driver = new InternetExplorerDriver();
		}*/
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	@AfterSuite
	public void saveReport() {
		Reporter.saveReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		reporter=parent.createNode(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		reporter.pass("test is passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		reporter.fail("test is failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		parent=Reporter.getInstance().createTest(getClass().getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		reporter.info("Naviagted to: "+ url);
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		reporter.info("Clcked on: " + element);
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
//		System.err.println("WEBDRIVER CAME HERE AND REPORTED");
		File capturedImg=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(capturedImg, new File("test-output\\screenshots\\captured.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {			
			reporter.fail(throwable.getMessage()).addScreenCaptureFromPath("screenshots\\captured.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
	
	


}
