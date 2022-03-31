package models;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxConn {
	FirefoxDriver fd;
	String enlace;
	WebElement elemento;
	List<WebElement> elementos;

	public FirefoxConn() {
		WebDriverManager.firefoxdriver().setup();
		fd = new FirefoxDriver();
		elementos = new ArrayList<>();
	}

	public void get(String page) throws Exception {
		fd.get(page);
	}

	public WebElement findId(String id) throws Exception {
		elemento = fd.findElement(By.id(id));
		return elemento;
	}

	public WebElement findName(String name) throws Exception {
		elemento = fd.findElement(By.name(name));
		return elemento;
	}

	public WebElement findClass(String claSs) throws Exception {
		elemento = fd.findElement(By.className(claSs));
		return elemento;
	}

	public List<WebElement> findClasses(String claSs) throws Exception {
		elementos = fd.findElements(By.className(claSs));
		return elementos;
	}

	public WebElement findTag(String tag) throws Exception {
		elemento = fd.findElement(By.tagName(tag));
		return elemento;
	}

	public List<WebElement> findTags(String tag) throws Exception {
		elementos = fd.findElements(By.tagName(tag));
		return elementos;
	}

	public WebElement findCssSelector(String cssSelector) throws Exception {
		elemento = fd.findElement(By.cssSelector(cssSelector));
		return elemento;
	}

	public WebElement element() {
		return elemento;
	}

	public List<WebElement> elements() {
		return elementos;
	}

	public void submit() {
		elemento.submit();
	}

	public void close() {
		fd.close();
	}
}
