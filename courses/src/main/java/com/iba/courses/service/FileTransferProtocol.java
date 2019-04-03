package com.iba.courses.service;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FileTransferProtocol {

    private final String sName = "172.20.2.116";

    public void submit ()  {
        String serverName =sName  ;
        String userName ="USER14F" ;
        String password ="V12" ;
        FTPClient ftp = new FTPClient() ;
        //Connect to the server
        try {
            ftp.connect (serverName) ;
            String replyText =ftp.getReplyString()  ;
            System.out.println (replyText) ;
        }
        catch (Exception  e)  {
            e.printStackTrace () ;
        }
        //Login to the server
        try {
            ftp.login (userName, password) ;
            String replyText = ftp.getReplyString() ;
            System.out.println (replyText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Tell server that the file will have JCL records
        try {
            ftp.site ("filetype=jes") ;
            String replyText = ftp.getReplyString() ;
            System.out.println (replyText) ;
        }
        catch  (Exception e) {
            e.printStackTrace() ;
        }
        //Submit the job from the text file.Use \\ to avoid using escape notation
        try {
            FileInputStream inputStream = new FileInputStream ("D:\\papka\\job.txt.txt") ;
            ftp.storeFile (serverName,inputStream) ;
            String replyText = ftp.getReplyString() ;
            System.out.println (replyText) ;
        }
        catch  (Exception e) {
            e.printStackTrace() ;
        }
        //Quit the server
        try {
            ftp.quit() ;
        }
        catch  (Exception e) {
            e.printStackTrace() ;
        }
    }
}
