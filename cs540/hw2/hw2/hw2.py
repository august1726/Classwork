import sys
import math


def get_parameter_vectors():
    '''
    This function parses e.txt and s.txt to get the  26-dimensional multinomial
    parameter vector (characters probabilities of English and Spanish) as
    descibed in section 1.2 of the writeup

    Returns: tuple of vectors e and s
    '''
    #Implementing vectors e,s as lists (arrays) of length 26
    #with p[0] being the probability of 'A' and so on
    e=[0]*26
    s=[0]*26

    with open('e.txt',encoding='utf-8') as f:
        for line in f:
            #strip: removes the newline character
            #split: split the string on space character
            char,prob=line.strip().split(" ")
            #ord('E') gives the ASCII (integer) value of character 'E'
            #we then subtract it from 'A' to give array index
            #This way 'A' gets index 0 and 'Z' gets index 25.
            e[ord(char)-ord('A')]=float(prob)
    f.close()

    with open('s.txt',encoding='utf-8') as f:
        for line in f:
            char,prob=line.strip().split(" ")
            s[ord(char)-ord('A')]=float(prob)
    f.close()

    return (e,s)

def shred(filename):
    #Using a dictionary here. You may change this to any data structure of
    #your choice such as lists (X=[]) etc. for the assignment
    X={'A':0, 'B':0, 'C':0, 'D':0, 'E':0, 'F':0, 'G':0, 'H':0, 'I':0, 'J':0, 'K':0, 'L':0, 'M':0, 'N':0, 'O':0, 'P':0, 'Q':0, 'R':0, 'S':0, 'T':0, 'U':0, 'V':0, 'W':0, 'X':0, 'Y':0, 'Z':0}
    with open (filename,encoding='utf-8') as f:
        for line in f:
            for char in line:
                if (X.keys().__contains__(char.upper())):
                        X[char.upper()] += 1

    return X





# TODO: add your code here for the assignment
# You are free to implement it as you wish!
# Happy Coding!

vect = shred('letter.txt') 
print('Q1')
for key, value in vect.items():
    print(key + " " + str(value))

e, s = get_parameter_vectors()
X = [0]*26
for i in range (26):
    X[i] = vect.get(chr(ord('A') + i))
print('Q2')
print(round(float(X[0]) * math.log(e[0]), 4))
print(round(float(X[0]) * math.log(s[0]), 4))
print('Q3')
f_e = math.log(0.6)
for i in range(26):
    f_e += float((X[i]) * math.log(e[i]))
print(round(f_e, 4))
f_s = math.log(0.4)
for i in range(26):
    f_s += float((X[i]) * math.log(s[i]))
print(round(f_s, 4))
print('Q4')
if f_s - f_e >= 100:
    print(0.0000)
elif f_s - f_e <= -100:
    print(1.0000)
else:
    print(round(1/(1 + math.exp(f_s - f_e)), 4))