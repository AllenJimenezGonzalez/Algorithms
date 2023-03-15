package ObjectOrientedDesign.DeckOfCards;

public class Deck {
    private Card[] cards = new Card[52];

    public void buildGame(String gameType) {
        switch (gameType) {
            case "blackjack":
            default:
                buildStandard();
        }
    }

    String[] symbols = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};


    public void buildStandard() {
        for (CardGroup group : CardGroup.values()) {
            for (String symbol : symbols) {
                Card card = new Card(symbol, group);
                cards[card.getValue()] = card;
            }
        }
    }

}
