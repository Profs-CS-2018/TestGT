package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Parser implements ParserI
{
	
	ArrayList<String> dependencyList;
	ArrayList<String> lineList;
	BufferedReader bufferedReader;
	
	private static final Logger LOGGER = Logger.getLogger( OutputGenerator.class.getName() );
	
	public Parser()
	{
		dependencyList = new ArrayList<String>();
		lineList =  new ArrayList<>();
	}

	public ArrayList<String> parseMake(File inputFile) {
 
		 String line = "";
	     int      num = 0;
		
		 try
		{
			bufferedReader = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
        try {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("#include") && !line.contains("iostream")) {
                    line = line.replace("#include", "");
                    line = line.replaceAll("\"", "");
                    lineList.add("Line: " + (num + 1) + ".) " + line);
                    //System.out.println("File Dependency: " + line);
                    dependencyList.add(line);
                }
                num++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dependencyList;
    }

	@Override
	public void parseCPP ()
	{

		// TODO Auto-generated method stub
		
	}

	@Override
	public void parseH ()
	{

		// TODO Auto-generated method stub
		
	}
	
}
