import java.util.Scanner;
import java.util.HashMap;

public class urldatabase {
	static HashMap<String, String[]> urlDb = new HashMap<String, String[]>();
	
	static String generateShortkey(String url) {
		/*
		 * ShortKey logic = Url Length + first 5 char of url. If url less than 5 char, then take full url.
		 */
		String shortKey = "";
		if(url.length() > 5) {
			 shortKey = url.length() + url.substring(0,5);
		}else {
			 shortKey = url.length() + url.substring(0,url.length());
		}
		System.out.println("Short Key : " + shortKey);
		return shortKey;
	}
	
	static void storeurl(String url) {
		//System.out.println("You are in storeurl method, URL = " + url);
		String shortKey = generateShortkey(url);
		int count = 0;
		
		if(urlDb.get(url) == null) {
			String Strcount = String.valueOf(count);
			String[] urlDataSet = {shortKey,Strcount};
			//System.out.println(uralDataSet);
			urlDb.put(url,urlDataSet);
			System.out.println("**** Sucessfully added URL into DataBase *****");
		}else {
			System.out.println("**** Url already presnt in DB ****");
		}
		//System.out.println(urlDb);
	}
	
	static void get(String url) {
		//System.out.println("You are in get method, URL = " + url);
		if(urlDb.get(url) != null) {
			String shortKey = urlDb.get(url)[0];
			int count = Integer.parseInt(urlDb.get(url)[1]);
			count = count+1;
			String newStrcount = String.valueOf(count);
			String[] newurlDataSet = {shortKey,newStrcount};
			urlDb.put(url,newurlDataSet);
			System.out.println("Short Key : " + urlDb.get(url)[0]);
		}else {
			System.out.println("Url not presnt in DB, use storeurl command to add url into db");
		}
	}
	
	static void count(String url) {
		//System.out.println("You are in count method, URL = " + url);
		if(urlDb.get(url) != null) {
			int count = Integer.parseInt(urlDb.get(url)[1]);
			System.out.println("URL - " + url + " hit count = " + count);
		}else {
			System.out.println("Url not presnt in DB, use storeurl command to add url into db");
		}
	}
	
	static void list() {
		//System.out.println("You are in list method");
		if(urlDb.isEmpty() != true) {
			System.out.println("   URL			   Hit Count   ");
			for (String url : urlDb.keySet()) {
				  System.out.println(" " + url + "			" + urlDb.get(url)[1]);
				}
		}else {
			System.out.println("Url database is empty!!!");
		}
	}
	
	public static void main(String[] args) {
		String operation = "";
		String url = "";
		
		System.out.println("Available Commands - ");
		System.out.println("	storeurl <url> : To store the given URL");
		System.out.println("	get <url>  : return the unique short key");
		System.out.println("	count <url> : latest usage count");
		System.out.println("	list :	return all urls and counts");
		System.out.println("	exit :	to exit the programe");
		
		while(true) {
			//System.out.println("Current UrlDB :" + urlDb);
			System.out.println("\n\n#############################################\n\n");
			System.out.println("Enter a valid command : ");
			Scanner scanObj = new Scanner(System.in);
		    String command = scanObj.nextLine();
		    command = command.trim();
		    
	     	String[] splitString = command.split("\\s+");
	     	//System.out.println(splitString.length);
	    
		    if(splitString.length <= 2) {
		    	operation = new String(splitString[0]);
		    	if(splitString.length == 2) {
		    		url = new String(splitString[1]);
		    	}
		    }else {
		    	System.out.println("Seems like you have more parameters along with your command, Enter valid command with parameter.");
		    	continue;
		    }
	     	//System.out.println(operation + url);
	     	
	     	if(operation.equals(new String("storeurl"))) {
	    		//System.out.println("Your command  : " + operation);
	    		storeurl(url);
	    	}else if(operation.equals(new String("get"))) {
	    		//System.out.println("Your command  : " + operation);
	    		get(url);
	    	}else if(operation.equals(new String("count"))) {
	    		//System.out.println("Your command  : " + operation);
	    		count(url);
	    	}else if(operation.equals(new String("list"))) {
	    		//System.out.println("Your command  : " + operation);
	    		list();
	    	}else if(operation.equals(new String("exit"))) {
	    		System.out.println("Your are Exiting from Programme !! Good Bye !! See You Again !! ");
	    		System.exit(0);
	    	}else {
	    		System.out.println("Invalid Command " + operation);
	    	}
	     	operation = "";
    		url = "";
	    }
	    
	}

}
