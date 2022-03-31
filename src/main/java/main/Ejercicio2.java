package main;

import org.openqa.selenium.By;

import models.FirefoxConn;

public class Ejercicio2 {

	public static void main(String[] args) {
		FirefoxConn fd = new FirefoxConn();
		String enlace = "https://www.odoo.com/es_ES";

		try {
			fd.get(enlace);
			fd.findCssSelector("#top_menu > div > a.btn.btn-primary").click();

			Thread.sleep(2000);

			fd.findCssSelector(
					"#wrapwrap > main > div > div.subscription-widget-container.bg-white > div > div.row.choose-app-step.o_trial_step_1 > div.choose-app-list.col-12.mt24.o_animate_in_children.o_visible.offset-lg-1.col-lg-10 > div:nth-child(2) > label:nth-child(1) > div")
					.click();
			Thread.sleep(2000);
			fd.findCssSelector(
					"#wrapwrap > main > div > div.subscription-widget-container.bg-white > div > div.row.choose-app-step.o_trial_step_1 > div.choose-app-info-panel.col-lg-3.col-12.mt32 > div > div > button")
					.click();
			Thread.sleep(2000);

			fd.findId("username").sendKeys("Elpe Peloco");
			fd.findId("email").sendKeys("pepeloco@gmail.com");
			fd.findId("company-name").sendKeys("QueGuapa LaEmpresa TM");
			fd.findName("company_size").findElement(By.cssSelector(
					"#wrapwrap > main > div > div.subscription-widget-container.bg-white > div > div.fill-info-step.o_trial_step_2 > div > div.col-lg-7.mt48.o_animate_in_children.o_visible > div > div.col-12.mb-4.mb-md-5 > form > div:nth-child(7) > div:nth-child(1) > div > select > option:nth-child(3)"))
					.click();
			fd.findName("plan").findElement(By.cssSelector("#plan > option:nth-child(2)")).click();

			fd.findCssSelector(
					"#wrapwrap > main > div > div.subscription-widget-container.bg-white > div > div.fill-info-step.o_trial_step_2 > div > div.col-lg-7.mt48.o_animate_in_children.o_visible > div > div.col-12.mb-4.mb-md-5 > form > div.row.mt24 > div.col-auto.text-right > button")
					.click();

			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		fd.close();
	}

}
