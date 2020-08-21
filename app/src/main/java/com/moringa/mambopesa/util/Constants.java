package com.moringa.mambopesa.util;

import com.moringa.mambopesa.BuildConfig;

public class Constants {
    //the api key for this api is provided as a parameter
    public static final String FOREX_BASE_URL = "https://fcsapi.com/api-v2/forex/";
    public static final String FOREX_API_KEY =  BuildConfig.FOREX_API_KEY;
    //used diff api for currency conversion, no api key required
    public static final String CONVERSION_BASE_URL = "https://api.frankfurter.app/";
    //database child node name
    public static final String FIREBASE_CHILD_BUDGET_PLANNER = "budgetPlanner";
}
