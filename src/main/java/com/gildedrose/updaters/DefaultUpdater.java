package com.gildedrose.updaters;

import com.gildedrose.Item;

public class DefaultUpdater implements ItemUpdater {
    public static final int NOT_OLD_DECREASE = 1;
    public static final int OLD_DECREASE = 2;

    @Override
    public void updateItem(Item item) {
        item.setSellIn(item.getSellIn() - 1);

        int decrement = item.isOld() ? OLD_DECREASE : NOT_OLD_DECREASE;
        item.decrementQuality(decrement);
    }
}
