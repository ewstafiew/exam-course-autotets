package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ModalProductPages {

    public SelenideElement addToCardButton() {

        return $("[aria-label=\"Добавить в корзину\"]")
                .as("Кнопка добавления в корзину");
    }
    public SelenideElement selectSizeItem() {

        return $(byXpath("(//*[@class=\"recaptcha\"]//*[contains(@class, '_colspan_1pcah_150')])[1]"))
                .as("Кнопка добавления в корзину");
    }

    public SelenideElement modalHeader() {

        return $(".d-modal__header")
                .as("Кнопка добавления в корзину");
    }

}
