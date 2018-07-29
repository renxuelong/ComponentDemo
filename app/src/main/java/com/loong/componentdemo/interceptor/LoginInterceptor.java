package com.loong.componentdemo.interceptor;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.loong.componentbase.ServiceFactory;

@Interceptor(priority = 8, name = "登录状态拦截器")
public class LoginInterceptor implements IInterceptor {

    private Context context;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {

        // onContinue 和 onInterrupt 至少需要调用其中一种，否则不会继续路由
        if (postcard.getPath().equals("/share/share")) {
            if (ServiceFactory.getInstance().getAccountService().isLogin()) {
                callback.onContinue(postcard);  // 处理完成，交还控制权
            } else {
                callback.onInterrupt(new RuntimeException("请登录")); // 中断路由流程
            }
        } else {
            callback.onContinue(postcard);  // 处理完成，交还控制权
        }

    }

    @Override
    public void init(Context context) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        this.context = context;
    }
}
