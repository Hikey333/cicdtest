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
