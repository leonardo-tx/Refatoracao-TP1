package com.gildedrose.updaters;

import com.gildedrose.Item;

public class AgedBrieUpdater implements ItemUpdater {
    public static final int NOT_OLD_INCREASE = 1;
    public static final int OLD_INCREASE = 2;

    @Override
    public void updateItem(Item item) {
        item.setSellIn(item.getSellIn() - 1);

        int increment = item.isOld() ? OLD_INCREASE : NOT_OLD_INCREASE;
        item.incrementQuality(increment);
    }
}
