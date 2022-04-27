package com.codegym.view;

import com.codegym.config.ConfigReadAndWriteFile;
import com.codegym.controller.DanhBaController;
import com.codegym.model.DanhBa;

import java.util.List;
import java.util.Scanner;

public class MenuView {
    Scanner scanner = new Scanner(System.in);
    DanhBaController danhBaController = new DanhBaController();
    String path = "E:\\IdeaProjects\\QuanLyDanhBa\\src\\com\\codegym\\data\\danhba.txt";
    List<DanhBa> danhBaList = new ConfigReadAndWriteFile<DanhBa>().readFromFile(path);

    public void MainMenuView() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng: ");
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    showListDanhBa();
                    break;
                case 2:
                    addDanhBa();
                    break;
                case 4:
                    removeDanhBa();
                    break;
                case 5:
                    findByNumber();
                    break;
                case 3:
                case 6:
                case 7:
                case 8:
                    System.out.println("khó quá em chưa làm kịp");
                    break;
                default:
                    System.out.println("nhập các số trên kia thôi bạn ơiiii");
                    new MenuView().MainMenuView();
            }
        } catch (Exception e) {
            System.err.println("nhập số trên kia thôi bạn ơi");
            new MenuView().MainMenuView();
        }
    }

    public void showListDanhBa() {
        System.out.println("----DANH SÁCH DANH BẠ----");
        if (danhBaList.size() == 0) {
            System.out.println("CHƯA CÓ SỐ NÀO ĐÂU BẠN ƠI");
            new MenuView().MainMenuView();
        } else {
            System.out.println(danhBaController.showDanhBaList());
        }
        System.out.println("nhấn 'quit' để trở về menu");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("quit")) {
            new MenuView().MainMenuView();
        } else {
            System.err.println("nhập quit thôi mà không nhập được. kém thật!!!");
            showListDanhBa();
        }
    }

    public void addDanhBa() {
        while (true) {
            System.out.println(danhBaList);
            System.out.println("nhập số mới: ");
            String telephoneNumber = scanner.nextLine();
            System.out.println("nhập group");
            String group = scanner.nextLine();
            System.out.println("nhập tên");
            String name = scanner.nextLine();
            System.out.println("nhập giới tính");
            String sex = scanner.nextLine();
            System.out.println("nhập địa chỉ");
            String address = scanner.nextLine();
            System.out.println("nhập ngày tháng năm sinh");
            String birthday = scanner.nextLine();
            System.out.println("nhập email");
            String email = scanner.nextLine();

            DanhBa danhBa = new DanhBa(telephoneNumber, group, name, sex, address, birthday, email);
            danhBaController.addDanhBa(danhBa);
            System.out.println(danhBaList);
            String choice = "";
            while (!choice.equalsIgnoreCase("yes") || !choice.equalsIgnoreCase("no")) {
                System.out.println("bạn muốn thêm DANH BẠ tiếp không?(yes/no)");
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    addDanhBa();
                } else if (choice.equalsIgnoreCase("no")) {
                    new MenuView().MainMenuView();
                } else {
                    System.err.println("chỉ yes và no thôi bro");
                }
            }
        }
    }

    public void removeDanhBa() {
        System.out.println(danhBaController.showDanhBaList());
        System.out.println("bạn muốn xóa số nào");
        String telephoneNumber = scanner.nextLine();
        danhBaController.removeDanhBa(telephoneNumber);
        System.out.println("XÓA THÀNH CÔNG");
        System.out.println("danh bạ còn lại:");
        System.out.println(danhBaController.showDanhBaList());
        System.out.println("nhấn 'quit' để trở về menu");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("quit")) {
            new MenuView().MainMenuView();
        } else {
            System.err.println("nhập 'quit' thôi mà không nhập được. kém thật!!!");
        }
    }


    public void findByNumber() {
        System.out.println("nhập số điện thoại");
        String telephoneNumber = scanner.nextLine();
        danhBaController.getDanhBaByNumber(telephoneNumber);
        danhBaController.getDanhBaByNumber(telephoneNumber);
        System.out.println("nhấn 'quit' để trở về menu");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("quit")) {
            new MenuView().MainMenuView();
        } else {
            System.err.println("nhập 'quit' thôi mà không nhập được. kém thật!!!");
        }
    }
}

