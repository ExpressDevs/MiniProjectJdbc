package com.ohgiraffers.model.DTO;

import com.ohgiraffers.query.goods;

public class TicketDTO {

    private int adultTicketCount = 0;
    private int seniorTicketCount = 0;
    private int teenagerTicketCount = 0;
    private int childrenTicketCount = 0;
    private int total = 0;
    private goods goods = new goods();

    String startStation = "";

    public TicketDTO() {
    }

    public TicketDTO(int adultTicketCount, int seniorTicketCount, int teenagerTicketCount, int childrenTicketCount,String startStation) {
        this.adultTicketCount = adultTicketCount;
        this.seniorTicketCount = seniorTicketCount;
        this.teenagerTicketCount = teenagerTicketCount;
        this.childrenTicketCount = childrenTicketCount;
        this.startStation = startStation;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;

    }

    public int getAdultTicketCount() {
        return adultTicketCount;
    }

    public void setAdultTicketCount(int adultTicketCount) {
        this.adultTicketCount = adultTicketCount;
    }

    public int getSeniorTicketCount() {
        return seniorTicketCount;
    }

    public void setSeniorTicketCount(int seniorTicketCount) {
        this.seniorTicketCount = seniorTicketCount;
    }

    public int getTeenagerTicketCount() {
        return teenagerTicketCount;
    }

    public void setTeenagerTicketCount(int teenagerTicketCount) {
        this.teenagerTicketCount = teenagerTicketCount;
    }

    public int getChildrenTicketCount() {
        return childrenTicketCount;
    }

    public void setChildrenTicketCount(int childrenTicketCount) {
        this.childrenTicketCount = childrenTicketCount;
    }

    public void setTotal(int total) {
        this.total += total;
    }

    public int getTotal() {
        return total;
    }


    public void TicketInfo() {
        String ticketNum = "";
        int num = 1;
        while (num < 4) {
            ticketNum += (int)(Math.random() * 9 + 1);
            num++;
        }
        while (num < 7) {
            ticketNum += (char)(Math.random() * 26 + 65);
            num++;
        }

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
            if (adultTicketCount > 0 || seniorTicketCount > 0 || teenagerTicketCount >0) {
                ticketInfo += ", ";
                }
            ticketInfo += "영유아 " + childrenTicketCount + "석";
        }

        ticketInfo += " 입니다.";

        goods.insertAll();
        System.out.println(ticketInfo);
    }


}