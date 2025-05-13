package com.gildedrose.updaters;

import com.gildedrose.Item;

public class DefaultUpdater implements ItemUpdater {
    @Override
    public void updateItem(Item item) {
        item.setSellIn(item.getSellIn() - 1);

        int decrement = item.isOld() ? 2 : 1;
        item.setQuality(Math.max(item.getQuality() - decrement, 0));
    }
}
