////////////////////////////////////////////////////////////////////////////////
// Main File:        cache2Dclash.c
// This File:        cache2Dclash.c
// Other Files:      N/A
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

#define ITERATION_SIZE 100
#define ROW_SIZE 128
#define COL_SIZE 8

int arr2D[ROW_SIZE][COL_SIZE];

int main() {
	for (int iteration = 0; iteration < ITERATION_SIZE; iteration++) {
		for(int row = 0; row < ROW_SIZE; row += 64) {
			for(int col = 0; col < COL_SIZE; col++) {
				arr2D[row][col] = iteration + row + col;
			}
		}
	}
	return 0;
}
