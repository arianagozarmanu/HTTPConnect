package com.steps;

import com.pages.GruyerePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class DeleteSnippetsSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	GruyerePage gruyere;

	@Step
	public void login(String url) {
		gruyere.login(url);
	}

	@Step
	public void addSnippets() throws Exception {
		gruyere.createSnippets();
	}

	@Step
	public void deleteSnippets() throws Exception {
		gruyere.deleteSnippets();
	}

	@Step
	public void is_the_home_page() {
		gruyere.open();
	}

	@Step
	public void validateRemoval() {
		gruyere.checkAllWereRemoved();
	}

}
