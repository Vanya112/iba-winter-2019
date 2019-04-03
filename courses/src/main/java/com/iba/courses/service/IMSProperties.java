package com.iba.courses.service;

import org.springframework.stereotype.Service;

@Service
public class IMSProperties {

    String hostName;
    String tmInteraction;
    int port;
    String dataStore;
    String userID;
    String password;

    public IMSProperties(String hostName, String tmInteraction, int port, String dataStore, String userID, String password) {
        this.hostName = hostName;
        this.tmInteraction = tmInteraction;
        this.port = port;
        this.dataStore = dataStore;
        this.userID = userID;
        this.password = password;
    }

    public IMSProperties() {
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getTmInteraction() {
        return tmInteraction;
    }

    public void setTmInteraction(String tmInteraction) {
        this.tmInteraction = tmInteraction;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDataStore() {
        return dataStore;
    }

    public void setDataStore(String dataStore) {
        this.dataStore = dataStore;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
