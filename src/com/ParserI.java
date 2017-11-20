package com;

import java.io.File;
import java.util.ArrayList;

public interface ParserI
{
	ArrayList<String> parseMakefile(File inputFile);
	ArrayList<String>  parseTestFixture(File inputFile);
	ArrayList<String> parseUnitTest(File inputFile);
}
