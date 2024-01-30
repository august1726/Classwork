////////////////////////////////////////////////////////////////////////////////
// Main File:        sendsig.c
// This File:        sendsig.c
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

#include <sys/types.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>

/* Format: sendsig <signal type> <pid>
 * sends a signal to specified pid. Sends SIGUSR1 if 'u' is specified, sends
 * SIGINT if 'i' is specified 
 *
 * argc - number of arguments passed into program
 * argv - array of arguments passed into program
 */
int main(int argc, char **argv) {
	//exit program immediately with code 1 and print usage message if
	//incorrect amount of arguments passed into program
	if (argc != 3) {
		printf("Usage: sendsig <signal type> <pid>\n");
		exit(1);
	}
	int pid = atoi(*(argv + 2)); //pid of program to sent signal to
	if (pid == 0) {
		printf("error encountered with atoi, exiting");
		exit(1);
	}
	//if arg1 is 'u', send SIGUSR1
	if ( *(*(argv + 1) + 1) == 'u') {
		if (kill(pid, 10) < 0) {
			printf("error encountered sending SIGUSR1, exiting\n");
			exit(1);
		}
	}
	//if arg1 is 'i', send SIGINT
	if ( *(*(argv + 1) + 1) == 'i') {
		if (kill(pid, 2) < 0) {
			printf("error encountered sending SIGINT, exiting\n");
			exit(1);
		}
	}
}
