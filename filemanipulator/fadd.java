package filemanipulator; // To Import the package in any other pgm
import java.util.*;
import java.io.*;
import java.lang.*;
public class fadd
{
	public static void main(String[] args)
	{
		mobileValidator mv=new mobileValidator();
		Scanner sc=new Scanner(System.in);
		String filename="E:/internprojects/filemanipulator/stu.txt"; 
		String data=null;
		BufferedReader br=null;
		InputStreamReader isr=null;
		FileReader fr=null;
		FileWriter fw=null;
		BufferedWriter bw=null;
		File file =new File(filename); // Creates a file object
		try
		{
			if(file.createNewFile()) // If file not present
			{
				System.out.println("Sorry Data under maintenance\n");				
			}
		}
		catch(IOException e)
		{
			System.out.println("Error\n");
			e.printStackTrace();
		}
		while(true)
		{
			System.out.println("Enter your choice\n1.View\n2.Insert\n3.Update\n4.Exit");
			int value=sc.nextInt(); // To check for the syntax of integer
			if(value ==4)
				break; //To terminate
			switch(value)
			{
				case 1:
					try
					{
					        fr =new FileReader(filename);
					        br = new BufferedReader(fr);
						String line;
						while((line=br.readLine())!=null)
							System.out.println(line); // Prints file data line by line
					}
					catch(IOException e)
					{
						System.out.println("Problem\n");
						e.printStackTrace(); // Prints the error
					}
					break;
				case 2:
					try
					{
						StringBuffer buff=new StringBuffer();
						isr =new InputStreamReader(System.in);
						System.out.println("Enter the uid\n");
						int uid=sc.nextInt();
						String struid=Integer.toString(uid);
						buff.append(struid);
						buff.append(" ");
						System.out.println("Enter the name\n");
						br=new BufferedReader(isr);
						String name=br.readLine();
						buff.append(name);
						buff.append(" ");
						System.out.println("Enter the college name\n");
						br=new BufferedReader(isr);
						String college=br.readLine();
						buff.append(college);
						buff.append(" ");
						System.out.println("Enter the mobile number\n");
						br=new BufferedReader(isr);
						String mobile=br.readLine();
						if(mv.isValid(mobile))
							buff.append(mobile);
						else
						{
							System.out.println("Check the number\n");
							System.exit(0);
						}
						fw=new FileWriter(filename,true); // Write the file in append mode
						 bw = new BufferedWriter(fw);
						bw.write(buff.toString());
						bw.flush(); // To write the file data to file
						bw.write("\n");
						bw.close(); // Close the stream writer
						
					}
					catch(IOException e)
					{
						System.out.println("Problem\n");
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Enter the id to be replaced\n");
					int id=sc.nextInt(); // Validates the input
					String strid=Integer.toString(id); // Convert it to string for easy validation
					System.out.println("Enter the name/subject to be replaced\n");
					try
					{
						isr =new InputStreamReader(System.in);
						br = new BufferedReader(isr);
						data=br.readLine(); // Get the word to be replaced 
						System.out.println("Enter the  replacement word\n");
						String rep=br.readLine(); // Get the replacement word
						fr =new FileReader(filename);
					        br = new BufferedReader(fr);
						String line;
						StringBuffer buff=new StringBuffer(); // Create a string buffer to change string dynamically
						while((line=br.readLine())!=null)
						{
								int index=line.indexOf(' '); // Sets the end index of first word
								String idval=line.substring(0,index);
								if(idval.equals(strid))  // If both id's matches 
								{
									line=line.replaceAll("\\b"+data+"\\b",rep); // replaces the string only (not substring) Uses word boundary
									buff.append(line);
									buff.append('\n');
								}
								else
								{
									buff.append(line);
									buff.append('\n');
								}
						}
						fw=new FileWriter(filename);
						bw = new BufferedWriter(fw);
						bw.write(buff.toString()); // Convert to string and write 
						bw.flush();
					}
					catch(IOException e)
					{
						System.out.println("Problem\n");
						e.printStackTrace();
					}
					break;
			}
			
		}
	}
}
