package br.com.techlab.screenplay.questions;

import br.com.techlab.screenplay.components.ConfirmedRegistrationComponent;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheRegisterConfirmationMessage implements Question<String> {
    public static TheRegisterConfirmationMessage text() {
        return new TheRegisterConfirmationMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ConfirmedRegistrationComponent.CONFIRMATION_MESSAGE).viewedBy(actor).asString();
    }

}
