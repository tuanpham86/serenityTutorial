package net.serenitybdd.tutorials.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.tutorials.model.Category;


/**
 * Created by MJ on 5/29/2016.
 */
public class NavigationBar {
    public static Target category(Category category) {
        return Target.the(category.name() + " category")
                .locatedBy("//td[@class='cat lw']/a[contains(text(),'{0}')]")
                .of(category.name());
    }
}
