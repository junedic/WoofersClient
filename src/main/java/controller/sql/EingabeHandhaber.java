package controller.sql;

import view.lesen.EingabeMitarbeiterId;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EingabeHandhaber {

    public enum ErwarteterInput {
        Vorname("^[\\p{L}'][ \\p{L}'-]*[\\p{L}]$"),
        Nachname("^[\\p{L}'][ \\p{L}'-]*[\\p{L}]$"),
        Telefonnummer("^(\\+[0-9]{1,} |0)[1-9]{2,} [0-9]{2,}(\\-[0-9]{1,}|)$"),
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
