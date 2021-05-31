package br.com.techlab.screenplay.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;


public class Start implements Task {

    public Start() {

    }
    public static Start atStudentsHomePage() {
        return Instrumented.instanceOf(Start.class).newInstance();
    }

    @Override
    @Step("{0} starts the browser at students home page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.relativeUrl("/automation-practice-form"));
    }
}
