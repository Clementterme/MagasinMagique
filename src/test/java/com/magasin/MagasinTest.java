package com.magasin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void updateQualityTest() {
        Item[] items = new Item[] { new Item("Comté", 10, 10),
                                    new Item("Kryptonite", 1, 80),
                                    new Item("Pass VIP Concert", 20, 10),
                                    new Item("Comté", 10, 10),};
        Magasin app = new Magasin(items);

        int oldQualityKryptonite = app.items[1].quality;
        int oldSellInKryptonite = app.items[1].sellIn;

        app.updateQuality();

        Assertions.assertEquals("Comté", app.items[0].name);
        Assertions.assertEquals("Kryptonite", app.items[1].name);
        Assertions.assertEquals("Pass VIP Concert", app.items[2].name);

        // Vérifie que la qualité n'est jamais négative
        for (Item item : app.items) {
            Assertions.assertTrue(item.quality >= 0);
        }

        // Vérifie que la qualité n'est jamais au dessus de 50 sauf pour la Kryptonite
        for (Item item : app.items) {
            if (!item.name.equals("Kryptonite")) {
                Assertions.assertTrue(item.quality < 50);
            }
        }

        // Vérifie que la qualité et la date de péremption de la Kryptonite n'ont pas changé
        Assertions.assertTrue(oldQualityKryptonite == app.items[1].quality);
        Assertions.assertTrue(oldSellInKryptonite == app.items[1].sellIn);

    }

}
