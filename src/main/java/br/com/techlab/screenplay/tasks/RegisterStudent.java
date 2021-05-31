package br.com.techlab.screenplay.tasks;

import br.com.techlab.screenplay.components.StudentComponent;
import br.com.techlab.screenplay.interactions.FillDateInput;
import br.com.techlab.screenplay.model.StudentData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import java.util.Map;

public class RegisterStudent implements Task {

    private final Map<String, String> studentInfo;

    public RegisterStudent(Map<String, String> studentInfo) {
        this.studentInfo = studentInfo;
    }


    public static RegisterStudent withInfoOf(Map<String, String> studentInfo) {
        return Instrumented.instanceOf(RegisterStudent.class).withProperties(studentInfo);
    }

    public static RegisterStudent withValidData() {
        Map<String, String> studentInfo = StudentData.DEFAULT_VALID_DATA;
        return Instrumented.instanceOf(RegisterStudent.class).withProperties(studentInfo);
    }

    @Override
    @Step("{0} fills the student form with #studentInfo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                RememberStudentAllInfo.of(studentInfo),

                Enter.theValue(studentInfo.get("name")).into(StudentComponent.NAME_FIELD),
                Enter.theValue(studentInfo.get("lastName")).into(StudentComponent.LAST_NAME_FIELD),
                Enter.theValue(studentInfo.get("email")).into(StudentComponent.EMAIL_FIELD),
                Enter.theValue(studentInfo.get("mobileNumber")).into(StudentComponent.PHONE_NUMBER_FIELD),

                JavaScriptClick.on(StudentComponent.genderOption(studentInfo.get("gender"))),

                FillDateInput.withValue(studentInfo.get("birthDate")).into(StudentComponent.BIRTHDATE_FIELD),

                SendKeys.of(studentInfo.get("subjects")).into(StudentComponent.SUBJECTS_FIELD),
                Hit.the(Keys.TAB).into(StudentComponent.SUBJECTS_FIELD),

                JavaScriptClick.on(StudentComponent.hobbiesOption(studentInfo.get("hobby"))),

                HoverOverElement.over(StudentComponent.STATE_ITEMS),
                Click.on(StudentComponent.STATE_ITEMS),
                Click.on(StudentComponent.stateItemOptionOf(studentInfo.get("state"))),

                HoverOverElement.over(StudentComponent.CITY_ITEMS),
                Click.on(StudentComponent.CITY_ITEMS),
                Click.on(StudentComponent.cityItemOptionOf(studentInfo.get("city"))),

                Enter.theValue(studentInfo.get("address")).into(StudentComponent.ADDRESS_FIELD));
    }
}
