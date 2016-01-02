package com.example.android.innovation;

import org.junit.Test;
import static org.junit.Assert.*;

public class DrawPilesTest {

    final String TEST_STRING_1 = "Metalworking";
    final String TEST_STRING_2 = "Currency";

    @Test
    public void testDraw() throws Exception {
        DrawPiles testPiles = new DrawPiles();

        // check that all the piles are empty
        for (int i = 0; i < Game.NUM_AGES; i++) {
            assertEquals(testPiles.mAges.get(i).size(), 0);
        }

        // Add a card to age 1 and 2
        testPiles.mAges.get(0).add(new Card(TEST_STRING_1));
        testPiles.mAges.get(1).add(new Card(TEST_STRING_2));

        Card testCard = new Card();

        // Try to draw the age 1 card.
        testCard = testPiles.draw(1);
        assertEquals(testCard.getName(), TEST_STRING_1);

        // Try to draw another age 1 card (which is now empty)
        testCard = testPiles.draw(1);
        assertEquals(testCard.getName(), TEST_STRING_2);

        // All the piles are empty now.
        testCard = testPiles.draw(1);
        assertEquals(testCard.getName(), "GAME OVER");

        // Test we get an exception if we try to draw an invalid age.
        boolean errorThrown = false;
        try {
            testCard = testPiles.draw(0);
        } catch (IllegalArgumentException e) {
            errorThrown = true;
        }
        assertTrue(errorThrown);
    }
}