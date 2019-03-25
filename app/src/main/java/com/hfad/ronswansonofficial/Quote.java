package com.hfad.ronswansonoffical;

public class Quote {
    private String title;
    public Quote(String title) {
        this.title = title;

    }
    public Quote(){

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "title='" + title + '\'' +
                '}';
    }
}
