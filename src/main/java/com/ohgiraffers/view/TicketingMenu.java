package com.ohgiraffers.view;

import com.ohgiraffers.controller.MemberManager;
import com.ohgiraffers.controller.PaymentManager;
import com.ohgiraffers.controller.TicketingManager;
import com.ohgiraffers.model.DTO.MemberDTO;
import com.ohgiraffers.model.DTO.TicketDTO;
import com.ohgiraffers.query.MemberQuery;

import java.util.Scanner;

import static com.ohgiraffers.run.Application.memberList;

public class TicketingMenu {

    private static int selectLogin = 0;
    private static MemberDTO nowLoginMember;
    private MemberDTO newMember;
    private Scanner sc = new Scanner(System.in);
    private MemberManager mm = new MemberManager();
    private TicketingManager tm = new TicketingManager();
    private TicketDTO td;
    private PaymentManager pay = new PaymentManager();
    private MemberQuery mq = new MemberQuery();

    public void mainMenu() {        //  메소드 첫 구동

        this.td = tm.startTicketing();

        loginMenu();
        pay.paymentMethod(selectLogin, tm.TimeSchedule(td), nowLoginMember);
        TicketCheck();
        System.out.println("즐거운 여행이 되길바랍니다.");
    }

    public void loginMenu() {
        System.out.println("==============================================");
        System.out.println("예매를 위해 로그인이 필요합니다.");
        System.out.println("1. 회원");
        System.out.println("2. 비회원");
        System.out.println("3. 회원가입");
        String input;
        while (true) {
            System.out.print("로그인 방식을 선택해주세요 : ");
            input = sc.nextLine();
            if (input.equals("1") || input.equals("2") || input.equals("3")) {
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요.");
            }
        }

        switch (input) {
            case "1" :
                nowLoginMember = mm.memberLogin();
                mq.updateLogin(selectLogin,nowLoginMember.getId());
                this.selectLogin = 1;


                break;
            case "2" :
                mm.nonMemberLogin();
                break;
            case "3" :
                this.newMember = mm.signUp();
                memberList.add(this.newMember);
                loginMenu();
                break;
        }
    }

    public void TicketCheck() {
        while (true) {
            System.out.println("==============================================");
            System.out.println("예매하신 내역을 확인하시겠습니까?");
            System.out.println("1. 예매내역 확인");
            System.out.println("2. 프로그램 종료");
            System.out.println("==============================================");
            System.out.print("메뉴 선택 : ");
            String input = sc.nextLine();
            switch (input) {
                case "1" :
                    td.TicketInfo();
                case "2" : return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}