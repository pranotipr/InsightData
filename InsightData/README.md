# Project Title

This project helps parse past data provided by the Federal Election Commission (FEC) to identify possible donors for a variety of upcoming election campaigns. This parser works on data that conforms with the data dictionary as described by the FEC. Results of the analysis are outputed to the following two files:

1. medianvals_by_zip.txt: It outputs the calculated running median, total dollar amount and total number of contributions for a recipient and zip-code combination. 

2. medianvals_by_date.txt: It outputs the calculated median, total dollar amount and total number of contributions for recipient and date combination.

The above files only calculates results for individual contributions and ignores all other records. 

# Approach

## Median Computation: 
To calculate the running median of contributions received by recipient from the by zip-code/date, I have facilitated a heap based implementation that keeps the streamed data updated in a heap-based data structure and provides a O(1) retrieval of median at any point in time. The implementation uses a max heap on left side to represent elements that are less than effective median, and a min heap on right side to represent elements that are greater than effective median. This has a total time complexity of O(N log N) which is one of the best among all the known implementations for running median computation.

## The medianvals by zip computation required output file to contain the same number of records as the input data file minus any records that were not valid. To accomplish this I have performed validation on input as the first step.  Median calculations have been rounded to the whole dollar before they are outputed to the file.

To maintain the total amount and total number of trasaction for a recepient-zip combination key, I have used HashMap as it allows O(1) time complexity for isertion and retrieval. 

## The medianvals by date computation required output record to have lines sorted alphabetical by recipient and then chronologically by date. To facilitate this I have used a Sorted Map (TreeMap) the sorts the recepient-date combination key by implementing Comparable interface and overriding its compareTo() method. 


## Running the tests

In order to run the project follow these steps:
	1. Execute run.sh which read the inputs from Input folder parallel to src directory and generates the output in output directory. This scipt is used for compiling the program and executing it. It would also automatically run all the unit tests.

	2. In order to run the extra integration tests, add them in insight_testsuite/tests folder with input. Then, execute run_tests.sh which generates result in the output folder inside test directory.

## Unit Tests

Following unit test are provided to check the fundamentals functions in the project:

	1. Unit test to check input validator for the medianvals by zip computation. For computing medianvals_by_date.txt record following cases represent invalid input:
	### Invalid input can include empty or malformed zip-code. If CMTE_ID, TRANSACTION_AMT field is invalid or empty then the record is considered invalid as well. Also an empty OTHER_ID field represents invalid record.

	2. Unit test to check input validator for the medianvals by date.txt computation. For computing medianvals_by_date.txt record following cases represent invalid input:
	### Invalid input can include empty or malformed date. If CMTE_ID, TRANSACTION_AMT field is invalid or empty then the record is considered invalid as well. Also an empty OTHER_ID field represents invalid record.

	3. Unit test to check the median calculator functionality.


## Built With

The project is built using the Eclipse IDE. The project also uses JUnit as the testing framework. The Jar for JUnit has been included in the source. 

## Authors

Pranoti Rahangdale
Masters in Computer Science,
Arizona State University
prahangd@asu.edu
Phone: +18587221382