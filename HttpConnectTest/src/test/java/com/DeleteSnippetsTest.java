package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.DeleteSnippetsSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import tools.Constants;

@RunWith(SerenityRunner.class)
public class DeleteSnippetsTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.urlLogin)
	public Pages pages;

	@Steps
	public DeleteSnippetsSteps snippets;

	@Issue("#Delete Snippets")

	@Test
	public void delete_all_snippets_created() throws Exception {
		snippets.login(Constants.urlLogin);
		snippets.addSnippets();
		snippets.goToMySnippetsPage();
		snippets.deleteSnippets();
		snippets.validateRemoval();
	}

}
