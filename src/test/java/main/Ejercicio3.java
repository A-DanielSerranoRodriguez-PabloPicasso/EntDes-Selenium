package main;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import models.FirefoxConn;

class Ejercicio3 {
	private FirefoxConn fd;
	private String wikipedia = "https://es.wikipedia.org", wikiSearchBar = "searchInput";

	@Test
	@DisplayName("Comprobando que la imagen de Pablo Picasso esta en su articulo de Wikipedia")
	void test_PPimageExists() {
		fd = new FirefoxConn();

		try {
			fd.get(wikipedia);
			fd.findId(wikiSearchBar).sendKeys("Pablo Picasso");
			fd.submit();

			assertTrue(fd
					.findCssSelector(
							"#mw-content-text > div.mw-parser-output > table > tbody > tr:nth-child(2) > td > a > img")
					.getAttribute("alt").equals("Pablo picasso 1.jpg"), "La imagen no existe");
		} catch (Exception e) {
			e.printStackTrace();
		}

		fd.close();
	}

	@Test
	@DisplayName("Comprobando que IES Pablo Picasso no tiene entrada en Wikipedia")
	void test_IESppExists() {
		fd = new FirefoxConn();

		try {
			fd.get(wikipedia);
			fd.findId(wikiSearchBar).sendKeys("IES Pablo Picasso");
			fd.submit();

			for (WebElement we : fd.findClasses("mw-search-result-heading"))
				assertFalse("IES Pablo Picasso tiene una entrada en Wikipedia", we.findElement(By.tagName("a")).getText().contains("IES Pablo Picasso"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		fd.close();
	}

}
