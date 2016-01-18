package com.example.android.innovation;

public class Dogma {
    private boolean mIsDemand;
    private Symbol mSymbol;
    // For demand dogmas, do not include the opening "I demand".
    private String mText;
    private DogmaAction mAction;

    public Dogma(boolean isDemand, Symbol symbol, String text, DogmaAction action) {
        mIsDemand = isDemand;
        mSymbol = symbol;
        mText = text;
        mAction = action;
    }

    public boolean isDemand() {
        return mIsDemand;
    }

    public Symbol getSymbol() {
        return mSymbol;
    }
}
