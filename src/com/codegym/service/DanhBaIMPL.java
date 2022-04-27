package com.codegym.service;

import com.codegym.config.ConfigReadAndWriteFile;
import com.codegym.model.DanhBa;

import java.util.List;

public class DanhBaIMPL implements IServiceGeneric<DanhBa> {
    public static String path = "E:\\IdeaProjects\\QuanLyDanhBa\\src\\com\\codegym\\data\\danhba.txt";
    public static List<DanhBa> danhBaList = new ConfigReadAndWriteFile<DanhBa>().readFromFile(path);

    @Override
    public List<DanhBa> findAll() {
        new ConfigReadAndWriteFile<DanhBa>().writeToFile(path, danhBaList);
        return danhBaList;
    }

    @Override
    public void save(DanhBa danhBa) {
        danhBaList.add(danhBa);
    }
    public void getDanhBaByNumber(String telephoneNumber){
        for (int i = 0; i < danhBaList.size(); i++) {
            if (telephoneNumber == danhBaList.get(i).getTelephoneNumber()){
                System.out.println(danhBaList.get(i));
            }
        }
    }
    public void remove(String telephoneNumber){
        for (int i = 0; i < danhBaList.size(); i++) {
            if (telephoneNumber == danhBaList.get(i).getTelephoneNumber()){
                danhBaList.remove(danhBaList.get(i));
                findAll();
            }
        }
    }

}
