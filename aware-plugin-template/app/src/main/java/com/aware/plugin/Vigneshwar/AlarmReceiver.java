package com.aware.plugin.Vigneshwar;

/**
 * Created by Vigneshwar on 20-04-2015.
 */

import com.aware.ESM;
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;

public class AlarmReceiver extends BroadcastReceiver {
    private static final String MORNINGJSON = "[{'esm':{" +
            "'esm_type':" + ESM.TYPE_ESM_TEXT + "," +
            "'esm_title': 'Mood evaluator'," +
            "'esm_instructions': 'How happy do you feel today? Rate on a scale of 1 to 10 (10 being best)'," +
            "'esm_submit': 'Submit.'," +
            "'esm_expiration_threashold': 3600," +
            "'esm_trigger': 'com.aware.plugin.goodmorning'" +
            "}}]";

    public AlarmReceiver()
    {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent queue_esm = new Intent(ESM.ACTION_AWARE_QUEUE_ESM);
        String esmJSON = MORNINGJSON;
        queue_esm.putExtra(ESM.EXTRA_ESM, esmJSON);
        context.sendBroadcast(queue_esm);
    }
}