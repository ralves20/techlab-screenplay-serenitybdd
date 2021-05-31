package br.com.techlab.screenplay.questions;

import br.com.techlab.screenplay.components.ConfirmedRegistrationComponent;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;

public class TheRegisterSuccessConfirmation implements Question<WebElementState> {
    public static TheRegisterSuccessConfirmation modal() {
        return new TheRegisterSuccessConfirmation();
    }

    @Override
    public WebElementState answeredBy(Actor actor) {
        return ConfirmedRegistrationComponent.REGISTRATION_MODAL.resolveFor(actor);
    }

}
