package controller.sql;

import view.lesen.EingabeMitarbeiterId;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EingabeHandhaber {

    public enum ErwarteterInput {
        Vorname("^[\\p{L}'][ \\p{L}'-]*[\\p{L}]$"),
        Nachname("^[\\p{L}'][ \\p{L}'-]*[\\p{L}]$"),
        Telefonnummer("^([\\+][0-9]{1,3}[ \\.\\-])?([\\(]{1}[0-9]{1,6}[\\)])?([0-9 \\.\\-\\/]{3,20})((x|ext|extension)[ ]?[0-9]{1,4})?$"),
        Email("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");
        private String regex;
        ErwarteterInput(String regex) {
            this.regex = regex;
        }

        public String getRegex() {
            return regex;
        }
    }

    public EingabeHandhaber() {

    }

    public boolean pruefeInput(String input, ErwarteterInput erwarteterInput) {
        Pattern pattern = Pattern.compile(erwarteterInput.getRegex());
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
