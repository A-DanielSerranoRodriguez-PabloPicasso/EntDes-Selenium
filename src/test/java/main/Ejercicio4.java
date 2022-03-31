package main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import models.FirefoxConn;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Ejercicio4 {
	static FirefoxConn fd = new FirefoxConn();

	@BeforeAll
	private static void createConn() {
		try {
			fd.get("https://testsheepnz.github.io/BasicCalculator.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterAll
	private static void deleteConn() {
		fd.close();
	}

	@Test
	@Order(1)
	@DisplayName("Comprobamos que estamos en la web correcta")
	void test_checkSite() {
		try {
			assertTrue(fd.findCssSelector("#page-top > header > div > div > div.intro-heading.text-uppercase").getText()
					.equals("BASIC CALCULATOR"), "Sitio equivocado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@CsvSource({ "2, 2, 4, false, 1", "2.5, 2, 4, true, 1", "2.5, 2, 4.5, false, 1", "2, 2, 0, false, 2",
			"2.5, 2, 0, true, 2", "2.5, 2, 0.5, false, 2", "2, 2, 4, false, 3", "2.55, 2, 5, true, 3",
			"2.55, 2, 5.1, false, 3", "2, 2, 1, false, 4", "2.5, 2, 1, true, 4", "2.5, 2, 1.25, false, 4",
			"2, 2, 22, false, 5", "2.5, 2, 2.52, false, 5" })
	@DisplayName("Comprobamos que la calculadora funciona correctamente")
	void test_CalcWorks(String num1, String num2, String resul, boolean sel, int operation) {
		try {
			Thread.sleep(2000);
			fd.findId("selectOperationDropdown").click();
			fd.findCssSelector("#selectOperationDropdown > option:nth-child(" + operation + ")").click();
			fd.findId("number1Field").sendKeys(num1);
			fd.findId("number2Field").sendKeys(num2);
			if (operation != 5)
				if (sel) {
					if (!fd.findId("integerSelect").isSelected())
						fd.findId("integerSelect").click();
				} else {
					if (fd.findId("integerSelect").isSelected())
						fd.findId("integerSelect").click();
				}

			fd.findId("calculateButton").click();
			Thread.sleep(2000);

			fd.findId("number1Field").clear();
			fd.findId("number2Field").clear();

			assertTrue(resul.equals(fd.findId("numberAnswerField").getAttribute("value")));
			Thread.sleep(1000);

			fd.findId("clearButton").click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
