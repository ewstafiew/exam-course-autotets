package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchPages {

    public SelenideElement searchBar() {

        return $("._input_1su1z_19").as("строка поиска");
    }

    public SelenideElement searchButton() {

        return $(".x-button_borderlessPrimary").as("кнопка 'Поиск'");
    }

    public SelenideElement searchTextBlock() {

        return $("._titleText_641wy_15").as("элемент списка выбора размера");
    }

}

