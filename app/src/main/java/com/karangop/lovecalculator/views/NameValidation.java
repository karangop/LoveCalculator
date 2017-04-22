package com.karangop.lovecalculator.views;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by karan_000 on 21-04-2017.
 */

public class NameValidation {

    private MainCallback callback;

    public NameValidation(MainCallback callback) {
        this.callback = callback;
    }

    public void validate(String fname, String sname){
        if (fname.trim().length() == 0) {
            callback.fnameValidate();

        } else if (sname.trim().length() == 0) {
            callback.snameValidate();

        } else {
            Map<String, String> query = new HashMap<>();
            query.put("fname", fname);
            query.put("sname", sname);
            callback.success(query);

        }
    }
}
