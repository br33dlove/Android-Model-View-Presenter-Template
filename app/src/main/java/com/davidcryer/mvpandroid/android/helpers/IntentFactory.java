package com.davidcryer.mvpandroid.android.helpers;

import android.content.Context;
import android.content.Intent;

import com.davidcryer.mvpandroid.android.activities.EditAddressActivity;

public class IntentFactory {

    public static Intent getInputFieldActivityIntent(final Context context) {
        return new Intent(context, EditAddressActivity.class);
    }
}
