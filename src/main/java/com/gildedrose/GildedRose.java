package com.gildedrose;

import com.gildedrose.updaters.ItemUpdater;

public class GildedRose {
    private final Item[] items;
    private final ItemUpdaterFactory factory;

    public GildedRose(ItemUpdaterFactory factory, Item[] items) {
        this.items = items;
        this.factory = factory;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = factory.createItemUpdater(item);
            updater.updateItem(item);
        }
    }
}
