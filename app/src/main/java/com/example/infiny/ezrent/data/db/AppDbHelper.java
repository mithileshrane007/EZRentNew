package com.example.infiny.ezrent.data.db;


import com.example.infiny.ezrent.data.db.model.User;

import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDbHelper implements DbHelper {

//    private final DaoSession mDaoSession;
//
//    @Inject
//    public AppDbHelper(DbOpenHelper dbOpenHelper) {
//        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
//    }


    @Override
    public Observable<Long> insertUser(User user) {
        return null;
    }

    @Override
    public Observable<User> getAllUser() {
        return null;
    }
}
