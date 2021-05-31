package br.com.techlab.screenplay.questions;

import br.com.techlab.screenplay.components.ConfirmedRegistrationComponent;
import br.com.techlab.screenplay.components.StudentComponent;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class TheRegisteredStudent {

    public static Question<String> name() {
        return actor -> TextContent.of(ConfirmedRegistrationComponent.STUDENT_NAME_VALUE).viewedBy(actor).asString();
    }

    public static Question<String> email() {
        return actor -> TextContent.of(ConfirmedRegistrationComponent.STUDENT_EMAIL_VALUE).viewedBy(actor).asString();
    }

    public static Question<String> mobile() {
        return actor -> TextContent.of(ConfirmedRegistrationComponent.STUDENT_MOBILE_VALUE).viewedBy(actor).asString();
    }

    public static Question<String> subjects() {
        return actor -> TextContent.of(ConfirmedRegistrationComponent.STUDENT_SUBJECTS_VALUE).viewedBy(actor).asString();
    }
}
