package br.com.techlab.screenplay.components;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class StudentComponent {

    public static final Target NAME_FIELD = Target.the("'name' field").located(By.id("firstName"));
    public static final Target LAST_NAME_FIELD = Target.the("'last name' field").located(By.id("lastName"));
    public static final Target EMAIL_FIELD = Target.the("'email' field").located(By.id("userEmail"));
    public static final Target PHONE_NUMBER_FIELD = Target.the("'phone number' field").located(By.id("userNumber"));
    public static final Target BIRTHDATE_FIELD = Target.the("'birthdate' field").located(By.id("dateOfBirthInput"));
    public static final Target SUBJECTS_FIELD = Target.the("'subjects' field").located(By.id("subjectsInput"));
    public static final Target ADDRESS_FIELD = Target.the("'address' field").located(By.id("currentAddress"));

    public static final Target STATE_ITEMS = Target.the("'state' items").located(By.xpath("//div[@id='state']/parent::div"));
    public static final Target CITY_ITEMS = Target.the("'state' items").located(By.xpath("//div[@id='city']/parent::div"));
    public static final Target SUBMIT = Target.the("'submit' element").located(By.id("submit"));


    public static Target stateItemOptionOf(String stateItem){
        return Target.the("'state of #stateItem' option").located(By.xpath("//div[@id='state']/descendant::*[contains(text(), '"+stateItem+"')]"));
    }

    public static Target cityItemOptionOf(String cityItem){
        return Target.the("'city of #cityItem' option").located(By.xpath("//div[@id='city']/descendant::*[contains(text(), '"+cityItem+"')]"));
    }

    public static Target genderOption(String genderOption) {
        return Target.the("'gender #genderOption' option")
                .located(By.xpath("//input[@name='gender' and @value='"+genderOption+"']"));
    }

    public static Target hobbiesOption(String hobbyOption) {
        return Target.the("'hobby #hobbyOption' item")
                .located(By.xpath("//label[contains(text(), '"+hobbyOption+"')]/preceding-sibling::input[@type='checkbox']"));
    }
}
