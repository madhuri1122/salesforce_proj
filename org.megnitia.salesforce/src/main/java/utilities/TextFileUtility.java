package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

//how to access data from text file(.txt or .csv)
public class TextFileUtility 
{
	//there is a chance of multiple text files with test data in our project
	public static String[] getValueInTextFile(String filepath,int linenumber) throws Exception
	{
		//Access existing text file or csv file,which consists of test data
		File f = new File(filepath);
		//take read permission 
		FileReader fr = new FileReader(f);
		//and shift in to RAM
		BufferedReader br = new BufferedReader(fr);
		//move up to a line which is the before line for required in sequential text file
		//in text file if you want to lth line we can move to l-1
		for(int i=1;i<linenumber;i++)//it will read up to 3 lines(given line no 4)
		{
			br.readLine();//we did not take data jest reading up to before line of our required line
		}
		//came to 4th line
		//read required line(4th line)
		String temp = br.readLine();
		String output[] = temp.split(",");//split , and save in array
		br.close();
		fr.close();
		return(output);//return multiple values as one array
	}
	//we can give 2 inputs(filepath,linenumber) and we can get out as a multiple value of string array
    //for(int i=1;i<=linenumber-1;i++)
}
