import heapq
import numpy as np

def get_manhattan_distance(from_state, to_state=[1, 2, 3, 4, 5, 6, 7, 0, 0]):
    """
    TODO: implement this function. This function will not be tested directly by the grader. 

    INPUT: 
        Two states (if second state is omitted then it is assumed that it is the goal state)

    RETURNS:
        A scalar that is the sum of Manhattan distances for all tiles.
    """
    distance = 0
    for i in range(len(to_state)):
        if to_state[i] == 0:
            continue
        distance += abs(from_state.index(to_state[i]) // 3 - i // 3)
        distance += abs(from_state.index(to_state[i]) % 3 - i % 3)
    return distance

def print_succ(state):
    """
    TODO: This is based on get_succ function below, so should implement that function.

    INPUT: 
        A state (list of length 9)

    WHAT IT DOES:
        Prints the list of all the valid successors in the puzzle. 
    """
    succ_states = get_succ(state)

    for succ_state in succ_states:
        print(succ_state, "h={}".format(get_manhattan_distance(succ_state)))


def get_succ(state):
    """
    TODO: implement this function.

    INPUT: 
        A state (list of length 9)

    RETURNS:
        A list of all the valid successors in the puzzle (don't forget to sort the result as done below). 
    """
    succ_states = []
    for i in range(len(state)):
        if state[i] == 0:
            #check left, right, up, down
            if i // 3 == (1 + i) // 3 and state[i + 1] != 0:
                temp = state.copy()
                temp[i] = temp[i + 1]
                temp[i + 1] = 0
                succ_states.append(temp)
            if i // 3 == (i - 1) // 3 and state[i - 1] != 0:
                temp = state.copy()
                temp[i] = temp[i - 1]
                temp[i - 1] = 0
                succ_states.append(temp)
            if i + 3 < len(state) and state[i + 3] != 0:
                temp = state.copy()
                temp[i] = temp[i + 3]
                temp[i + 3] = 0
                succ_states.append(temp)
            if i - 3 >= 0 and state[i - 3] != 0:
                temp = state.copy()
                temp[i] = temp[i - 3]
                temp[i - 3] = 0
                succ_states.append(temp)
    return sorted(succ_states)


def solve(state, goal_state=[1, 2, 3, 4, 5, 6, 7, 0, 0]):
    """
    TODO: Implement the A* algorithm here.

    INPUT: 
        An initial state (list of length 9)

    WHAT IT SHOULD DO:
        Prints a path of configurations from initial state to goal state along  h values, number of moves, and max queue number in the format specified in the pdf.
    """
    pq = []
    visited = []
    visited_full = []
    h = get_manhattan_distance(state, goal_state)
    heapq.heappush(pq, (h, state, (0, h, -1)))
    lt = []
    ltg = []
    lt.append(state)
    ltg.append([0])
    max_length = len(pq)
    while (len(pq) > 0):
        curr = heapq.heappop(pq)
        if curr[1] in visited:
            continue
        visited.append(curr[1])
        visited_full.append(curr)
        if (curr[1] == goal_state):
            break
        for succ in get_succ(curr[1]):
            #if visited doesn't contain succ, pop succ
            h = get_manhattan_distance(succ, goal_state)
            g = curr[2][0] + 1
            if succ not in visited and succ not in lt:
                heapq.heappush(pq, (h + g, succ, (g, h, len(visited_full) - 1)))
                lt.append(succ)
                ltg.append([g])
            elif succ in visited:
                i = visited.index(succ)
                prev_g = visited_full[i][2][0]
                if g < prev_g:
                    heapq.heappush(pq, (h + g, succ, (g, h, len(visited_full) - 1)))
                    j = lt.index(succ)
                    ltg[j].append(g)
                    ltg[j] = sorted(ltg[j])
            elif succ in lt:
                i = lt.index(succ)
                if g < ltg[i][0]:
                    heapq.heappush(pq, (h + g, succ, (g, h, len(visited_full) - 1)))
                    ltg[i].append(g)
                    ltg[i] = sorted(ltg[i])
                    #print(lt[i])
                    #print(ltg[i])
            
        if len(pq) > max_length:
            max_length = len(pq)


    state_info_list = []
    temp = []
    temp.append(visited_full[len(visited) - 1][1])
    temp.append(visited_full[len(visited) - 1][2][1])
    temp.append(visited_full[len(visited) - 1][2][0])
    parent_ind = visited_full[len(visited) - 1][2][2]
    state_info_list.append(temp)
    while(parent_ind >= 0):
        temp = []
        temp.append(visited_full[parent_ind][1])
        temp.append(visited_full[parent_ind][2][1])
        temp.append(visited_full[parent_ind][2][0])
        parent_ind = visited_full[parent_ind][2][2]
        state_info_list.append(temp)
    state_info_list.reverse()
    # This is a format helper.
    # build "state_info_list", for each "state_info" in the list, it contains "current_state", "h" and "move".
    # define and compute max length
    # it can help to avoid any potential format issue.
    for state_info in state_info_list:
        current_state = state_info[0]
        h = state_info[1]
        move = state_info[2]
        print(current_state, "h={}".format(h), "moves: {}".format(move))
    print("Max queue length: {}".format(max_length))

if __name__ == "__main__":
    """
    Feel free to write your own test code here to exaime the correctness of your functions. 
    Note that this part will not be graded.
    """
    print_succ([2,5,1,4,0,6,7,0,3])
    print()

    print(get_manhattan_distance([2,5,1,4,0,6,7,0,3], [1, 2, 3, 4, 5, 6, 7, 0, 0]))
    print()

    #solve([2,5,1,4,0,6,7,0,3])
    #print()

    solve([4,3,0,5,1,6,7,2,0])
    print()
