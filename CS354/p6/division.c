////////////////////////////////////////////////////////////////////////////////
// Main File:        division.c
// This File:        division.c
// Other Files:      
// Semester:         CS 354 Lecture 001 Spring 2023
// Instructor:       deppeler
// 
// Author:           August Bambenek
// Email:            abambenek@wisc.edu
// CS Login:         bambenek
//
/////////////////////////// OTHER SOURCES OF HELP //////////////////////////////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide ///////////////////////////////////

#include <stdlib.h>
#include <stdio.h>
#include <signal.h>
#include <string.h>

int successes = 0; //number of successful divisions completed

/* Handles SIGFPE, prints number of successful divisons completed, then exits
 * programs with code 0
 *
 * Pre-conditions: called by kernel when SIGFPE occurs, or divide by 0
 * is attempted
 */
void handler_SIGFPE() {
	printf("Error: a division by 0 operation was attempted.\n");
	printf("Total number of operations completed successfully: %i\n", successes);
	printf("The program will be terminated.\n");
	exit(0);
}

/* Handles SIGINT, prints number of successful divisons completed, then exits
 * programs with code 0
 *
 * Pre-conditions: called by kernel when SIGFPE occurs, or ctrl-c is input
 */
void handler_SIGINT() {
	printf("\nTotal number of operations completed successfully: %i\n", successes);
	printf("The program will be terminated.\n");
	exit(0);
}

/*
 * Sets handlers for SIGFPE and SIGINT, then enters infinite loop of
 * asking user to input 2 integers, then outputting the quotient. Exits
 * if users attemts to divide by zero or inputs ctrl-c (SIGINT)
 */
int main() {
	//set handler for SIGFPE, or divide by 0 exception
	struct sigaction sa;
	memset(&sa, 0, sizeof(sa));
	sa.sa_handler = handler_SIGFPE;
	if (sigaction(SIGFPE, &sa, NULL) != 0) {
		printf("Error binding SIGFPE handler\n");
		exit(1);
	}
	//set handler for SIGINT
	struct sigaction sa_SIGINT;
	memset(&sa_SIGINT, 0, sizeof(sa_SIGINT));
	sa_SIGINT.sa_handler = handler_SIGINT;
	if (sigaction(SIGINT, &sa_SIGINT, NULL) != 0) {
		printf("Error binding SIGINT handler\n");
		exit(1);
	}
	//enter infinite loop, prompt user for 2 integers and divide them
	while(1) {
		printf("Enter first integer: ");
		char buffer[100];
		if (fgets((char*)&buffer, 100, stdin) != (char*)&buffer) {
			printf("Error using fgets()\n");
			exit(1);
		}
		int int1 = atoi((char*)&buffer);
		printf("Enter second integer: ");
		if (fgets((char*)&buffer, 100, stdin) != (char*)&buffer) {
			printf("Error using fgets()\n");
			exit(1);
		}
		int int2 = atoi((char*)&buffer);
		int quotient = int1 / int2;
		int remainder = int1 % int2;
		printf("%i / %i is %i with a remainder of %i\n", int1, int2, quotient, remainder);
		successes++;
	}
	return 0;
}
