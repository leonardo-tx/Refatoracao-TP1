package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateSellIn(item);
            if (updateQualityFromLegendaryItems(item) ||
                updateQualityFromAgedBrie(item) ||
                updateQualityFromBackstage(item)) {
                continue;
            }
            updateQualityFromCommonItems(item);
        }
    }

    private void updateSellIn(Item item) {
        boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");
        if (!isSulfuras) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private boolean updateQualityFromLegendaryItems(Item item) {
        boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");
        return isSulfuras;
    }

    private boolean updateQualityFromAgedBrie(Item item) {
        boolean isAgedBrie = item.name.equals("Aged Brie");
        if (!isAgedBrie) {
            return false;
        }
        boolean isOld = item.sellIn < 0;
        int increment = isOld ? 2 : 1;

        item.quality = Math.min(item.quality + increment, 50);
        return true;
    }

    private boolean updateQualityFromBackstage(Item item) {
        boolean isBackstage = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
        if (!isBackstage) {
            return false;
        }
        boolean isOld = item.sellIn < 0;
        if (isOld) {
            item.quality = 0;
            return true;
        }
        int increment = 1;
        if (item.sellIn < 11) {
            increment += 1;
        }
        if (item.sellIn < 6) {
            increment += 1;
        }
        item.quality = Math.min(item.quality + increment, 50);
        return true;
    }

    private void updateQualityFromCommonItems(Item item) {
        boolean isOld = item.sellIn < 0;

        int decrement = isOld ? 2 : 1;
        item.quality = Math.max(item.quality - decrement, 0);
    }
}
