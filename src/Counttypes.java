import Java.io.BufferedReader;
import Java.io.File;
import Java.io.FileReader;
import Java.io.InputStreamReader;
import Java.io.PrintWriter;
import Jave.net.ServerSocket;
import Java.net.Socket;
import Java.util.Scanner;
import Java.util.Properties;
import Java.util.stream.Stream;


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
		Properties proper = new Properties();
		//for (String arg: args) this is to iterate through the entire string
		for (int i=0;i<args.length;i++)
		{ switch (args[i])
			{ case"--Help":
			  case "-h":
				  usage();
				  System.exit(0);
			  case "-f":
				  //System.out.println(args[i]);
				  loadFile(args[i+1]);
				  i++;
				  break;
			  case "-s":
				  loadFileStream(args[i+1]);
				  i++;
				  break;
			  case "-i":
				  loadStdIn();
				  break;
			  case "--server":
				  server();
				  break;
			  default: 
				  System.out.println("Unknown parameter " + args[i]);
				  System.exit(1);


			}

		}

//		String filename = args[0]; // when i run the program anything i type after the command
					   // java Counttypes filename 
					   // it will be stored as the filename inside the program
					   // it is an array of arguments
					   //System.out.println("Number of args: " + args.length);
					   //System.out.println(filename);
//		File FileNameEntry = new File(filename);
//		Scanner readingFile = new Scanner(FileNameEntry);
//		readingFile.useDelimiter("\n"); //This is to change the default dilimiter space
					      	//As of this point scanner wil use the delimiter new line
//		while (readingFile.hasNext())
//		{ 
//			System.out.println(readingFile.next());
//		}
		}
	}
//		Counttypes greet = new Counttypes();
//		System.out.println(greet.greeting);
	public static void usage()
	{ System.out.println("Improper usage...");

	}

	public static void loadStdIn()
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Stream<String> lines = br.lines();
		lines.forEach(System.out::println);// :: stands for referance to
	}
	public static void loadFileStream(String filename) throws Exception
	{
		new BufferedReader(new FileReader(filename)).lines().forEach(System.out::println);

	}

		//Stream<String> lines = new BufferedReader(new InputStreamReader(System.in)).lines();
		//This above line is standing for the three lines
//	}
	public static void loadFile(String filename) throws Exception
	{
		File FileNameEntry = new File(filename);
		Scanner readingFile = new Scanner(FileNameEntry);
		readingFile.useDelimiter("\n");
		while (readingFile.hasNext())

		{ 	String[] columns = readingFile.next().split(",");
			//for (String column : readingFile.next().split(","))
			System.out.println("Pokemon: " + columns[2]);

			//System.out.println(readingFile.next());
		}
		
	}
	public static void server() throws Exception
	{
		ServerSocket server = new ServerSocket(8080);
		while (server.isBound())
		{
			Socket incomingRequest = server.accept();
			Scanner sc = new Scanner(incomingRequest.getInputStream());
			PrintWriter out = new PrintWriter(incomingRequest.getOutputStream(), true);
			//System.out.println(sc.nextLine());
			out.println("HTTP/1.1 200 OK \r\nContent-Length: 28\r\n\r\n<h1>Hello from Server</h1>");
		}
	}
}
