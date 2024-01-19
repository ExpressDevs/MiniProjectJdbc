package com.ohgiraffers.model.DTO;

public class TicketDTO {

    private String startStation;
    private String endStation;
    private String departureTime;
    private int billingAmount;
    private int totalAmount;
    private String paymentMethod;
    private int adultTicketCount = 0;
    private int seniorTicketCount = 0;
    private int teenagerTicketCount = 0;
    private int childrenTicketCount = 0;
    private int total = 0;
    private String adult;
    private String senior;
    private String teenager;
    private String children;


    public TicketDTO() {
    }

    public TicketDTO(int adultTicketCount, int seniorTicketCount, int teenagerTicketCount, int childrenTicketCount, String startStation) {
        this.adultTicketCount = adultTicketCount;
        this.seniorTicketCount = seniorTicketCount;
        this.teenagerTicketCount = teenagerTicketCount;
        this.childrenTicketCount = childrenTicketCount;
        this.startStation = startStation;
    }

    public int getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(int billingAmount) {
        this.billingAmount = billingAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;

    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public int getAdultTicketCount() {
        return adultTicketCount;
    }

    public void setAdultTicketCount(int adultTicketCount) {

        this.adultTicketCount = adultTicketCount;
        this.adult = "일반";
    }

    public int getSeniorTicketCount() {
        return seniorTicketCount;
    }

    public void setSeniorTicketCount(int seniorTicketCount) {

        this.seniorTicketCount = seniorTicketCount;
        this.senior = "시니어";
    }

    public int getTeenagerTicketCount() {
        return teenagerTicketCount;
    }

    public void setTeenagerTicketCount(int teenagerTicketCount) {

        this.teenagerTicketCount = teenagerTicketCount;
        this.teenager = "어린이";
    }

    public int getChildrenTicketCount() {
        return childrenTicketCount;
    }

    public void setChildrenTicketCount(int childrenTicketCount) {

        this.childrenTicketCount = childrenTicketCount;
        this.children = "영유아";
    }

    public String getAdult() {
        return adult;
    }

    public String getSenior() {
        return senior;
    }

    public String getTeenager() {
        return teenager;
    }

    public String getChildren() {
        return children;
    }

    public void setTotal(int total) {
        this.total += total;
    }

    public int getTotal() {
        return total;
    }


    public void TicketInfo(String ticketNum) {
        System.out.println("==============================================");
        String ticketInfo = "============== 예매하신 티켓 내역 ==============\n";
        ticketInfo += "티켓번호 : " + ticketNum + "\n";
        ticketInfo += "출발역 : " + startStation + "\n";
        ticketInfo += "구매하신 좌석 내역 : ";
        if (adultTicketCount > 0) {
            ticketInfo += "일반 " + adultTicketCount + "석";
        }
        if (seniorTicketCount > 0) {
            if (adultTicketCount > 0) {
                ticketInfo += ", ";
            }
            ticketInfo += "시니어 " + seniorTicketCount + "석";
        }
        if (teenagerTicketCount > 0) {
            if (adultTicketCount > 0 || seniorTicketCount > 0) {
                ticketInfo += ", ";
            }
            ticketInfo += "어린이 " + teenagerTicketCount + "석";
        }
        if (childrenTicketCount > 0) {
            if (adultTicketCount > 0 || seniorTicketCount > 0 || teenagerTicketCount > 0) {
                ticketInfo += ", ";
            }
            ticketInfo += "영유아 " + childrenTicketCount + "석";
        }

        ticketInfo += " 입니다.";

        System.out.println(ticketInfo);
    }


}