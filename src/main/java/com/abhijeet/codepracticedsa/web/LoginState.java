package com.abhijeet.codepracticedsa.web;

import com.abhijeet.codepracticedsa.submission.domain.UserEntry;

public class LoginState {
    private static boolean isAuthenticated = false;
    private static UserEntry userEntry = null;

    public static boolean isIsAuthenticated() {
        return isAuthenticated;
    }

    public static void unsetAuthentication() {
        LoginState.isAuthenticated = false;
        LoginState.userEntry = null;
    }

    public static void setAuthentication(UserEntry userEntry) {
        if(userEntry != null) {
            LoginState.isAuthenticated = true;
            LoginState.userEntry = userEntry;
        }else{
            LoginState.isAuthenticated = false;
            LoginState.userEntry = null;
        }
    }

    public static UserEntry getUserEntry() {
        return userEntry;
    }

    public static void setUserEntry(UserEntry userEntry) {
        LoginState.userEntry = userEntry;
    }
}
