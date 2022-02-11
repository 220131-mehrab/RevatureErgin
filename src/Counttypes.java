import Java.io.File;
import Java.util.Scanner;
class Counttypes
{
//	String greeting = "This is what i type as greeting";
	public static void main (String[] args) throws Exception
	{ 
	   if (args.length<1)
	   {
		System.out.println("\nError: No filename provided...");
		System.out.println("Usage: java Counttypes <filename>\n");
	   }  else
	     	{ 
		String filename = args[0]; // when i run the program anything i type after the command
					   // java Counttypes filename 
					   // it will be stored as the filename inside the program
					   // it is an array of arguments
					   //System.out.println("Number of args: " + args.length);
					   //System.out.println(filename);
		File FileNameEntry = new File(filename);
		Scanner readingFile = new Scanner(FileNameEntry);
		readingFile.useDelimiter("\n"); //This is to change the default dilimiter space
					      	//As of this point scanner wil use the delimiter new line
		while (readingFile.hasNext())
		{ 
			System.out.println(readingFile.next());
		}
		}
	}
//		Counttypes greet = new Counttypes();
//		System.out.println(greet.greeting);	
}
