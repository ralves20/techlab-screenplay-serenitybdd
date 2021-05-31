package br.com.techlab.screenplay.questions;

import br.com.techlab.screenplay.components.StudentComponent;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;

public class TheRequiredFieldError implements Question<String> {
    public static TheRequiredFieldError ofFieldName() {
        return new TheRequiredFieldError();
    }

    @Override
    public String answeredBy(Actor actor) {
        return TheTarget.cssValueNamed("border-color").forTarget(StudentComponent.NAME_FIELD).answeredBy(actor);
    }
}
