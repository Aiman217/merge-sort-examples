#CPT316/CPT211/CPM313 
#Programming Languages Implementation & Paradigms
#Group member
#1.TAN JING KAI (141130)
#2.LI PEI RAN (145141)
#3.MUHAMMAD AIMAN ARIF BIN BAHARUDIN (146824)

import time

#Function for merge sort algorithm
def merge_sort(inp_arr):
    size = len(inp_arr) #Get length of array
    if size > 1:
        mid = size // 2 #Get middle index of array
        #Temporary arrays for left and right side
        #Copy data to temporary arrays
        LeftArray = inp_arr[:mid]
        RightArray = inp_arr[mid:]

        #Run merge sort for each arrays
        merge_sort(LeftArray)
        merge_sort(RightArray)
 
        p = 0 #Initial index of left side
        q = 0 #Initial index of right side 
        r = 0 #Initial index of merged sub-array
 
        nleft = len(LeftArray)
        nright = len(RightArray)

        #Sorting data based on accending order
        while p < nleft and q < nright:
            if LeftArray[p] <= RightArray[q]:
                inp_arr[r] = LeftArray[p]
                p += 1
            else:
                inp_arr[r] = RightArray[q]
                q += 1            
            r += 1
        #Merge sub-arrays
        while p < nleft:
            inp_arr[r] = LeftArray[p]
            p += 1
            r += 1
        while q < nright:
            inp_arr[r] = RightArray[q]
            q += 1
            r += 1
#Start time
start_time = round(time.time())
#Open file
with open('sgb-words.txt', 'r') as file:
    #Add data to variable
    data = file.read().splitlines() 
#Close file
#Create output file
outputFile = open('output_python.txt', 'w')
for item in data:
    #Convert string to list character
    inp_arr = [char for char in item]
    #Call function merge_sort
    merge_sort(inp_arr)
    #Write result to output file
    print("Sorted Array: " + ''.join(inp_arr), file = outputFile)
#Close output file
outputFile.close()
#Stop time and calculate time execution
print("%s milliseconds" % (round(time.time() - start_time,2)*1000))