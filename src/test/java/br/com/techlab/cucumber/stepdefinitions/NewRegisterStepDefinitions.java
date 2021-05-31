package br.com.techlab.cucumber.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class NewRegisterStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^(?:que)? (.*) acessa o formulário de cadastro de estudantes")
    public void queJoséAcessaOFormulárioDeCadastroDeEstudantes(String actor) {
        theActorCalled(actor).attemptsTo();
    }

}
