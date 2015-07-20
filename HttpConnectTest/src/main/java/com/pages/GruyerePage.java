package com.pages;

import tools.CreateSnippets;
import tools.Login;
import static ch.lambdaj.Lambda.convert;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

public class GruyerePage extends PageObject{

	public void login(String url) {
		Login.login(url);
	}
	
	public void createSnippets() throws Exception{
		CreateSnippets.createSnippets();
	}
}
