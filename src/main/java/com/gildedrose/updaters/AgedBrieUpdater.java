package com.gildedrose.updaters;

import com.gildedrose.Item;

public class AgedBrieUpdater implements ItemUpdater {
    @Override
    public void updateItem(Item item) {
        item.setSellIn(item.getSellIn() - 1);

        int increment = item.isOld() ? 2 : 1;
        item.setQuality(Math.min(item.getQuality() + increment, 50));
    }
}
