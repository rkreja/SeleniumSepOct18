package net.timeandtraining;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DemoImplicitWaitWithSuperClass2 extends Base{
	
	@Test
	public void implicitWait2() {
		driver.get("https://timeandtraining.net/seleniumdemo/selenium.html");
		String s=driver.findElement(By.xpath("//p[contains(text(),'Dream is not the thing ')]")).getText();
		System.out.println(s);

	}
}
