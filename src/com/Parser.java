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
	protected BufferedReader bufferedReader;
    protected FileReader fileReader;
	
	private static final Logger LOGGER = Logger.getLogger( OutputGenerator.class.getName() );
	
	public Parser()
	{
		dependencyList = new ArrayList<String>();
		lineList =  new ArrayList<>();
	}

	public ArrayList<String> parseMakefile(File inputFile) {
 
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

    public ArrayList<String> parseTestFixture(File inputFile){
        ArrayList<String> classNames = new ArrayList<>();
        String line = "Default";
        int num = 0;
        System.out.println("Input File: " + inputFile.toString() + "\n");
        lineList = new ArrayList<>();



        try {
            fileReader = new FileReader(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(fileReader);

        try {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("class") && !line.contains("cout")){
                    line = line.replace("class", "");
                    line = line.replace("{", "");
                    lineList.add("Line: " + (num + 1) + ".) " + line);
                    System.out.println("Name of Class: " + line);
                    classNames.add(line);
                }
                num++;
            }
            System.out.println(classNames);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classNames;
    }


    public ArrayList<String> parseUnitTest(File inputFile){
        ArrayList<String> classNames = new ArrayList<>();
        String line = "Default";
        int num = 0;
        System.out.println("Input File: " + inputFile.toString() + "\n");
        lineList = new ArrayList<>();



        try {
            fileReader = new FileReader(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(fileReader);

        try {
            while ((line = bufferedReader.readLine()) != null) {


                num++;
            }
            System.out.println(classNames);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classNames;
    }

    public ArrayList<String> getLineList() {
        return lineList;
    }

    public void setLineList(ArrayList<String> lineList) {
        this.lineList = lineList;
    }
	
}
