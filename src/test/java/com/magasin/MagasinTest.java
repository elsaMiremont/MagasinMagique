package com.magasin;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {
    // Règles censées être déjà implémentées
    @Test
    void ifSellInDateIsPassedQualityShouldDecreaseTwoTimesFaster()
    {
        Item item = new Item("Breloque", 10, 6);
        Item[] items = new Item[] { item };
        Magasin magasin = new Magasin(items);
        magasin.updateQuality();
        assertEquals(4, item.quality);
    }

    @Test
    void qualityCannotBeNegative() {
        Item item = new Item("Pass VIP Concert", 0, 0);
        Item[] items = new Item[] { item };
        Magasin magasin = new Magasin(items);
        magasin.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    void comteShouldIncreaseItsQuality() {
        Item comte = new Item("Comté", 12, 10);
        Item[] items = new Item[] { comte };
        Magasin magasin = new Magasin(items);
        magasin.updateQuality();
        assertEquals(11, comte.sellIn);
        assertEquals(11, comte.quality);
    }

    @Test
    void quality_cant_be_greater_than_50(){
        Item product = new Item("diamond",12,51);
        Item[] items = new Item[] {product};
        Magasin shop = new Magasin(items);
        shop.updateQuality();
        assertEquals(50,product.quality);
    }

    @Test
    void kryptoniteNeverChange() {
        Item item = new Item("Kryptonite", 0, 80);
        Item[] items = new Item[] { item };
        Magasin magasin = new Magasin(items);
        magasin.updateQuality();
        assertEquals(80, item.quality);
    }

    @Test
    void comteAndPassVIPIncreaseQuality() {
        Item comte = new Item("Comté", 11, 10);
        Item pass = new Item("Pass VIP Concert", 11, 15);
        Item[] items = new Item[] { comte, pass };
        Magasin magasin = new Magasin(items);
        magasin.updateQuality();
        assertEquals(12, comte.quality);
        assertEquals(17, pass.quality);
    }
}
