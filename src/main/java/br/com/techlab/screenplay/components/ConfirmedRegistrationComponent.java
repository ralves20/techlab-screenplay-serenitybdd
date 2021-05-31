package br.com.techlab.screenplay.components;

import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmedRegistrationComponent {
    public static final Target REGISTRATION_MODAL = Target.the("'confirmed registration' modal")
            .located(By.xpath("//div[@role='document']/descendant::div[contains(@class, 'modal-content')]"));
    public static final Target CONFIRMATION_MESSAGE = Target.the("'confirmation message' text").located(By.id("example-modal-sizes-title-lg"));

    public static final Target STUDENT_NAME_VALUE = Target.the("'name value' text")
            .located(By.xpath("//div[@class='table-responsive']/descendant::tbody/descendant::td[text()='Student Name']/following-sibling::td"));
    public static final Target STUDENT_EMAIL_VALUE = Target.the("'name value' text")
            .located(By.xpath("//div[@class='table-responsive']/descendant::tbody/descendant::td[text()='Student Email']/following-sibling::td"));
    public static final Target STUDENT_MOBILE_VALUE = Target.the("'name value' text")
            .located(By.xpath("//div[@class='table-responsive']/descendant::tbody/descendant::td[text()='Mobile']/following-sibling::td"));
    public static final Target STUDENT_SUBJECTS_VALUE = Target.the("'name value' text")
            .located(By.xpath("//div[@class='table-responsive']/descendant::tbody/descendant::td[text()='Subjects']/following-sibling::td"));
}
