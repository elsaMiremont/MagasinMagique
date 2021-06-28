package com.magasin;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {
    // Règles censées être déjà implémentées
    @Test
    void if_sell_in_date_is_passed_quality_should_decrease_two_times_faster()
    {
        Item item = new Item("Breloque", 0, 6);
        Item[] items = new Item[] { item };
        Magasin magasin = new Magasin(items);
        magasin.updateQuality();
        assertEquals(4, item.quality);
    }

    @Test
    void quality_cannot_be_negative()
    {
        Item item = new Item("Pass VIP Concert", 0, 0);
        Item[] items = new Item[] { item };
        Magasin magasin = new Magasin(items);
        magasin.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    void comte_quality_should_increase_when_sellin_is_under_10()
    {
        Item comte = new Item("Comté", 12, 8);
        Item[] items = new Item[] { comte };
        Magasin magasin = new Magasin(items);
        magasin.updateQuality();
        assertEquals(9, comte.quality);
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
    void kryptonite_never_changes()
    {
        Item item = new Item("Kryptonite", 0, 80);
        Item[] items = new Item[] { item };
        Magasin magasin = new Magasin(items);
        magasin.updateQuality();
        assertEquals(80, item.quality);
    }

    @Test
    void pass_VIP_increase_quality_by_2_when_under_10()
    {
        Item pass = new Item("Pass VIP Concert", 9, 15);
        Item[] items = new Item[] { pass };
        Magasin magasin = new Magasin(items);
        magasin.updateQuality();
        assertEquals(17, pass.quality);
    }


    @Test
    void vip_concert_quality_increase_by_three_if_time_is_equal_or_under_5_days ()
    {
        Item vipPass = new Item("Pass VIP Concert", 5, 10);
        Item[] items = new Item[] { vipPass};
        Magasin shop = new Magasin(items);
        shop.updateQuality();
        assertEquals(13, vipPass.quality );
    }

    @Test
    void pass_vip_concert_quality_should_fall_to_0_after_sell_in_date ()
    {
        Item pass = new Item("Pass VIP Concert", 0, 15);
        Item[] items = new Item[] { pass };
        Magasin magasin = new Magasin(items);
        magasin.updateQuality();
        assertEquals(0, pass.quality);
    }

    @Test
    void magic_powers_quality_should_decrease_two_times_faster()
    {
        Item power10 = new Item("Pouvoirs magiques", 10, 15);
        Item[] items10 = new Item[] { power10 };
        Magasin magasin10 = new Magasin(items10);
        magasin10.updateQuality();
        assertEquals(13, power10.quality);

        Item power0 = new Item("Pouvoirs magiques", 0, 15);
        Item[] items0 = new Item[] { power0 };
        Magasin magasin0 = new Magasin(items0);
        magasin0.updateQuality();
        assertEquals(11, power0.quality);
    }
}
