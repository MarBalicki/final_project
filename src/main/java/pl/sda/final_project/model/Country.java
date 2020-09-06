package pl.sda.final_project.model;

import java.util.Arrays;

public enum Country {
    POLAND("Polska", "PL"),
    GERMANY("Niemcy", "DE"),
    FRANCE("Francja", "FR"),
    UKRAINE("Ukraina", "UK"),
    ITALY("Włochy", "IT"),
    GREAT_BRITAIN("Wielka Brytania", "GB");
    //są to singletony, i można je wyjątkowo porównać przez '==' to są tylko jedne w całej aplikacji

    private final String plName;
    private final String symbol;

    private Country(String plName, String symbol) {
        this.plName = plName;
        this.symbol = symbol;
    }

    public String getPlName() {
        return plName;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Country fromSymbol(String symbol) {
        return Arrays.stream(Country.values())
                .filter(country -> country.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nie znaleziono kraju!"));
    }
}
