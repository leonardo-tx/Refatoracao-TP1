package com.gildedrose;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Item {
    public static final int INCREMENT_LIMIT = 50;
    public static final int DECREMENT_LIMIT = 0;

    private final String name;
    @Setter
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void setQuality(int quality) {
        if (quality < DECREMENT_LIMIT || quality > INCREMENT_LIMIT) {
            throw new IllegalArgumentException("The quality cannot be less than " + DECREMENT_LIMIT + " or greater than " + INCREMENT_LIMIT);
        }
        this.quality = quality;
    }

    public boolean isOld() {
        return sellIn < 0;
    }

    public void incrementQuality(int count) {
        this.quality = Math.min(INCREMENT_LIMIT, quality + count);
    }

    public void decrementQuality(int count) {
        this.quality = Math.max(DECREMENT_LIMIT, quality - count);
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
