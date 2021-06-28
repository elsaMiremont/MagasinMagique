package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Kryptonite")) {
                // Date de péremption
                items[i].sellIn = items[i].sellIn - 1;

                // Qualité
                if (items[i].quality > 0) {
                    // Qualité diminue
                    if (!items[i].name.equals("Comté")
                            && !items[i].name.equals("Pass VIP Concert")) {
                        items[i].quality = items[i].quality - (items[i].name.equals("Pouvoirs magiques") ? 2 : 1);
                        // Qualité augmente
                    } else {
                        // Qualité limitée à 50 max
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                            // Qualité augmente en fonction de la date de péremption
                            if (items[i].name.equals("Pass VIP Concert")) {
                                if (items[i].sellIn < 11) {
                                    items[i].quality = items[i].quality + 1;
                                }// Qualité augmente de 3 pour les Pass VIP si selIn < ou = à 5
                                if (items[i].sellIn < 6) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            }
                        }
                    }
                    // Date de péremption dépassée
                    if (items[i].sellIn < 0) {
                        if (!items[i].name.equals("Comté")) {
                            if (!items[i].name.equals("Pass VIP Concert")) {
                                items[i].quality = items[i].quality - (items[i].name.equals("Pouvoirs magiques") ? 2 : 1);
                            } else {
                                items[i].quality = 0;
                            }
                        } else { //quality ne dépasse pas 50
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }
        }
    }
}
