package com.example.infiny.ezrent.UI.login;

import android.content.Context;
import android.content.Intent;

/**
 * Created by infiny on 15/4/17.
 */

public class LoginActivity {
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }
}

