////////////////////////////////////////////////////////////////////////////////
// Main File:        mySigHandler.c
// This File:        mySigHandler.c
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
#include <unistd.h>
#include <time.h>
#include <string.h>
#include <signal.h>

int seconds = 4; //number of seconds to set alarms for
int counter = 0; //number of times SIGUSR1 is handled

/* Handles SIGALRM, prints message and sets a new alarm to go off in 4 seconds,
 * then returns to main
 *
 * Pre-conditions: called by kernel when SIGALRM occurs
 */
void handler_SIGALRM() {
	time_t curtime;
	if(time(&curtime) == (time_t)-1) {
		printf("Error using time()\n");
		exit(1);
	}
	char* time = ctime(&curtime);
	if (time == NULL) {
		printf("error using ctime()\n");
		exit(1);
	}
	printf("PID: %i CURRENT TIME: %s", getpid(), time);
	alarm(seconds);
	return;
}

/* Handles SIGUSR1, prints message and increments counter, then returns 
 * to main
 *
 * Pre-conditions: called by kernel when SIGUSR1 occurs
 */
void handler_SIGUSR1() {
	printf("SIGUSR1 handled and counted!\n");
	counter++;
	return;
}

/* Handles SIGINT, prints message and outputs number of times SIGUSR1 has
 * been handled, then exits program with code 0
 *
 * Pre-conditions: called by kernel when SIGINT occurs 
 * (when ctrl-c is pressed on keyboard)
 */
void handler_SIGINT() {
	printf("\nSIGINT handled.\n");
	printf("SIGUSR1 was handled %i times. Exiting now.\n", counter);
	exit(0);
}

/*
 * Sets handlers for SIGALRM, SIGUSR1, and SIGINT, triggers an alarm
 * to go off every 4 seconds, then start infinite loop. Exit program
 * by sending SIGINT, or pressing ctrl-c
 */
int main() {
	printf("PID and time print every 4 seconds.\n");
	printf("Type Ctrl-C to end the program.\n");
	alarm(seconds); //set alarm to go off in 4 seconds
	//set handler for SIGALRM
	struct sigaction sa;
	memset(&sa, 0, sizeof(sa));
	sa.sa_handler = handler_SIGALRM;
	if (sigaction(SIGALRM, &sa, NULL) != 0) {
		printf("Error binding SIGALRM handler\n");
		exit(1);
	}
	//set handler for SIGUSR1
	struct sigaction sa_sigusr1;
	memset(&sa_sigusr1, 0, sizeof(sa_sigusr1));
	sa_sigusr1.sa_handler = handler_SIGUSR1;
	if (sigaction(SIGUSR1, &sa_sigusr1, NULL) != 0) {
		printf("Error binding SIGUSR1 handler\n");
		exit(1);
	}
	//set handler for SIGINT
	struct sigaction sa_sigint;
	memset(&sa_sigint, 0, sizeof(sa_sigint));
	sa_sigint.sa_handler = handler_SIGINT;
	if (sigaction(SIGINT, &sa_sigint, NULL) != 0) {
		printf("Error binding SIGINT handler\n");
		exit(1);
	}
	//once handlers are set, enter infinite loop
	while (1) {
	}
	return 0;
}
