package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CardSearchPages {

    public SelenideElement searchBar() {

        return $(byXpath("//*/div/input")).as("строка поиска");
    }


    public SelenideElement searchButton() {

        return $(".x-button.x-button_primaryFilledWeb7184.x-button_32._button_1su1z_11").as("кнопка 'Поиск'");
    }

    public SelenideElement ProductCard() {

        return $(byXpath("//*/div[10]")).as("карточка товара");
    }

    public SelenideElement addToCardButton() {

        return $("[aria-label=\"Добавить в корзину\"]").as("карточка товара");
    }

    public SelenideElement sizeSelectionButton() {

        return $(".icon.icon_collapse-arrow.icon_direction-down.icon_24._arrow_1pcah_76").as("size selection button");
    }

    public SelenideElement itemSelectionButton() {

        return $(byXpath("//*/div/*/div[1]/div/div[2]/div[2]/div/div[1]")).as("элемент списка выбора размера");
    }

    public SelenideElement searchTextBlock() {

        return $("._titleText_641wy_15.ui-catalog-search-head-title").as("элемент списка выбора размера");
    }

}
