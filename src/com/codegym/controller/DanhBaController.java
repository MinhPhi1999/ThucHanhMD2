package com.codegym.controller;

import com.codegym.model.DanhBa;
import com.codegym.service.DanhBaIMPL;

import java.util.List;

public class DanhBaController  {
    private DanhBaIMPL danhBaIMPL = new DanhBaIMPL();

    public List<DanhBa> showDanhBaList() {
        return danhBaIMPL.findAll();
    }

    public void addDanhBa(DanhBa danhBa) {
        danhBaIMPL.save(danhBa);
        danhBaIMPL.findAll();
    }
    public void removeDanhBa(String telephoneNumber){
        danhBaIMPL.remove(telephoneNumber);
    }
    public void getDanhBaByNumber(String telephoneNumber){
         danhBaIMPL.getDanhBaByNumber(telephoneNumber);
    }
}
