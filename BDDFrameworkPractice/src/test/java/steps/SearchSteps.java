package steps;

import base.BaseUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.HomeDepotPage;

import static org.junit.Assert.assertTrue;

public class SearchSteps {

    private BaseUtil base;
    HomeDepotPage hm;

    public SearchSteps(BaseUtil base){
        this.base = base;
        hm = new HomeDepotPage(base.driver);
    }

    @Given("^User search for \"([^\"]*)\"$")
    public void userSearchFor(String item) throws Throwable {
        hm.searchFor(item);
    }

    @Then("^User should see the result page$")
    public void userShouldSeeTheResultPage() throws Throwable {
        assertTrue(hm.isOnResultPage());
    }

    @And("^User adds item to cart$")
    public void userAddsItemToCart() throws Throwable {
        hm.addItemToCart("4");
    }

    @Then("^User should see item in the cart$")
    public void userShouldSeeItemInTheCart() throws Throwable {
    }
}
