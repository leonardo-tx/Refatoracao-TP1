package com.gildedrose;

import com.gildedrose.updaters.*;

import java.util.Set;

public class ItemUpdaterFactory {
    private final Set<String> legendaryItems = Set.of("Sulfuras, Hand of Ragnaros");

    public ItemUpdater createItemUpdater(Item item) {
        if (isLegendary(item)) {
            return new LegendaryUpdater();
        }
        if (isConjured(item)) {
            return new ConjuredUpdater();
        }
        return switch (item.getName()) {
            case "Aged Brie" -> new AgedBrieUpdater();
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePassUpdater();
            default -> new DefaultUpdater();
        };
    }

    private boolean isLegendary(Item item) {
        return legendaryItems.contains(item.getName());
    }

    private boolean isConjured(Item item) {
        return item.getName().startsWith("Conjured");
    }
}
