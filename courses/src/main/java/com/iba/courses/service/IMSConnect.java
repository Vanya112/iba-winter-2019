package com.iba.courses.service;

import com.ibm.ims.connect.*;
import org.springframework.stereotype.Service;
import sun.management.snmp.jvminstr.JvmOSImpl;

import java.net.SocketException;

@Service
public class IMSConnect {

    private final String USER_ID = "LAPUSHA";
    private final String PASSWORD = "LAPUSHA2";
    private final String HOST = "172.20.2.116";
    private ConnectionFactory connectionFactory;
    private Connection connection;
    private TmInteraction tmInteraction;


    public void init() throws Exception {
        try {
            IMSProperties imsParameters = new IMSProperties(HOST, "*SAMPL1*", 7003, "IVP1", USER_ID, PASSWORD);
            this.connectionFactory = new ConnectionFactory();
            this.connectionFactory.setHostName(imsParameters.getHostName());
            this.connectionFactory.setPortNumber(imsParameters.getPort());
            this.connectionFactory.setSocketType(ConnectionFactory.SOCKET_TYPE_PERSISTENT);
            this.connection = this.connectionFactory.getConnection();
            this.tmInteraction = this.connection.createInteraction();

            /* Interaction settings */
            this.tmInteraction.setImsConnectTimeout(5000);
            this.tmInteraction.setInteractionTimeout(50000);
            this.tmInteraction.setTrancode("");
            this.tmInteraction.setInputMessageDataSegmentsIncludeLlzzAndTrancode(false);
            this.tmInteraction.setCommitMode(ApiProperties.COMMIT_MODE_0);
            this.tmInteraction.setResponseIncludesLlll(true);
            this.tmInteraction.setInteractionTypeDescription(ApiProperties.INTERACTION_TYPE_DESC_SENDRECV);
            this.tmInteraction.setImsConnectUserMessageExitIdentifier(imsParameters.getTmInteraction());
            this.tmInteraction.setImsDatastoreName(imsParameters.getDataStore());
            /* RACF settings */
            this.tmInteraction.setRacfUserId(imsParameters.getUserID());
            this.tmInteraction.setRacfPassword(imsParameters.getPassword());
            this.tmInteraction.setRacfGroupName("");
            this.tmInteraction.setRacfApplName("");
        } catch (Exception e) {
            throw new Exception("Can't set IMS connection properties. IMS Connect API message: " + e.getMessage(), e);
        }
    }

    public void connect() throws Exception{
        try {
            this.connection.connect();
        } catch (SocketException e) {
            throw new Exception("Can't initialize IMS Connection. Can't open socket", e);
        } catch (Exception e) {
            throw new Exception("Can't initialize IMS Connection. IMS Connect API message: " + e.getMessage(), e);
        }

    }

    public String execute(String command) throws Exception{
        try {
            InputMessage inputMessage = this.tmInteraction.getInputMessage();
            inputMessage.setInputMessageData(command.getBytes(tmInteraction.getImsConnectCodepage()));
            this.tmInteraction.execute();
            OutputMessage outputMessage;
            outputMessage = tmInteraction.getOutputMessage();
            return outputMessage.getDataAsString();
        } catch (Exception e) {
            throw new Exception("Error while executing command. IMS Connect API message: " + e.getMessage(), e);
        }

    }

}
