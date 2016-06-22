package com.fcs.admin.controller;

import com.fcs.admin.model.Admin;
import com.jfinal.core.Controller;

import java.util.List;

/**
 * Created by Lucare.Feng on 2016/6/22.
 */
public class AdminController extends Controller {

    public void index() {
        List<Admin> admins = Admin.me.find("select * from user");
        for (Admin admin : admins) {
            System.out.println(admin.get("username"));
        }
        render("/pages/index.html");
    }

}
