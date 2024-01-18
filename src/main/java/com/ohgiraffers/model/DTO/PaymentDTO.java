package com.ohgiraffers.model.DTO;

public class PaymentDTO {
    private String card;
    private double discountRateByCard;

    public PaymentDTO() {
    }

    public PaymentDTO(String card, double discountRateByCard) {
        this.card = card;
        this.discountRateByCard = discountRateByCard;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public double getDiscountRateByCard() {
        return discountRateByCard;
    }

    public void setDiscountRateByCard(double discountRateByCard) {
        this.discountRateByCard = discountRateByCard;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "card='" + card + '\'' +
                ", discountRateByCard=" + discountRateByCard +
                '}';
    }
}
