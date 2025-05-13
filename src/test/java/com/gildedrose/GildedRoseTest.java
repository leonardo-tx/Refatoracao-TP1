package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    public void testCommonItemsBeforeOld() {
        Item[] items = new Item[] {
            new Item("Item 1", 5, 0),
            new Item("Item 2", 7, 10),
            new Item("Item 3", 1, 20),
        };
        Item[] expectedItems = new Item[] {
            new Item("Item 1", 4, 0),
            new Item("Item 2", 6, 9),
            new Item("Item 3", 0, 19),
        };
        GildedRose app = new GildedRose(new ItemUpdaterFactory(), items);
        app.updateQuality();

        assertItems(expectedItems, items);
    }

    @Test
    public void testCommonItemsAfterOld() {
        Item[] items = new Item[] {
            new Item("Item 1", 0, 0),
            new Item("Item 2", 0, 10),
            new Item("Item 3", -1, 20),
        };
        Item[] expectedItems = new Item[] {
            new Item("Item 1", -1, 0),
            new Item("Item 2", -1, 8),
            new Item("Item 3", -2, 18),
        };
        GildedRose app = new GildedRose(new ItemUpdaterFactory(), items);
        app.updateQuality();

        assertItems(expectedItems, items);
    }

    @Test
    public void testBackstageItemsBeforeOld() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 12, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1),
            new Item("Backstage passes to a TAFKAL80ETC concert", 7, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, 35),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 48),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 47),
            new Item("Backstage passes to a TAFKAL80ETC concert", 20, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 8, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 8, 48),
        };
        Item[] expectedItems = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 2),
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, 12),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 37),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 19, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 7, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 7, 50),
        };
        GildedRose app = new GildedRose(new ItemUpdaterFactory(), items);
        app.updateQuality();

        assertItems(expectedItems, items);
    }

    @Test
    public void testBackstageItemsAfterOld() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", -1, 5),
        };
        Item[] expectedItems = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", -2, 0),
        };
        GildedRose app = new GildedRose(new ItemUpdaterFactory(), items);
        app.updateQuality();

        assertItems(expectedItems, items);
    }

    @Test
    public void testAgedBrieItemsBeforeOld() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 5, 0),
            new Item("Aged Brie", 7, 50),
            new Item("Aged Brie", 1, 10),
        };
        Item[] expectedItems = new Item[] {
            new Item("Aged Brie", 4, 1),
            new Item("Aged Brie", 6, 50),
            new Item("Aged Brie", 0, 11),
        };
        GildedRose app = new GildedRose(new ItemUpdaterFactory(), items);
        app.updateQuality();

        assertItems(expectedItems, items);
    }

    @Test
    public void testAgedBrieItemsAfterOld() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 0, 0),
            new Item("Aged Brie", -1, 49),
            new Item("Aged Brie", -2, 35),
        };
        Item[] expectedItems = new Item[] {
            new Item("Aged Brie", -1, 2),
            new Item("Aged Brie", -2, 50),
            new Item("Aged Brie", -3, 37),
        };
        GildedRose app = new GildedRose(new ItemUpdaterFactory(), items);
        app.updateQuality();

        assertItems(expectedItems, items);
    }

    @Test
    public void testLegendaryItemsUpdate() {
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 5, 50),
            new Item("Sulfuras, Hand of Ragnaros", 12, 42),
            new Item("Sulfuras, Hand of Ragnaros", -5, 34),
        };
        Item[] expectedItems = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 5, 50),
            new Item("Sulfuras, Hand of Ragnaros", 12, 42),
            new Item("Sulfuras, Hand of Ragnaros", -5, 34),
        };
        GildedRose app = new GildedRose(new ItemUpdaterFactory(), items);
        app.updateQuality();

        assertItems(expectedItems, items);
    }

    private void assertItems(Item[] expectedItems, Item[] items) {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            Item expectedItem = expectedItems[i];

            assertEquals(
                expectedItem.getName(), item.getName(),
                "Item at index " + i + " should have the name as " + expectedItem.getName()
            );
            assertEquals(
                expectedItem.getSellIn(), item.getSellIn(),
                "Item at index " + i + " should have the sellIn as " + expectedItem.getSellIn()
            );
            assertEquals(
                expectedItem.getQuality(), item.getQuality(),
                "Item at index " + i + " should have the quality as " + expectedItem.getQuality()
            );
        }
    }
}
