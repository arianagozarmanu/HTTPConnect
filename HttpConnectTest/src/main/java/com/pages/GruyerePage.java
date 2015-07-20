package com.pages;

import tools.Constants;
import tools.CreateSnippets;
import tools.DeleteSnippets;
import tools.Login;
import static ch.lambdaj.Lambda.convert;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

public class GruyerePage extends PageObject{

	@FindBy(css="a[href='/974152596312/snippets.gtl']")
	private WebElementFacade mySnippetsTab;
	
	@FindBy(css="div[class='content'] table tr:nth-child(2) td:nth-child(2) a")
	private WebElementFacade delSnip;
	
	@FindBy(css="div[class='content']")
	private WebElementFacade allDelMsg;
	
	public void login(String url) {
		Login.login(url);
	}
	
	public void createSnippets() throws Exception{
		CreateSnippets.createSnippets();
	}

	public void deleteSnippets() throws Exception{
		
		//Delete with request
		//DeleteSnippets.deleteSnippets();
		
		goToMySnippets();
		
		int i;
		for(i=0; i<Constants.snippetsNr;i++)
			delSnip.click();
		
	}
	
	public void goToMySnippets(){
		mySnippetsTab.click();
	}
	
	public void checkAllWereRemoved(){
		Assert.assertTrue("Some snippets are not deleted!",allDelMsg.getText().contains("No snippets."));
	}
}
