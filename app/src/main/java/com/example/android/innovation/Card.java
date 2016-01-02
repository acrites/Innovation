package com.example.android.innovation;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class Card implements HasDogma {

    public static final int NUM_COLORS = 5;
    public static final int RED = 0;
    public static final int BLUE = 1;
    public static final int GREEN = 2;
    public static final int YELLOW = 3;
    public static final int PURPLE = 4;

    private Symbol mUpper_Left;
    private Symbol mLower_Left;
    private Symbol mLower_Center;
    private Symbol mLower_Right;
    private int mAge;
    private int mColor;
    private String mName;
    private List<Dogma> mDogmas;

    public Card() {
        this("Needs a name");
    }

    public Card(String name) {
        this(Symbol.NO_ICON, Symbol.NO_ICON, Symbol.NO_ICON, Symbol.NO_ICON,
                0, RED, name, new ArrayList<Dogma>());
    }

    public Card(Symbol ul, Symbol ll, Symbol lc, Symbol lr,
                int age, int color, String name, ArrayList<Dogma> dogmas) {
        mUpper_Left = ul;
        mLower_Left = ll;
        mLower_Center = lc;
        mLower_Right = lr;

        if (isValidAge(age)) {
            mAge = age;
        } else {
            throw new InvalidParameterException("Invalid Card age");
        }

        if (isValidColor(color)) {
            mColor = color;
        } else {
            throw new InvalidParameterException("Invalid Card color");
        }

        mName = name;
        mDogmas = new ArrayList<>();
        mDogmas.addAll(dogmas);
    }

    @Override
    public void doDogma() {

    }

    @Override
    public int hashCode() {
        return mName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
            return false;
        } else if (obj == this) {
            return true;
        }

        Card card = (Card)obj;
        return mName.equals(card.getName());
    }

    public String getName() {
        return mName;
    }

    public int getColor() {
        return mColor;
    }

    public int getAge() {
        return mAge;
    }

    private boolean isValidColor(int color) {
        return color == RED || color == BLUE || color == GREEN || color == YELLOW || color == PURPLE;
    }

    private boolean isValidAge(int age) {
        return age > 0 && age < 11;
    }
}

