package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPages {

    public SelenideElement mainProductCard() {

        return $(byXpath("(//*[@class=\"_sliderWrapper_1i13w_2\"]//*[contains(@class, '_label_clp6c_17')])[1]"))
                .as("карточка товара");
    }
}
