package com.gildedrose.updaters;

import com.gildedrose.Item;

public class BackstagePassUpdater implements ItemUpdater {
    public static final int ELEVEN_DAYS = 11;
    public static final int SIX_DAYS = 6;

    @Override
    public void updateItem(Item item) {
        item.setSellIn(item.getSellIn() - 1);
        if (item.isOld()) {
            item.setQuality(0);
            return;
        }
        int increment = 1;
        int lastSellIn = item.getSellIn() + 1;
        if (lastSellIn < ELEVEN_DAYS) {
            increment += 1;
        }
        if (lastSellIn < SIX_DAYS) {
            increment += 1;
        }
        item.incrementQuality(increment);
    }
}
