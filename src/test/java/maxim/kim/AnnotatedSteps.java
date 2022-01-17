package maxim.kim;

import maxim.kim.steps.WebSteps;
import org.junit.jupiter.api.Test;

public class AnnotatedSteps {
private WebSteps steps = new WebSteps();
@Test
public void gitTest(){
    steps.openPage();
    steps.findRep("eroshenkoam/allure-example");
    steps.goToRep("eroshenkoam/allure-example");
    steps.openTabIssue();
    steps.checkIssueTab(68);

}
}
