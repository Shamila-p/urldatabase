############################################################################################
################################     urldatabase.java ######################################
############################################################################################

About:
This program will keep of visited url and its hit count.

Usage :
	javac urldatabase.java
	java urldatabase

Available Commands:
-------------------
	1 - Storeurl : Store the given url into the database.
			usage : storeurl <url>
			example : storeurl google.com
		If existing url passed, program will give a message that url already exist in data base.
	
	2 - get : To get the short key of a url. Each get will increase the hit count for that url. 
			usage : get <url>
			example : get google.com
		If the url is not present in DB, Program will give message as url is not available in databse.
		
	3 - count : Return the number of url hit.
			usage : count <url>
			example : count google.com
		If the url is not present in DB, Program will give message as url is not available in databse.
	
	4 - list : list all the url and its hit count availble 
			usage: list
	
	5 - exit : To exit the programme.

Few cases handled:
	- If user pass any other command other than above, Programme will notify to use that command is not valid.
	- If user pass valid command with more than url parameter, Programme will consider this as wrong command.
		example : 	storeurl google.com xyz - This is a wrong command.
				count google.com test test - This is a wrong command.