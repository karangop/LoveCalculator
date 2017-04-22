package com.karangop.lovecalculator.views;

import java.util.Map;

/**
 * Created by karan_000 on 21-04-2017.
 */

public interface MainCallback {

    void fnameValidate();
    void snameValidate();
    void success(Map<String,String> queryMap);
}
