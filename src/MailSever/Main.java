package MailSever;
import library.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import controls.MainForm;
import controls.TrashForm;
import controls.composeForm;
import controls.contactForm;
import controls.inboxForm;
import controls.sendForm;

import library.doubleLinkedList;
import library.singlyLinkedList;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	String newPath = "data_base//" + "accounts//+ID.txt";
        File email = new File(newPath);
        email.mkdir();
    	Tools.openForm(new GUI());
    }
}
    
    
    
   


