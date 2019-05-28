package com.petrikainulainen;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @see http://www.localeplanet.com/java/ru/index.html
 *      http://www.localeplanet.com/java/ru-RU/index.html
 */

public class MyClassBundle {

    static final String resources = "i18n/";

    public static void main(String[] args) {
        System.out.println("card.replacement.customerID.invalid = " + getBundle("cards_ru", "card.replacement.customerID.invalid"));
    }

    static String getBundle(String property, String key) {
        try {
            ResourceBundle rb = ResourceBundle.getBundle(resources + property, new Locale(LocaleExt.RU));
            return rb.getString(key);
        } catch (Exception e) {
            return null;
        }
    }
}
