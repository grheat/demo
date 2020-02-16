package com.henry.controller;

import com.blade.mvc.RouteContext;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.ui.RestResponse;
import demo.SchedService1;
import demo.ThreadPool;

import java.util.concurrent.TimeUnit;

@Path
public class IndexController {
    @GetRoute("signin")
    @JSON
    public RestResponse doSignin(RouteContext ctx) {
        ThreadPool.INSTANCE.getInstance().scheduleAtFixedRate(new SchedService1(), 0, 3, TimeUnit.SECONDS);
        ThreadPool.INSTANCE.getInstance().schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试线程:" + Thread.currentThread().getName());
            }
        }, 0, TimeUnit.SECONDS);
        return RestResponse.ok();
    }

}
