package com.gildedrose.updaters;

import com.gildedrose.Item;

public class ConjuredUpdater implements ItemUpdater {
    public static final int NOT_OLD_DECREASE = 2;
    public static final int OLD_DECREASE = 4;

    @Override
    public void updateItem(Item item) {
        item.setSellIn(item.getSellIn() - 1);

        int decrement = item.isOld() ? OLD_DECREASE : NOT_OLD_DECREASE;
        item.decrementQuality(decrement);
    }
}
