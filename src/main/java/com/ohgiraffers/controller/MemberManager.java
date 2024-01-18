package com.ohgiraffers.controller;

import com.ohgiraffers.model.DTO.MemberDTO;
import com.ohgiraffers.query.MemberQuery;

import java.util.Scanner;

import static com.ohgiraffers.run.Application.memberList;

public class MemberManager {

    private MemberQuery mq =new MemberQuery();
    private Scanner sc = new Scanner(System.in);
    private String nonMemberPhone = "";         // 비회원 로그인에 사용되는 핸드폰번호
    private String nonMemberPsw = "";           // 비회원 로그인에 사용되는 비밀번호

    public MemberManager() {
    }

    // 회원가입 메소드
    public MemberDTO signUp() {
        System.out.println("==============================================");
        System.out.println("회원가입을 진행합니다.");
        System.out.print("성함을 입력해주세요. : ");
        String newName = sc.nextLine();
        System.out.print("나이를 입력해주세요. : ");
        int newAge = sc.nextInt();
        sc.nextLine();

        String newId = IdDuplicateCheck();
        String newPsw = "";
        int mileage = 0;
        while (true) {
            System.out.println("사용하실 비밀번호를 입력해주세요 : ");
            newPsw = sc.nextLine();
            System.out.println("비밀번호를 한 번 더 입력해주세요 : ");
            String checkPsw = sc.nextLine();
            if (newPsw.equals(checkPsw)) {
                break;
            } else {
                System.out.println("입력하신 비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
            }

        }

        mq.insertMember(newName, newAge, newId, newPsw);
        MemberDTO newMember = new MemberDTO(newName, newAge, newId, newPsw, mileage);
        return newMember;
    }


    public String IdDuplicateCheck() {
        while (true) {
            System.out.println("사용하실 ID를 입력해주세요. : ");
            String newId = sc.nextLine();
            Boolean isDuplicate = false;
            for (MemberDTO member : memberList) {
                if (member.getId().equals(newId)) {
                    isDuplicate = true;
                    break;
                }

            }
            if (isDuplicate) {
                System.out.println("이미 사용중인 아이디 입니다. 다시 입력해주세요.");
            } else {
                return newId;
            }

        }
    }

    // 회원 로그인 메소드
    public MemberDTO memberLogin() {

        System.out.println("==============================================");
        while (true) {
            System.out.print("아이디를 입력하세요: ");
            String inputID = sc.nextLine();
            System.out.println("==============================================");
            System.out.print("비밀번호를 입력하세요: ");
            String inputPsw = sc.nextLine();

            MemberDTO nowLoginMember;
            for (MemberDTO member : memberList) {
                if (member.getId().equals(inputID) && member.getPwd().equals(inputPsw)) {
                    nowLoginMember = member;
                    return nowLoginMember;
                }
            }
            System.out.println("==============================================");
            System.out.println("로그인 정보가 일치하지 않습니다. 다시 시도해주세요.");

        }
    }

    public void nonMemberLogin() {
        String phone;
        while (true) {
            System.out.println("==============================================");
            System.out.print("핸드폰 번호를 입력해주세요 (- 생략) \n: ");
            phone = sc.nextLine();
            if (phone.length() == 11) {
                break;
            } else {
                System.out.println("010을 포함한 11자리로 다시 입력해주세요.");
            }
        }
        this.nonMemberPhone = phone;
        String psw;
        while (true) {
            System.out.println("==============================================");
            System.out.print("사용하실 비밀번호를 입력해주세요 \n: ");
            psw = sc.nextLine();
            System.out.print("비밀번호를 한 번 더 입력해주세요 \n: ");
            String checkPsw = sc.nextLine();
            if (psw.equals(checkPsw)) {
                break;
            } else {
                System.out.println("==============================================");
                System.out.println("입력하신 비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
            }
        }
        this.nonMemberPsw = psw;
    }

    public void findID() {
        System.out.println("==============================================");
        while (true) {
            System.out.println("성함을 입력해주세요");
            String name = sc.nextLine();
            for (MemberDTO member : memberList) {
                if (member.getName().equals(name)) {
                    System.out.println(member.getId());
                    return;
                }
            }
            System.out.println("==============================================");
            System.out.println("일치하는 정보가 없습니다. 다시 시도해주세요.");
        }
    }

    public void findPwd() {
        System.out.println("==============================================");
        while (true) {
            System.out.println("성함을 입력해주세요.");
            String name = sc.nextLine();
            System.out.println("==============================================");
            System.out.println("ID를 입력해주세요.");
            String id = sc.nextLine();
            for (MemberDTO member : memberList) {
                if (member.getName().equals(name) && member.getId().equals(id)) {
                    System.out.println(member.getPwd());
                    return;
                }
            }
            System.out.println("==============================================");
            System.out.println("일치하는 정보가 없습니다. 다시 시도해주세요.");
        }
    }


}