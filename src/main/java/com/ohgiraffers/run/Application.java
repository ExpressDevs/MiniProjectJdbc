package com.ohgiraffers.run;

import com.ohgiraffers.model.DTO.MemberDTO;
import com.ohgiraffers.model.DTO.TrainDTO;
import com.ohgiraffers.view.TicketingMenu;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<MemberDTO> memberList = new ArrayList<>();
    public static List<TrainDTO> timeSchedule = new ArrayList<>();

    public static void main(String[] args) {

        new TicketingMenu().mainMenu();

    }

}
