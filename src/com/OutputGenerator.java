package com;


	import java.io.*;
	import java.util.ArrayList;
    import java.util.logging.Logger;

	public class OutputGenerator {

		private static final Logger LOGGER = Logger.getLogger( OutputGenerator.class.getName() );
		
	    public OutputGenerator(ArrayList<File> files, String path)
	    {
	    		writeMakeFile(files, path);
	    }

	    public void writeMakeFile(ArrayList<File> classes, String path) {
	        Parser parser = new Parser();
	        ArrayList<String> objectList = new ArrayList<>();
	        path = "makefile";
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
	            writer.write("OBJS =");

	            for (File object : classes) {
	                String oFile = object.toString().split("\\.")[0] + ".o";
	                objectList.add(oFile);
	                writer.write(" " + oFile);
	            }

	            writer.write("\nCC = g++");
	            writer.write("\nDEBUG = -g");
	            writer.write("\nCFLAGS = -Wall -c $(DEBUG)");
	            writer.write("\nLFLAGS = -Wall $(DEBUG)");
	            writer.write("\n\nexecutable : $(OBJS)");
	            writer.write("\n\t$(CC) $(LFLAGS) $(OBJS) -o executable");

	            for (File input : classes) {
	                String oFile = input.toString().split("\\.")[0] + ".o";
	                writer.write("\n\n" + oFile + " : ");
	                ArrayList<String> dependencies = parser.parseMakefile(input);

	                for (String dependency : dependencies) {
	                    writer.write(dependency);
	                }

	                writer.write("\n\t$(CC) $(CFLAGS) " + input.toString());
	            }

	            writer.write("\n\nclean :");
	            writer.write("\n\t-rm *.o $(OBJS) executable");
	            writer.close();

	        } catch (Exception e) {
	            System.err.println("Error 001: Error in Makefile Generation.");
	        }
	    }

        public void writeTestFixture(ArrayList<File> classes, String path){
            Parser parser = new Parser();
            ArrayList<String> objectList = new ArrayList<>();
            path = "testFixture";
            //file = new File(getDirectoryName());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {


                for (File input : classes) {
                    writer.write("\n");
                    String className = input.getName().split("\\.")[0];
                    System.out.println(className);
                    String testName = input.getName().split("\\.")[0] + "Test()";
                    String obj = " object";
                    writer.write("struct " + className + "Test:testing::Test");
                    writer.write("{");
                    writer.write("\n\t" + className +"*" + obj + ";");
                    writer.write("\n\t" + testName);
                    writer.write("\n\t{");
                    writer.write("\n\t\t" + obj + " = new " + className + "();");
                    writer. write("\n\t}");
                    writer.write("\n\t" + testName);
                    writer.write("\n\t{");
                    writer.write("\n\t\tdelete" + obj + ";");
                    writer.write("\n\t}");
                    writer.write("\n};");


                     writer.write("\n{");

                     ArrayList<String> classNames = parser.parseTestFixture(input);

                     writer.write("\n\t");
                     writer.write(input.getName() + "* " + obj);
                     writer.write("\n" + testName);
                     writer.write("\n" + obj + " = new " + testName);
                     writer.write("\n\t}");
                     writer.write("~" + testName);
                     writer.write("\n\tdelete" + obj);
                     writer.write("\n\t}");
                     writer.write("\n}");
                }

                writer.close();

            } catch (Exception e) {
                System.out.println("Error 002: Error in Test Fixture Generation.");
            }

        }

        public void writeUnitTests(ArrayList<File> classes, String path){
            Parser parser = new Parser();
            ArrayList<String> objectList = new ArrayList<>();
            path += "testFixture";
            //file = new File(getDirectoryName());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {


                for (File input : classes) {
                //TODO: Add method body.
                }

                writer.close();

            } catch (Exception e) {
                System.out.println("Error 003: Error in Unit Test Generation.");
            }

        }

        public String getDirectoryName(ArrayList<File> classes){
            String s = "";
            String filePath = classes.get(0).getParent();
            String directoryName = filePath.replace("\\", "\\\\");
            return directoryName;
        }
}
