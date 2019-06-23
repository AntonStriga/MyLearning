package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    public static final String
        TITLE = "id:org.wikipedia:id/view_page_title_text",
        FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
        OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
        OPTIONS_ADD_TO_MYLIST_BUTTON = "xpath://*[@text='Add to reading list']",
        ADD_TO_MY_LIST_OVERLAY = "xpath://*[@text='Got it']",
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE,"Cannot find article title", 20);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(FOOTER_ELEMENT,"Cannot reach footer element", 20);
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(OPTIONS_BUTTON,"Cannot find 'More options' button",5);
        this.waitForElementAndClick(OPTIONS_ADD_TO_MYLIST_BUTTON,"Cannot find 'Add to reading list' button",5);
        this.waitForElementAndClick(ADD_TO_MY_LIST_OVERLAY,"Cannot find GOT IT button",5);
        this.waitForElementAndClear(MY_LIST_NAME_INPUT,"Cannot find input element to clear it",5);
        this.waitForElementAndSenKeys(MY_LIST_NAME_INPUT,name_of_folder,"Cannot find text input element",5);
        this.waitForElementAndClick(MY_LIST_OK_BUTTON,"Cannot find OK button",5);
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON,"Cannot find Navigate up button",5);
    }
}
