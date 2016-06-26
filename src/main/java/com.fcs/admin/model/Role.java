package com.fcs.admin.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by Lucare.Feng on 2016/6/25.
 */
public class Role extends Model<Role> {
    public static final Role me = new Role();

    public List<Role> findList(){
        return super.find("select * from role where enabled = 1");
    }
}
