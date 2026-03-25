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
        app.updateQuality();

        Assertions.assertEquals("Comté", app.items[0].name);
        Assertions.assertEquals("Kryptonite", app.items[1].name);
        Assertions.assertEquals("Pass VIP Concert", app.items[2].name);

        // Vérifie que la qualité n'est jamais négative
        for (Item item : app.items) {
            Assertions.assertTrue(item.quality >= 0);
        }
    }

}
