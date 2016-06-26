package com.fcs.admin.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by Lucare.Feng on 2016/6/25.
 */
public class Permission extends Model<Permission>{

    public static final Permission me = new Permission();

    public List<Permission> findList(){
        return super.find("select * from permission where pid = 0");
    }

}
