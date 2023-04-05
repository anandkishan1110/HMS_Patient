package JaiHind;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Method {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver d=new ChromeDriver();
	d.get("https://jqueryui.com/sortable/");
	d.manage().window().maximize();
	Actions a=new Actions(d);
	d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebElement source = d.findElement(By.xpath("//ul[@id='sortable']/descendant::li[.='Item 1']"));
	WebElement target = d.findElement(By.xpath("//ul[@id='sortable']/descendant::li[.='Item 7']"));
	a.dragAndDrop(source, target).perform();

	}

}
