package com.loong.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.loong.componentbase.service.IAccountService;

public class AccountService implements IAccountService {
    @Override
    public boolean isLogin() {
        return AccountUtils.userInfo != null;
    }

    @Override
    public String getAccountId() {
        return AccountUtils.userInfo == null ? null : AccountUtils.userInfo.getAccountId();
    }

    @Override
    public Fragment newUserFragment(Activity activity, int containerId, FragmentManager manager, Bundle bundle, String tag) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment userFragment = new UserFragment();
        transaction.add(containerId, userFragment, tag);
        transaction.commit();
        return userFragment;
    }
}
