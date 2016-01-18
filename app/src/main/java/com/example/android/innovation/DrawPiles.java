package com.example.android.innovation;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class DrawPiles {

    public ArrayList<List<Card>> mAges;

    public DrawPiles() {
        mAges = new ArrayList<>(Game.NUM_AGES);
        for (int i = 0; i < Game.NUM_AGES; i++) {
            mAges.add(new ArrayList<Card>());
        }
    }

    /**
     * Perform a draw action for the given age.
     * @param desiredAge The age from which to draw.
     * @return Returns the new Card drawn.
     */
    public Card draw(int desiredAge) {

        if (desiredAge < 1) throw new IllegalArgumentException("Invalid age");

        // Subtract one from the ages since they are 1-based.
        for (int ageIndex = desiredAge - 1; ageIndex < Game.NUM_AGES; ageIndex++) {
            List<Card> pile = mAges.get(ageIndex);
            if (pile.size() > 0) {
                return pile.remove(0);
            }
        }

        // If we got here, someone had to draw an 11, so the game is over.
        return new Card("GAME OVER");
    }

    /**
     * Return the given Card to the DrawPiles.
     *
     * @param card The Card to be returned.
     */
    public void returnCard(Card card) {
        if (card == null || !card.isValidAge(card.getAge())) {
            throw new InvalidParameterException("Invalid Card age");
        }

        List<Card> pile = mAges.get(card.getAge());
        pile.add(pile.size(), card);
    }
}
