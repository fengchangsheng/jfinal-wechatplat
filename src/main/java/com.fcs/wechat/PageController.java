package com.fcs.wechat;

import com.jfinal.core.Controller;

/**
 * Created by Lucare.Feng on 2016/6/27.
 */
public class PageController extends Controller {


    public void photo() {
        render("/pages/material/photo.html");
    }
}
