package br.com.techlab.screenplay.interactions;

import br.com.techlab.screenplay.components.StudentComponent;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

public class FillDateInput implements Interaction {

    private Target fieldName;
    private String dateValue;

    public FillDateInput(Target fieldName, String dateValue) {
        this.fieldName = fieldName;
        this.dateValue = dateValue;
    }

    public static FillDateInputBuilder withValue(String dateValue) {
        return Instrumented.instanceOf(FillDateInputBuilder.class).withProperties(dateValue);
    }

    @Override
    @Step("{0} fills the date input #fieldName")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(fieldName),
                Enter.keyValues(Keys.chord(Keys.CONTROL, "a")).into(StudentComponent.BIRTHDATE_FIELD),
                Enter.keyValues(dateValue).into(fieldName)
        );
    }

    public static class FillDateInputBuilder {
        private String dateValue;

        public FillDateInputBuilder(String dateValue) {
            this.dateValue = dateValue;
        }

        public FillDateInput into(Target fieldName) {
            return Instrumented.instanceOf(FillDateInput.class).withProperties(fieldName, dateValue);
        }

    }
}
