package PasswordManager;

import javax.xml.crypto.Data;

/**
 * @author Nathan Premo
 * file Name: DatabaseTableCreation
 * This class is going to contain the methods that will create
 * the tables on the database.
 */

public class DatabaseTableCreation {

    /**
     * this is the method that sets up the database.
     * First it makes sure there are no tables and then it makes the tables.
     * @param db this is the database connection object.
     */
    public static void Setup(DatabaseConnectionInfo db){
        dropTables(db);
        makeTables(db);
    }
    /**
     * this method is going to go through the database and drop all the tables
     * so they can be remade if needed.
     * @param db this is the database object that contains all the connection
     *           information.
     *
     */
    public static void dropTables(DatabaseConnectionInfo db){
        String tables[] = {"PasswordUserTable", "GroupPasswordsTable", "ChangeTable",
                           "GroupUsersTable", "PasswordsTable",  "GroupTable", "UsersTable"};
        StringBuilder sb = new StringBuilder();
        for (String table:tables) {
            sb.delete(0, sb.length());
            sb.append("drop table IF EXISTS " + table + ";");
            db.excuteUpdate(sb.toString());
        }
    }

    /**
     * this is the method that pulls all the make table methods together
     * @param db this is the database object that contains the connection information
     */
    public static void makeTables(DatabaseConnectionInfo db){
        MakeUsersTable(db);
        MakePasswordsTable(db);
        MakeGroupTable(db);
        MakeChangeTable(db);
        MakeGroupUsersTable(db);
        MakeGroupPasswordsTable(db);
        MakePasswordUserTable(db);

    }

    /**
     * This is going to make the tables for the Users that are going to be able to log into the system
     * @param db this is the database object that contains the connection information
     */
    public static void MakeUsersTable(DatabaseConnectionInfo db){
        String command = "create table UsersTable(\n" +
                "    TUID INT AUTO_INCREMENT,\n" +
                "    UserName VarChar(25) NOT null,\n" +
                "    FirstName varChar(25) not null,\n" +
                "    LastName VarChar(25) not null,\n" +
                "    HashPassword varChar(30) not null, \n" +
                "    Salt varchar(30) not null,\n" +
                "    PermissionLevel boolean not null,\n" +
                "    activeFlag boolean not null,\n" +
                "    PRIMARY key(TUID)\n" +
                ");";
        db.excuteUpdate(command);
    }

    /**
     * This is going to make the password table where the password object is going to be stored
     * @param db this is the database object that contains the connection information
     */
    public static void MakePasswordsTable(DatabaseConnectionInfo db){
        String command = "create table PasswordsTable (\n" +
                "\tTUID int AUTO_INCREMENT,\n" +
                "\tPasswordName varChar(100) not null, \n" +
                "\tPasswordObject BLOB not null,\n" +
                "    activeFlag boolean not null,\n" +
                "    PRIMARY key(TUID)\n" +
                ");";
        db.excuteUpdate(command);
    }

    /**
     * this is going to be the group table where the groups the passwords and users can be assigned to will be
     * stored
     * @param db this is the database object that contains the connection information
     */
    public static void MakeGroupTable(DatabaseConnectionInfo db){
        String command = "create table GroupTable (\n" +
                "\tTUID int AUTO_INCREMENT,\n" +
                "    GroupName VarChar(25) not null,\n" +
                "    ActiveFlag boolean not null,\n" +
                "    PRIMARY key(TUID) \n" +
                ");";
        db.excuteUpdate(command);
    }

    /**
     * this is going to be the change table that keep changes made to the password objects
     * @param db this is the database object that contains the connection information
     */
    public static void MakeChangeTable(DatabaseConnectionInfo db){
        String command = "create table ChangeTable(\n" +
                "\tTUID int AUTO_INCREMENT,\n" +
                "    PasswordID Int not null,\n" +
                "    UserID int not null, \n" +
                "    WhatChange varChar(60)not null, \n" +
                "    DateChanged date not null,\n" +
                "    Primary key(TUID),\n" +
                "    FOREIGN Key(PasswordID) REFERENCES PasswordsTable(TUID),\n" +
                "    FOREIGN key(UserID) REFERENCES UsersTable(TUID)\n" +
                ");";
        db.excuteUpdate(command);
    }

    /**
     * this is going be the table where the users will be assigned to groups
     * @param db this is the database object that contains the connection information
     */
    public static void MakeGroupUsersTable(DatabaseConnectionInfo db){
        String command = "create table GroupUsersTable(\n" +
                "\tTUID int AUTO_INCREMENT,\n" +
                "    GroupID int not null,\n" +
                "    UserID int not null,\n" +
                "    PRIMARY key(TUID),\n" +
                "  \tFOREIGN key(GroupID) REFERENCES GroupTable(TUID)\n" +
                "    \ton DELETE CASCADE,\n" +
                "    FOREIGN KEY(userID) REFERENCES UsersTable(tuid)\n" +
                "    \ton DELETE CASCADE\n" +
                ");";
        db.excuteUpdate(command);
    }

    /**
     * this is going to be the table where password objects can be assigned to groups
     * @param db this is the database object that contains the connection information
     */
    public static void MakeGroupPasswordsTable(DatabaseConnectionInfo db){
        String command = "create table GroupPasswordsTable(\n" +
                "\tTUID int AUTO_INCREMENT,\n" +
                "    GroupID int not null,\n" +
                "    PasswordID int not null,\n" +
                "    PRIMARY key(tuid),\n" +
                "    FOREIGN key(groupID) REFERENCES GroupTable(TUID) \n" +
                "    \ton delete CASCADE,\n" +
                "    FOREIGN KEY(PasswordID) REFERENCES PasswordsTable(TUID)\n" +
                ");";
        db.excuteUpdate(command);
    }

    /**
     * this is the table where passwords can be assigned to individual users.
     * @param db this is the database object that contains the connection information
     */
    public static void MakePasswordUserTable(DatabaseConnectionInfo db){
        String command = "Create table PasswordUserTable(\n" +
                "\tTUID int AUTO_INCREMENT,\n" +
                "    UserID int not null,\n" +
                "    PasswordID int not null,\n" +
                "    primary key(TUID),\n" +
                "    FOREIGN key(UserID) REFERENCES UsersTable(TUID),\n" +
                "    FOREIGN key(PasswordID) REFERENCES PasswordsTable(TUID)\n" +
                ");";
        db.excuteUpdate(command);
    }





}//end of class
