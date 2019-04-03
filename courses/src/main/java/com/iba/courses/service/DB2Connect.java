package com.iba.courses.service;

//import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.sql.*;
import java.util.Properties;
import com.ibm.ims.connect.*;
import org.hibernate.boot.model.relational.InitCommand;
import org.springframework.stereotype.Service;

@Service
public class DB2Connect {

    private Connection connection;
    private Statement statement;
    private final String USER_ID = "LAPUSHA";
    private final String PASSWORD = "LAPUSHA2";
    private final String HOST = "172.20.2.116";

    public void connect() throws Exception {
        try{
            String url = "jdbc:db2://"
                    + "172.20.2.116"
                    + ":" + "5035"
                    + "/" + "DALLASB";
            Properties properties = new Properties();
            properties.setProperty("user", USER_ID);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("connectionTimeout", "5000");
            properties.setProperty("commandTimeout", "5000");
            this.connection = DriverManager.getConnection(url, properties);
            this.connection.setAutoCommit(false);
            // checkStoredProcedureAvailability();
            this.statement = this.connection.createStatement();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception("failed connect");
        }

    }


public String execute(String command) throws Exception {
        try{
            CallableStatement callableStatement = this.prepare(command);
            callableStatement.execute();
            ResultSet resultSet = callableStatement.getResultSet();
            StringBuilder response = new StringBuilder("");
            while (resultSet.next()) {
                response.append(resultSet.getString(2));
                response.append("\n");
            }
            return response.toString();
        }
        catch (Exception e){
            throw new Exception("failed execute");
        }

}

    private CallableStatement prepare(String command) throws Exception {
        try{
            CallableStatement callableStatement = this.connection.prepareCall("CALL SYSPROC.ADMIN_COMMAND_DB2(?,?,?,?,?,?,?,?,?,?,?,?)");
            callableStatement.setString(1, command);
            callableStatement.setInt(2, command.length());
            callableStatement.setString(3, null);
            callableStatement.setString(4, null);
            callableStatement.registerOutParameter(5, Types.INTEGER);
            callableStatement.registerOutParameter(6, Types.INTEGER);
            callableStatement.registerOutParameter(7, Types.INTEGER);
            callableStatement.registerOutParameter(8, Types.INTEGER);
            callableStatement.registerOutParameter(9, Types.INTEGER);
            callableStatement.registerOutParameter(10, Types.INTEGER);
            callableStatement.registerOutParameter(11, Types.INTEGER);
            callableStatement.registerOutParameter(12, Types.VARCHAR);
            return callableStatement;
        }
        catch (Exception e){
            throw new Exception ("failed prepare");
        }
    }

}
