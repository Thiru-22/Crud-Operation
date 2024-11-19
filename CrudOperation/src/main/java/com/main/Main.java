package com.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.entity.HiberanteManager;
import com.entity.Registration;


public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HiberanteManager hm=new HiberanteManager();
		
		boolean loop=true;
		while(loop) {
			System.out.println("1.Create \n2.Read\n3.Update\n4.Delete\n5.Exit");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:{
				
			
				System.out.println("Enter the id:");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the name:");
				String name=sc.nextLine();
				System.out.println("Enter the email:");
				String email=sc.nextLine();
				System.out.println("Enter the dob(Format:dd/mm/yyyy):");
				String date=sc.next();
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
				Date dob=null;
				try {
					dob = sdf.parse(date);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				sc.nextLine();
				System.out.println("Enter the address:");
				String address=sc.nextLine();
				Registration reg=new Registration(id,name,email,dob,address);
				hm.add(reg);
				break;
			}
			case 2:{
				hm.allData();
				break;
			}
			case 3:{
				System.out.println("Enter the id:");
				int id=sc.nextInt();
				System.out.println("Enter the updated address:");
				sc.nextLine();
				String address=sc.nextLine();
				hm.update(id,address);
				break;
			}
			case 4:{
				System.out.println("Enter the id:");
				int id=sc.nextInt();
				hm.delete(id);
				break;
			}
			case 5:{
				loop=false;
				break;
			}
				
			}
		}
		
	}
}
