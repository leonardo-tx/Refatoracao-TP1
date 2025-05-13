package com.gildedrose.updaters;

import com.gildedrose.Item;

public class ConjuredUpdater implements ItemUpdater {
    @Override
    public void updateItem(Item item) {
        item.setSellIn(item.getSellIn() - 1);

        int decrement = item.isOld() ? 4 : 2;
        item.setQuality(Math.max(item.getQuality() - decrement, 0));
    }
}
