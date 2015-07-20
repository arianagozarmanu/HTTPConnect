package com.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
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
	public void login(String url){
		gruyere.login(url);
	}
	
	@Step 
	public void addSnippets() throws Exception{
		gruyere.createSnippets();
	}
	
	@Step
	public void deleteSnippets(){
		
	}
	
	@Step
	public void validateRemoval(){
		
	}

}
