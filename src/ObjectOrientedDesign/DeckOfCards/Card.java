package ObjectOrientedDesign.DeckOfCards;


enum CardGroup {
    HEARTH,
    SPADE,
    DIAMOND,
    CLUB
}

public class Card {
    private String symbol;
    private CardGroup group;
    private int value;

    public Card() {
    }

    public Card(String symbol, CardGroup group) {
        this.symbol = symbol;
        this.group = group;
        this.value = getValue(symbol, group);
    }

    private int getValue(String symbol, CardGroup group) {
        int value = 0;

        switch (group) {
            case SPADE -> {
                value += 0;
            }
            case DIAMOND -> {
                value += 13;
            }
            case CLUB -> {
                value += 26;
            }
            case HEARTH -> {
                value += 39;
            }
        }

        if (symbol.toUpperCase().equals("A")) {
            value += 1;
        } else if (symbol.toUpperCase().equals("J")) {
            value += 11;
        } else if (symbol.toUpperCase().equals("Q")) {
            value += 12;
        } else if (symbol.toUpperCase().equals("K")) {
            value += 13;
        } else {
            value += Integer.parseInt(symbol);
        }

        return value;
    }

    public int getValue() {
        return this.value;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public CardGroup getGroup() {
        return group;
    }

    public void setGroup(CardGroup group) {
        this.group = group;
    }
}
