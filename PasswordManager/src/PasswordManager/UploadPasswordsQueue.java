package PasswordManager;

import java.util.LinkedList;
import java.util.Queue;

public class UploadPasswordsQueue extends Thread{
    /**
     * @author Nathan Premo
     * file: PasswordManager.UploadPasswordsQueue
     * This file is going to contain the information needed for the password queue that is going to
     * handle calling the uploading method for the password object. It is its own class because we have to
     * encode the object and we have to call the upload for each object so for preformance we are
     * making it on a different thread.
     * Varaibles
     *   passQueue this is a queue that contains the password object and its name. It will be used to upload the
     *             information. It will be made in uploadPasswords and processed for upload in run
     *   queueLoading - this is a boolean to tell if the uploadPasswords process is done so the thread for run will
     *                  know when it can stop.
     */

    protected Queue<queueObject> passQueue = new LinkedList();
    protected boolean queueLoadingFinished;
    //TODO fix the way the database is entered into this object.
    DatabaseConnectionInfo testing;
    public UploadPasswordsQueue(){
        queueLoadingFinished = false;
        testing = DatabaseConnectionManagement.decryptFile("NotThePermaPassword");
    }

    /**
     * This is going to add the password object to the queue.
     * @param obj this is the object that is going to be added to the queue
     */
    public void addPassObject(queueObject obj) {
        passQueue.add(obj);
    }

    /**
     * this is going to let the calling method tell the thread when it is done adding to the queue.
     * @param queueLoadingFinished
     */
    public void setQueueLoadingFinished(boolean queueLoadingFinished) {
        this.queueLoadingFinished = queueLoadingFinished;
    }

    public void run(){
        //this is going to run until both the queue is done being loaded and until it is empty.
        queueObject temp;
        int passwordCount =0;
        while(!queueLoadingFinished || !passQueue.isEmpty()){
            if(!passQueue.isEmpty()) {
                passwordCount++;
                System.out.println(passwordCount);
                temp = passQueue.remove();
                testing.uploadPassBlob(temp.passName, temp.data);
            }
        }
        ErrorMessage.infoBox("Password Upload Complete", "Upload Complete");


    }
}//end of class UploadPasswordsQueue

class queueObject{
    /**
     * this is just the object for the queue used to upload passwords.
     * I made it in the same class due to its size being so small
     * varables:
     *  passName - this is the name of the passwords
     *  data - this is teh password object.
     */
    String passName;
    byte[] data;

    /**
     * this is the method to create the object that is going to be placed
     * in the queue to be processed to upload
     * @param name this is the name of the password
     * @param data this is the password object in a byte array
     */

    public queueObject(String name, byte[] data){
        this.passName = name;
        this.data = data;
    };

    public String getPassName() {
        return passName;
    }

    public byte[] getData() {
        return data;
    }



}//end of class queueObject
