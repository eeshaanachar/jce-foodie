package com.example.jceinsider;

public class Food {
    int rate = 0;
    String gmapLink;
    String price;
    String prepTime;

    public Food () {
        //Default
    }

    public Food(String restaurant, String price, String prepTime) {
        this.price = price;
        this.prepTime = prepTime;
        if (restaurant.equals("Yampa"))
            this.gmapLink = "https://goo.gl/maps/48cFceWZJDUUpTgL7";
        else if (restaurant.equals("Café Frappe"))
            this.gmapLink = "https://g.page/cafe-frappe-mysuru?share";
        else if (restaurant.equals("Café Kushi"))
            this.gmapLink = "https://goo.gl/maps/dn32REH1mLQqqDtn9";
        else if (restaurant.equals("Nescafe"))
            this.gmapLink = "https://goo.gl/maps/iiSrwaHSTGCK8JZP6";
        else
            this.gmapLink = "https://goo.gl/maps/g16Zux7cLFQqXvDx8";
    }

    public String getPrice() {
        return price;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public int getRate() {
        return rate;
    }

    public String getGmapLink() { return gmapLink; }
}