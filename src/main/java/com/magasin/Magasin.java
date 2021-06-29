package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Kryptonite")) {
                // Date de péremption
                item.sellIn = item.sellIn - 1;

                // Qualité
                if (item.quality > 0) {
                    // Qualité diminue
                    if (!item.name.equals("Comté")
                        && !item.name.equals("Pass VIP Concert")) {
                        item.quality = item.quality - (item.name.equals("Pouvoirs magiques") ? 2 : 1);
                        // Qualité augmente
                    } else {
                        // Qualité limitée à 50 max
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                            // Qualité augmente en fonction de la date de péremption
                            if (item.name.equals("Pass VIP Concert")) {
                                if (item.sellIn < 11) {
                                    item.quality = item.quality + 1;
                                }// Qualité augmente de 3 pour les Pass VIP si selIn < ou = à 5
                                if (item.sellIn < 6) {
                                    item.quality = item.quality + 1;
                                }
                            }
                        }
                    }
                    // Date de péremption dépassée
                    if (item.sellIn < 0) {
                        if (!item.name.equals("Comté")) {
                            if (!item.name.equals("Pass VIP Concert")) {
                                item.quality = item.quality - (item.name.equals("Pouvoirs magiques") ? 2 : 1);
                            } else {
                                item.quality = 0;
                            }
                        } else { //quality ne dépasse pas 50
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }
        }
    }
}
