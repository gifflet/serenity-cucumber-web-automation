package automation.definition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import automation.beans.Test;
import automation.business.Business;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

@ContextConfiguration("setup-spring.xml")
public class Definition {

	@Autowired
	@Qualifier("B")
	private Test component;
	
	@Steps
	Business business;
	String arg = null;
	
	@Given("^test iniciated \"([^\"]*)\"$")
	public void test_iniciated(String arg1) throws Throwable {
		arg = arg1;
	    System.out.println("test initiated: " + arg);
	    business.pesquisar(arg1);
	}
	
	@Given("^test iniciated 2 \"([^\"]*)\"$")
	public void test_iniciated2(String arg1) throws Throwable {
		arg = arg1;
		System.out.println("test initiated: " + arg);
		business.pesquisarFalha(arg1);
	}

	@Then("^test finished$")
	public void test_finished() throws Throwable {
	    System.out.println(arg + " finished");
	}
	
	@Given("^estou na pagina do google$")
	public void estou_na_pagina_do_google() throws Throwable {
		component.componentContent();
		business.abrirPagina("https://www.google.com.br");
	}

	@Then("^pesquise por kotlin$")
	public void pesquise_por_kotlin() throws Throwable {
		business.pesquisarPor("kotlin");
	}	
}
