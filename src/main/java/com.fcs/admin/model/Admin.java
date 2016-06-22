package com.fcs.admin.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by Lucare.Feng on 2016/6/22.
 */
public class Admin extends Model<Admin>{

    public static final Admin me = new Admin();

    @Override
    public List<Admin> find(String sql) {
        return super.find(sql);
    }
}
