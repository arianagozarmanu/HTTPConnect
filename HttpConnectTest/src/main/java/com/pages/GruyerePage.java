package com.pages;

import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import tools.Constants;
import tools.CreateSnippets;
import tools.Login;

public class GruyerePage extends PageObject {

	@FindBy(css = "a[href='/974152596312/snippets.gtl']")
	private WebElementFacade mySnippetsTab;

	@FindBy(css = "div[class='content'] table tr:nth-child(2) td:nth-child(2) a")
	private WebElementFacade delSnip;

	@FindBy(css = "div[class='content']")
	private WebElementFacade allDelMsg;

	public void login(String url) {
		Login.login(url);
	}

	public void createSnippets() throws Exception {
		CreateSnippets.createSnippets();
	}

	public void deleteSnippets() throws Exception {

		// Delete with request
		// DeleteSnippets.deleteSnippets();

		goToMySnippets();

		int i;
		for (i = 0; i < Constants.snippetsNr; i++)
			delSnip.click();

	}

	public void goToMySnippets() {
		mySnippetsTab.click();
	}

	public void checkAllWereRemoved() {
		Assert.assertTrue("Some snippets are not deleted!", allDelMsg.getText().contains("No snippets."));
	}
}
