package testCase;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class secondTest {


    @BeforeMethod
    public void setUp() {
        Configuration.remote = "http://gridchrome-tdd-fd-zos-cg2.sis-frontend-testing-553e65d57aa996a84dfa67e2c277fee3-0000.us-south.containers.appdomain.cloud/wd/hub";

    }


    //元素定位跟之前一样，写法变简单
    //一个$是单个web element, 两个$$是多个
    @Test
    public void testLocator() {
        open("https://cloud.ibm.com");
        String expText = "Log in to IBM";
        //class="login-form__title"
        //直接用cssSelector
        $(".login-form__title")
                .should(appear)
                .shouldHave(text(expText));
        $("form")
                .shouldHave(text(expText));
        //正常写xpath
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebElement title = driver.findElement(By.xpath("//div[@class='login-form__title']"));
        if (title.isDisplayed()){
            title.getText().contains(expText);
        }

        $(By.xpath("//div[@class='login-form__title']"))
                .should(appear)
                .should(be(visible))
                .shouldHave(textCaseSensitive(expText));
        $(By.xpath("//button[@name='login']")).click();
        String msg = $(".bx--inline-notification__title").getText();

        List<WebElement> linkList2 = driver.findElements(By.xpath("//a"));

        //多个WebElement
        ElementsCollection linkList = $$(By.xpath("//a"));
        System.out.println("Link text:");
        System.out.println(linkList.texts());

        List<String> linkListText = Arrays.asList("","IBM\n Cloud", "Catalog", "Cost estimator", "Docs", "Create an account", "Forgot ID?");
        //assertEquals(linkListText, linkList.texts());
        linkList.shouldHave(CollectionCondition.texts(linkListText));

        //TestNG Assert
        assertEquals(msg, "You must enter an ID.");
        //TestNG的fail
        //assertEquals(msg, "You must enter an ID..");

        //输入用户名，类似与sendKeys
        $("#userid").val("lixt@cn.ibm.com");
        //sleep
        sleep(2000);

        //radiobutton, selectbox
        //$(By.name("user.gender")).selectRadio("male");
        //$("#user.preferredLayout").selectOption("plain");
        //$("#user.securityQuestion").selectOptionByValue("What is my first car?");
        //$("#remember-me-checkbox").shouldBe(enabled).click();
        $(".login-form__remember-me").shouldBe(enabled).click();
        //点击不了用js点也是一样可行的
        //executeJavaScript("arguments[0].click()",$("#remember-me-checkbox"));

        //取url，标题
        System.out.println("URL:" + url());
        System.out.println("title:" + title());
        assertTrue(url().contains("ibm"));

        //WebDriverRunner
        //https://selenide.org/javadoc/current/com/codeborne/selenide/WebDriverRunner.html
        System.out.println("Current using Chrome? "+WebDriverRunner.isChrome());
        //获取原本的WebDriver直接用也可以
        //WebDriver driver = WebDriverRunner.getWebDriver();
        //driver.findElement(By.id("userid")).sendKeys("abc@ibm.com");



    }

    @Test
    public void testBingReport() {
        open("https://bing.com");
        $("#sb_form_q")
                .shouldBe(editable)
                .setValue("Selenide");
        $("#sb_form_go")
                .shouldBe(enabled)
                .submit();
        $(".sb_count")
                .shouldBe(visible)
                .shouldHave(ownText("results"));
    }


}
