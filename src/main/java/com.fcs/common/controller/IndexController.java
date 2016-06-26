package com.fcs.common.controller;

import com.jfinal.core.Controller;

/**
 * Created by Lucare.Feng on 2016/6/25.
 */
public class IndexController extends Controller {

    public void index(){
        render("/pages/index.html");
    }

    public void welcome(){
        render("/pages/index_v2.html");
    }
}
