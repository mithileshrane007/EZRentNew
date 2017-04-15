package com.example.infiny.ezrent.data.db;


import com.example.infiny.ezrent.data.db.model.User;

import io.reactivex.Observable;

public interface DbHelper {

    Observable<Long> insertUser(final User user);

    Observable<User> getAllUser();
}
