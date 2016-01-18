package com.example.android.innovation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class Card implements Serializable {

    private Symbol mUpperLeft;
    private Symbol mBottomLeft;
    private Symbol mBotomCenter;
    private Symbol mBottomRight;
    private int mAge;
    private CardColor mColor;
    private String mName;
    private List<Dogma> mDogmas;

    public Card() {
        this("Needs a name");
    }

    public Card(String name) {
        this(name, 1);
    }

    public Card(String name, int age) {
        this(Symbol.NO_ICON, Symbol.NO_ICON, Symbol.NO_ICON, Symbol.NO_ICON,
                age, CardColor.RED, name, new ArrayList<Dogma>());
    }

    public Card(Symbol ul, Symbol ll, Symbol lc, Symbol lr,
                int age, CardColor color, String name, ArrayList<Dogma> dogmas) {
        mUpperLeft = ul;
        mBottomLeft = ll;
        mBotomCenter = lc;
        mBottomRight = lr;

        if (isValidAge(age)) {
            mAge = age;
        } else {
            throw new InvalidParameterException("Invalid Card age");
        }

        mColor = color;
        mName = name;
        mDogmas = new ArrayList<>();
        mDogmas.addAll(dogmas);
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

    public CardColor getColor() {
        return mColor;
    }

    public int getAge() {
        return mAge;
    }

    public boolean isValidAge(int age) {
        return age > 0 && age < 11;
    }

    public static int getSmallIconResource(Symbol symbol) {
        switch (symbol) {
            case CASTLE:
                return R.drawable.small_castle;
            case CLOCK:
                return R.drawable.small_clock;
            case CROWN:
                return R.drawable.small_crown;
            case FACTORY:
                return R.drawable.small_factory;
            case LEAF:
                return R.drawable.small_leaf;
            case LIGHTBULB:
                return R.drawable.small_lightbulb;
            default:
                throw new InvalidParameterException("Invalid symbol");
        }
    }

    public int getCardColorResource() {
        switch (mColor) {
            case RED:
                return R.color.red;
            case BLUE:
                return R.color.blue;
            case GREEN:
                return R.color.green;
            case YELLOW:
                return R.color.yellow;
            case PURPLE:
                return R.color.purple;
            default:
                throw new InvalidParameterException("Invalid color");
        }
    }

    public View getView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.card, container, false);

        TextView ageView = (TextView)view.findViewById(R.id.card_age);
        ageView.setText(String.valueOf(mAge));

        RelativeLayout mainLayout = (RelativeLayout)view.findViewById(R.id.card_main_layout);
        mainLayout.setBackgroundColor(getCardColorResource());

        TextView nameView = (TextView)view.findViewById(R.id.card_name);
        nameView.setText(mName);

        ImageView upperLeftIconView = (ImageView)view.findViewById(R.id.upper_left_icon);
        upperLeftIconView.setImageResource(getSmallIconResource(mUpperLeft));

        ImageView bottomLeftIconView = (ImageView)view.findViewById(R.id.bottom_left_icon);
        bottomLeftIconView.setImageResource(getSmallIconResource(mBottomLeft));

        ImageView bottomCenterIconView = (ImageView)view.findViewById(R.id.bottom_center_icon);
        bottomCenterIconView.setImageResource(getSmallIconResource(mBotomCenter));

        ImageView bottomRightIconView = (ImageView)view.findViewById(R.id.bottom_right_icon);
        bottomRightIconView.setImageResource(getSmallIconResource(mBottomRight));

        // Now set the dogmas

        return view;
    }
}
