package com.example.android.innovation;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card> mHand;
    private List<List<Card>> mBoard;
    private String mName;

    public Player() {
        this("Inigo Montoya");
    }

    public Player(String name) {
        mHand = new ArrayList<>();
        mBoard = createEmptyBoard();
        mName = name;
    }

    /**
     * Create an empty board.
     * @return A new board with no Cards in it.
     */
    private List<List<Card>> createEmptyBoard() {
        List<List<Card>> board = new ArrayList<>(Card.NUM_COLORS);
        for (int i = 0; i < Card.NUM_COLORS; i++) {
            mBoard.add(new ArrayList<Card>());
        }
        return board;
    }

    /**
     * Meld the given Card on the Player's board.
     * @param card The Card to be melded.
     */
    public void meldCard(Card card) {
        mBoard.get(card.getColor()).add(card);
    }

    /**
     * Remove the given Card from this Player's hand.
     * @param card The Card to be removed.
     */
    public void removeFromHand(Card card) {
        if (!mHand.remove(card)) {
            throw new InvalidParameterException("Card not in hand");
        }
    }

    /**
     * Have this Player perform a draw action.
     * @param gameState The current Game being played.
     */
    public void doDrawAction(Game gameState) {
        Card newCard = gameState.getDrawPiles().draw(getHighestTopCard());
        // TODO: check that Card isn't "GAME OVER".
        mHand.add(newCard);
    }

    /**
     * Get the age of the highest top Card on this Player's board.
     * @return The age of the highest top Card.
     */
    public int getHighestTopCard() {
        int topValue = 0;
        for (int i = 0; i < Card.NUM_COLORS; i++) {
            List<Card> colorPile = mBoard.get(i);
            if (colorPile.size() > 0) {
                final int topAge = colorPile.get(colorPile.size()-1).getAge();
                if (topAge > topValue) {
                    topValue = topAge;
                }
            }
        }
        return topValue;
    }
}
