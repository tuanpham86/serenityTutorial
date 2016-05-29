package net.serenitybdd.tutorials.features.navigation;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.tutorials.model.Category;
import net.serenitybdd.tutorials.steps.NavigatingUser;
import net.serenitybdd.tutorials.tasks.NavigateTo;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.tutorials.model.Category.Motors;
import static org.hamcrest.CoreMatchers.containsString;


/**
 * Created by MJ on 5/28/2016.
 */
@RunWith(SerenityRunner.class)
public class WhenBrowsingProductCateogries {

    @Steps
    NavigatingUser mark;

    @Managed
    WebDriver browser;

    @Test
    public void shouldBeAbleToNavigateToTheMotorsCategory(){
        //Given
        mark.isOnTheHomePage();

        //When
        mark.navigatesToCategory(Motors);

        //Then
        mark.shouldSeePageTitleContaining("eBay Motors | eBay");
    }

    @Test
    public void shouldBeAbleToViewMotorProducts(){

        Actor mike = Actor.named("Mike");
        mike.can(BrowseTheWeb.with(browser));

        when(mike).attemptsTo(NavigateTo.theCategory(Motors));

        then(mike).should(seeThat(TheWebPage.title(), containsString("eBay Motors | eBay")));

    }
}
