package com.example.android.innovation;

import java.util.ArrayList;

/**
 */
public class Game {

    public static final int NUM_AGES = 10;

    private ArrayList<Player> mPlayers;
    private DrawPiles mCardPiles;

    public Game(int numPlayers) {

        for (int i = 0; i < numPlayers; i++) {
            mPlayers.add(new Player());
        }

        mCardPiles = new DrawPiles();
    }

    public DrawPiles getDrawPiles() {
        return mCardPiles;
    }
}
