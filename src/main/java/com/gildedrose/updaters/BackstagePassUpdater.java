package com.gildedrose.updaters;

import com.gildedrose.Item;

public class BackstagePassUpdater implements ItemUpdater {
    @Override
    public void updateItem(Item item) {
        item.setSellIn(item.getSellIn() - 1);
        if (item.isOld()) {
            item.setQuality(0);
            return;
        }
        int increment = 1;
        int lastSellIn = item.getSellIn() + 1;
        if (lastSellIn < 11) {
            increment += 1;
        }
        if (lastSellIn < 6) {
            increment += 1;
        }
        item.setQuality(Math.min(item.getQuality() + increment, 50));
    }
}
