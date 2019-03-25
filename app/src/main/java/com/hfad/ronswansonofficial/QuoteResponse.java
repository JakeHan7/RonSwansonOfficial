package com.hfad.ronswansonofficial;

public class QuoteResponse {
    private String quote;

    public QuoteResponse(String quote) {
        this.quote = quote;
    }

    public QuoteResponse(){

    }

    @Override
    public String toString() {
        return "QuoteResponse{" +
                "quote='" + quote + '\'' +
                '}';
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
