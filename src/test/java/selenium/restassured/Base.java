package selenium.restassured;

import selenium.common.HttpCallManager;

public abstract class Base {
    protected static final String URL = "https://reqres.in/";
    protected HttpCallManager httpCallManager = new HttpCallManager();
}
