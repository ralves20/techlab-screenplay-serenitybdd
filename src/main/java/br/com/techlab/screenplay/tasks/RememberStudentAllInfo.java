package br.com.techlab.screenplay.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.Map;

public class RememberStudentAllInfo implements Task {
    private static Map<String, String> studentInfo;

    public RememberStudentAllInfo(Map<String, String> studentInfo) {
        this.studentInfo = studentInfo;
    }

    public static RememberStudentAllInfo of(Map<String, String> studentInfo) {
        return Instrumented.instanceOf(RememberStudentAllInfo.class).withProperties(studentInfo);
    }

    @Override
    @Step("{0} remembers all student info of data from #studentInfo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                RememberThat.theValueOf("studentFullName").is(studentInfo.get("name") + " " + studentInfo.get("lastName")),
                RememberThat.theValueOf("studentFirstName").is(studentInfo.get("name")),
                RememberThat.theValueOf("studentLastName").is(studentInfo.get("lastName")),
                RememberThat.theValueOf("studentEmail").is(studentInfo.get("email")),
                RememberThat.theValueOf("studentMobile").is(studentInfo.get("mobileNumber")),
                RememberThat.theValueOf("studentSubjects").is(studentInfo.get("subjects")),
                RememberThat.theValueOf("studentHobby").is(studentInfo.get("hobby")),
                RememberThat.theValueOf("studentAddress").is(studentInfo.get("address")),
                RememberThat.theValueOf("studentGender").is(studentInfo.get("gender"))
                );
    }
}
