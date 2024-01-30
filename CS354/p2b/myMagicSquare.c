///////////////////////////////////////////////////////////////////////////////
// Copyright 2020 Jim Skrentny
// Posting or sharing this file is prohibited, including any changes/additions.
// Used by permission, CS 354 Spring 2022, Deb Deppeler
////////////////////////////////////////////////////////////////////////////////
   
////////////////////////////////////////////////////////////////////////////////
// Main File:        myMagicSquare.c
// This File:        myMagicSquare.c
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

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Structure that represents a magic square
typedef struct {
    int size;           // dimension of the square
    int **magic_square; // pointer to heap allocated magic square
} MagicSquare;

/* TODO:
 * Prompts the user for the magic square's size, reads it,
 * checks if it's an odd number >= 3 (if not display the required
 * error message and exit), and returns the valid number.
 */
int getSize() {
	int size;
	printf("Enter magic square's size (odd integer >=3)\n");
	scanf("%i", &size); //maybe use fscanf to find int
	if (size % 2 != 1) {
		printf("Magic square size must be odd.\n");
		exit(1);
	}
	if (size < 3) {
		printf("Magic square size must be >= 3.\n");
		exit(1);
	} 
    return size;   
} 
   
/* TODO:
 * Makes a magic square of size n using the 
 * Siamese magic square algorithm or alternate from assignment 
 * or another valid alorithm that produces a magic square.
 *
 * n is the number of rows and columns
 *
 * returns a pointer to the completed MagicSquare struct.
 */
MagicSquare *generateMagicSquare(int n) {
	MagicSquare * mptr = malloc(sizeof(MagicSquare));
	if (mptr == NULL) {
		printf("Error while allocating memory\n");
		exit(1);
	}
	mptr -> size = n;
	mptr -> magic_square = malloc(sizeof(int*) * n);
	if ((mptr -> magic_square) == NULL) {
		printf("Error while allocating memory\n");
		exit(1);
	}
	for (int i = 0; i < n; i++) {
		*((mptr -> magic_square) + i) = calloc(n, sizeof(int));
		if (*((mptr -> magic_square) + i)  == NULL) {
			printf("Error while allocating memory\n");
			exit(1);
		}
	}
	int row = n / 2;
	int column = n - 1;
	int newrow;
	int newcolumn;
	//sets rightmost column in middle row to 1
	*(*((mptr -> magic_square) + row) + column) = 1;
	for (int i = 2; i <= n * n; i++) {
		//update coordinates, wrap around if necessary
		if (row == n - 1) {
			newrow = 0;
		} else {
			newrow = row + 1;
		}
		if (column == n - 1) {
			newcolumn = 0;
		} else {
			newcolumn = column + 1;
		}
		//move one to left if new coordinates are taken, don't update
		if (*(*((mptr -> magic_square) + newrow) + newcolumn) != 0) {
			if (column == 0) {
				column = n - 1;
			} else {
				column -= 1;
			}
		} else {
			//else, update coordinates
			column = newcolumn;
			row = newrow;
		}
		//set coordinates to number i from 1 <= i <= n^2
		*(*((mptr -> magic_square) + row) + column) = i;
	}
    return mptr;    
} 

/* TODO:  
 * Opens a new file (or overwrites the existing file)
 * and writes the square in the specified format.
 *
 * magic_square the magic square to write to a file
 * filename the name of the output file
 */
void fileOutputMagicSquare(MagicSquare *magic_square, char *filename) {
	FILE *fp = fopen(filename, "w");
	if (fp == NULL) {
		printf("Can't open file for writing\n");
		exit(1);
	}
	
	fprintf(fp, "%i\n", magic_square -> size);
	for(int i = 0; i < magic_square -> size; i++) {
		
		for(int j = 0; j < magic_square -> size; j++) {
			fprintf(fp, "%i", *(*((magic_square -> magic_square) + i ) + j));
			if (j != magic_square -> size - 1) {
				fprintf(fp, ",");
			}
		}
		if (i != magic_square -> size - 1) {
			fprintf(fp, "\n");
		}
	}
	if (fclose(fp) != 0) {
		printf("Error while closing the file\n");
		exit(1);
	}
	fp = NULL;
}


/* TODO:
 * Generates a magic square of the user specified size and
 * outputs the square to the output filename.
 * 
 * Requires exactly 1 Command Line Argument, which is the
 * which is the name of the file to write to
 *
 * argc: the number of command line args (CLAs)
 * argv: the CLA strings, includes the program name
 */
int main(int argc, char **argv) {
    // TODO: Check input arguments to get output filename
	if (argc != 2) {
		printf("Usage: ./myMagicSquare <output_filename>\n");
		exit(1);
	}
	char *filename = *(argv + 1);
    // TODO: Get magic square's size from user
	int size = getSize();
    // TODO: Generate the magic square by correctly interpreting 
    //       the algorithm(s) in the write-up or by writing or your own.  
    //       You must confirm that your program produces a 
    //       Magic Sqare as described in the linked Wikipedia page.
	MagicSquare *msptr = generateMagicSquare(size);
    // TODO: Output the magic square
	fileOutputMagicSquare(msptr, filename);

	for (int i = 0; i < size; i++) {
		free(*((msptr -> magic_square) + i));
	}
	free (msptr -> magic_square);
	free(msptr);
	filename = NULL;
	msptr = NULL;
    return 0;
} 

// S23

