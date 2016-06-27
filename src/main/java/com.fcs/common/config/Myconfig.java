package com.fcs.common.config;

import com.fcs.admin.controller.AdminController;
import com.fcs.common.controller.IndexController;
import com.fcs.wechat.PageController;
import com.fcs.wechat.WeixinApiController;
import com.fcs.wechat.WeixinMsgController;
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

/**
 * Created by Lucare.Feng on 2016/6/22.
 */
public class Myconfig extends JFinalConfig {

    /**
     * 如果生产环境配置文件存在，则优先加载该配置，否则加载开发环境配置文件
     * @param pro 生产环境配置文件
     * @param dev 开发环境配置文件
     */
    public void loadProp(String pro, String dev) {
        try {
            PropKit.use(pro);
        }catch (Exception e) {
            PropKit.use(dev);
        }
    }

    public void configConstant(Constants constants) {
        loadProp("config_pro.txt", "config.txt");
        constants.setDevMode(true);
        constants.setViewType(ViewType.VELOCITY);
    }

    public void configRoute(Routes routes) {
        routes.add("/", IndexController.class);
        routes.add("/admin", AdminController.class);
        routes.add("/msg", WeixinMsgController.class);
        routes.add("/api", WeixinApiController.class);
        routes.add("/page", PageController.class);

    }

    public void configPlugin(Plugins plugins) {
        String url = PropKit.get("jdbcUrl");
        String user = PropKit.get("user");
        String pass = PropKit.get("password");
        C3p0Plugin c3p0Plugin = new C3p0Plugin(url, user, pass);
        plugins.add(c3p0Plugin);
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(c3p0Plugin);
        plugins.add(activeRecordPlugin);
        activeRecordPlugin.addMapping("user", com.fcs.admin.model.Admin.class);
        activeRecordPlugin.setDialect(new MysqlDialect());
        activeRecordPlugin.setShowSql(true);
    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }
}
