OBJS = C:\Users\T.o C:\Users\T.o C:\Users\T.o C:\Users\T.o C:\Users\T.o C:\Users\T.o
CC = g++
DEBUG = -g
CFLAGS = -Wall -c $(DEBUG)
LFLAGS = -Wall $(DEBUG)

executable : $(OBJS)
	$(CC) $(LFLAGS) $(OBJS) -o executable

C:\Users\T.o :  TestHarness.h MyClass.h
	$(CC) $(CFLAGS) C:\Users\T. McClintock\Documents\RowanFall2017\SoftwareEngineering\11192017_2300\TestGT\test\ExampleFixture.h

C:\Users\T.o :  TestHarness.h MyClass.h TestHarness.h ExampleFixture.h
	$(CC) $(CFLAGS) C:\Users\T. McClintock\Documents\RowanFall2017\SoftwareEngineering\11192017_2300\TestGT\test\ExampleTest.cpp

C:\Users\T.o :  TestHarness.h MyClass.h TestHarness.h ExampleFixture.h MyClass.h
	$(CC) $(CFLAGS) C:\Users\T. McClintock\Documents\RowanFall2017\SoftwareEngineering\11192017_2300\TestGT\test\MyClass.cpp

C:\Users\T.o :  TestHarness.h MyClass.h TestHarness.h ExampleFixture.h MyClass.h
	$(CC) $(CFLAGS) C:\Users\T. McClintock\Documents\RowanFall2017\SoftwareEngineering\11192017_2300\TestGT\test\MyClass.h

C:\Users\T.o :  TestHarness.h MyClass.h TestHarness.h ExampleFixture.h MyClass.h <header.h>
	$(CC) $(CFLAGS) C:\Users\T. McClintock\Documents\RowanFall2017\SoftwareEngineering\11192017_2300\TestGT\test\cplusplus.cpp

C:\Users\T.o :  TestHarness.h MyClass.h TestHarness.h ExampleFixture.h MyClass.h <header.h>
	$(CC) $(CFLAGS) C:\Users\T. McClintock\Documents\RowanFall2017\SoftwareEngineering\11192017_2300\TestGT\test\header.h

clean :
	-rm *.o $(OBJS) executable