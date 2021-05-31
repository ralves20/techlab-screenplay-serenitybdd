package br.com.techlab.cucumber.stepdefinitions;

import br.com.techlab.screenplay.components.StudentComponent;
import br.com.techlab.screenplay.questions.TheRegisterConfirmationMessage;
import br.com.techlab.screenplay.questions.TheRegisterSuccessConfirmation;
import br.com.techlab.screenplay.questions.TheRegisteredStudent;
import br.com.techlab.screenplay.questions.TheRequiredFieldError;
import br.com.techlab.screenplay.tasks.RegisterStudent;
import br.com.techlab.screenplay.tasks.Start;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class NewRegisterStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^(?:que)? (.*) acessa o formulário de cadastro de estudantes")
    public void queJoséAcessaOFormulárioDeCadastroDeEstudantes(String actor) {
        theActorCalled(actor).attemptsTo(Start.atStudentsHomePage());
    }

    @E("ele preenche todos os dados do aluno corretamente")
    public void elePreencheTodosOsDadosDoAlunoCorretamente() {
        theActorInTheSpotlight().attemptsTo(RegisterStudent.withValidData());
    }

    @Quando("ele aciona a opção para gravar os dados no sistema")
    public void eleAcionaAOpçãoParaGravarOsDadosNoSistema() {
        theActorInTheSpotlight().attemptsTo(Click.on(StudentComponent.SUBMIT));
    }

    @Entao("os dados do aluno são gravados com sucesso")
    public void osDadosDoAlunoSãoGravadosComSucesso() {
        theActorInTheSpotlight().should(seeThat(TheRegisterSuccessConfirmation.modal(), isVisible()),
                seeThat(TheRegisterConfirmationMessage.text(), is(equalTo("Thanks for submitting the form"))),
                seeThat("the registered student's name", TheRegisteredStudent.name(), is(equalTo(theActorInTheSpotlight().recall("studentFullName")))),
                seeThat("the registered student's email",TheRegisteredStudent.email(), is(equalTo(theActorInTheSpotlight().recall("studentEmail")))),
                seeThat("the registered student's mobile",TheRegisteredStudent.mobile(), is(equalTo(theActorInTheSpotlight().recall("studentMobile")))),
                seeThat("the registered student's subjects",TheRegisteredStudent.subjects(), is(equalTo(theActorInTheSpotlight().recall("studentSubjects")))));
    }

    @Então("ele deve ver que impedindo o cadastro erros são apresentados para os campos obrigatórios")
    public void eleDeveVerQueImpedindoOCadastroErrosSãoApresentadosParaOsCamposObrigatórios() {
        String requiredColor = "rgb(220, 53, 69)";
        theActorInTheSpotlight().should(seeThat(TheRequiredFieldError.ofFieldName(), is(equalTo(requiredColor))));
    }

    @Quando("ele aciona a opção para gravar os dados no sistema sem preencher campo algum")
    public void eleAcionaAOpçãoParaGravarOsDadosNoSistemaSemPreencherCampoAlgum() {
        theActorInTheSpotlight().attemptsTo(Click.on(StudentComponent.SUBMIT));
    }
}
