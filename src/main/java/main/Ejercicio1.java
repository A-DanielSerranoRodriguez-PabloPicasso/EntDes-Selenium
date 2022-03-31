package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ejercicio1 {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver fd = new FirefoxDriver();
		WebElement elemento;
		String enlace;

		try {
			fd.get("https://www.google.com");
			fd.findElement(By.id("L2AGLb")).click();
			elemento = fd.findElement(By.name("q"));
			elemento.sendKeys("wikipedia");
			elemento.submit();
			Thread.sleep(2000);
			
			enlace = fd.findElement(By.partialLinkText("wikipedia.org")).getAttribute("href");
			fd.get(enlace);
			
			elemento = fd.findElement(By.id("searchInput"));
			elemento.sendKeys("Java");
			elemento.submit();
			Thread.sleep(2000);
			
			fd.findElement(By.cssSelector(".mw-parser-output > ul:nth-child(7) > li:nth-child(1) > b:nth-child(1) > a:nth-child(1)")).click();

			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		fd.close();
	}

}
