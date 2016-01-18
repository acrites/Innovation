package com.example.android.innovation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Class that contains all the Cards in the game.
 */
public class CardList {

    public static Card agriculture = new Card(Symbol.NO_ICON, Symbol.LEAF, Symbol.LEAF, Symbol.LEAF,
            1, CardColor.YELLOW, "agriculture", new ArrayList<>(Collections.singletonList(
            new Dogma(false, Symbol.LEAF,
                    "You may return a card from your hand. If you do, draw and score a card of value 1 higher than the card you returned",
                    new DogmaAction() {
                        @Override
                        public void doDogma(Game gameState) {

                        }
                    }))));

    public static Card archery = new Card(Symbol.CASTLE, Symbol.LIGHTBULB, Symbol.NO_ICON, Symbol.CASTLE,
            1, CardColor.RED, "archery", new ArrayList<>(Collections.singletonList(
            new Dogma(true, Symbol.CASTLE,
                    "you draw a 1, then transfer the highest card in your hand to my hand!",
                    new DogmaAction() {
                        @Override
                        public void doDogma(Game gameState) {

                        }
                    })
    )));

    public static Card cityStates = new Card(Symbol.NO_ICON, Symbol.CROWN, Symbol.CROWN, Symbol.CASTLE,
            1, CardColor.PURPLE, "city states", new ArrayList<>(Collections.singletonList(
            new Dogma(true, Symbol.CROWN,
                    "you transfer a top card with a [Castle] from your board to my board if you have at least 4 [Castle] icons on your board! If you do, draw a 1.",
                    new DogmaAction() {
                        @Override
                        public void doDogma(Game gameState) {

                        }
                    })
    )));

    public static Card clothing = new Card(Symbol.NO_ICON, Symbol.CROWN, Symbol.LEAF, Symbol.LEAF,
            1, CardColor.GREEN, "clothing", new ArrayList<>(Arrays.asList(
            new Dogma(false, Symbol.LEAF,
                    "Meld a card from your hand of a different color from any card on your board.",
                    new DogmaAction() {
                        @Override
                        public void doDogma(Game gameState) {

                        }
                    }),
            new Dogma(false, Symbol.LEAF,
                    "Draw and score a 1 for each color present on your board no present on any other player's board.",
                    new DogmaAction() {
                        @Override
                        public void doDogma(Game gameState) {

                        }
                    })
    )));

    public static Card metalworking = new Card(Symbol.CASTLE, Symbol.CASTLE, Symbol.NO_ICON, Symbol.CASTLE,
            1, CardColor.RED, "metalworking", new ArrayList<>(Collections.singletonList(
            new Dogma(false, Symbol.CASTLE,
                    "Draw and reveal a 1. If it has a [Castle], score it and repeat this dogma effect. Otherwise, keep it.",
                    new DogmaAction() {
                        @Override
                        public void doDogma(Game gameState) {

                        }
                    }))));

}
