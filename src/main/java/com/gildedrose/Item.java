package com.gildedrose;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Item {
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
        if (quality < 0 || quality > 50) {
            throw new IllegalArgumentException("The quality cannot be negative or greater than 50.");
        }
        this.quality = quality;
    }

    public boolean isOld() {
        return sellIn < 0;
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
