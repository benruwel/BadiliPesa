package com.moringa.badilipesa.util;

import com.moringa.badilipesa.BuildConfig;

public class Constants {
    //the api key for this api is provided as a string in the url rather than a parameter or header
    public static final String CURENCYEX_BASE_URL = String.format("https://v1.nocodeapi.com/benruwel/cx/%s/", BuildConfig.CURRENCYEX_API_KEY);
}
