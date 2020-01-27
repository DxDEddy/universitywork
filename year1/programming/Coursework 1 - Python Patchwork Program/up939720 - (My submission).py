##########################
# Edward Gray
# UP939720
# Programming Coursework 1 - Patchwork Program
##########################
from graphics import *  #This is so that I do not have to use the graphics. prefix to modules - similar to namespace - It's messy but functional due to the simplicity of the library.
import time     #My Linux Desktop Environment and Visual Studio Code close the window immediately if there is nothing being processed - meaning I have to put a sleep statement at the end of my code.

global usrcolors    #usrcolors is an list that I use to store the 3 colors that the user has selected in - It is used in the functions: userinputs and drawentiregrid.
usrcolors = []  
global color    #I pass the color variable around my code frequently as it is used in two cases. 
color = ""      #The first is in the userinputs module as temporary storage for the color I'm adding to the usrcolors array - the second use is in the drawing functions so I can tell them what color they need to be.

i = 0   #I opted to use a while loop here to make sure the program gets the right inputs from the user - this of course means I have to give I a value - this isn't an issue because I redefine it before every use.
while i < 1:    #This makes the loop repeat until my success condition is met - in this case I must equal 1.
    gridsize = int(input("What sized grid do you want? Enter 5, 7 or 9: "))    #This is asking for an integer from the user.
    if gridsize in [5,7,9]:     #This checks what the user just entered and if it isn't one of the valid values stored in that list - the success condition is not met
        print("Good Input %i - Continuing..." % gridsize)   #This is a debug log so the developer and user can see what has happened during runtime
        i = 1   #This is the success condition
    else:   #This is for if the user enters a bad input
        print("Something was wrong - please re-enter your choice...")   #Note the lack of i = 1 here, this means it's a fail condition

#ROBUST CODE!
def userinputs(usrcolors, color):   #This is the function that gathers the color inputs from the user
    i = 0
    

    while i < 3:    #The user must select 3 colors - I chose a while loop because it's much more flexible than a for loop because I can choose whether to increment or not when the loop finishes
        color_inital = str(input("Please enter the initial of color number %i: " %i))   #This gathers an input from the user in the form of a string
        if color_inital == "r":     #This part of the code changes the initials into the full colors for use in the shape drawing functions
            color = "red"
            usrcolors.append(color)
        elif color_inital == "g":
            color = "green"
            usrcolors.append(color)
        elif color_inital == "b":
            color = "blue"
            usrcolors.append(color)
        elif color_inital == "m":
            color = "magenta"
            usrcolors.append(color)
        elif color_inital == "o":
            color = "orange"
            usrcolors.append(color)
        elif color_inital == "c":
            color = "cyan"
            usrcolors.append(color)
        else:       #This is if the user gives a bad input (Ie. not one of the defined colors)
            i = i - 1   #Subtracting i here and thus negating the i = i + 1 later on shortens the code and negates the increment at the end of this loop making the program get that input again
            print("There was an error - please enter your color again, choosing from (red, green, blue, magenta, orange or cyan)")  #This tells the user what they did wrong
        
        i = i + 1   #This is a manual increment that will move to the next stage of the loop 
        print(usrcolors)    #This prints out the list with the three colors in

win = GraphWin("Coursework",gridsize*100,gridsize*100)  #Now that I have the neccesary inputs from the user I can draw the window

def drawsteps(startxcoord,startycoord,color):   #This is a single function for drawing the steps patch - this is a simpe patch and can be drawn with a single function.
    bg = Rectangle(Point(startxcoord,startycoord),Point(startxcoord+100,startycoord+100))   #The background is grey by default - this makes it white
    bg.setFill("White")
    bg.setOutline("White")
    bg.draw(win)

    drawycoord = startycoord + 90   #This is before the for loop and starts the drawing at 10px from the bottom for the first step.
    drawxcoord = startxcoord    #This swaps the parameter into another variable I don't mind modifying so I can keep the original value
    for i in range(0,10):   #I need this loop to draw the 10 steps
        stepdraw = Rectangle(Point(drawxcoord,drawycoord),Point(startxcoord+100,startycoord+100))   #This code has two points, the first is the top-left point that defines where the steps will be,
        stepdraw.setFill(color)                                                                     #The second point will always point to the bottom-right of the patch, this gives a staircase effect
        stepdraw.setOutline(color)
        stepdraw.draw(win)

        drawxcoord = drawxcoord + 10    #This moves the drawing cursor RIGHT 10px so it can be 
        drawycoord = drawycoord - 10    #This moves the drawing cursor UP 10px so it's on the same level as the next step

def circledrawlinepat1(drawxcoord,drawycoord,color):    #I have two sub-functions called circledrawlinepat1 and 2 - each of these draws a single row of the patch with their respective design and get called by a master function.
    drawxcoord = drawxcoord + 10  #This sets up the cursor's position for the first circle that gets drawn because it has a 10 radius.
    for i in range(0,4):    #There are 4 shapes that need to be drawn - 2 circles and 2 custom oval shapes - This alternates between the two being drawn on a line
        if i % 2 == 1:      #This alternates between the two functions using the modulo function, basically if i is even it draws the oval first, otherwise the circle is first
            for i in range(1):      #This executes this loop twice so I only need to write the code for a single circle and single oval shape
                ### This is for the single circle
                singlecircle = Circle(Point(drawxcoord+30,drawycoord+10),10) # Lower end 0 - Upper end 20
                singlecircle.setFill(color)
                singlecircle.setOutline(color)
                singlecircle.draw(win)
                ### Below here is the code for the oval shape
                cylinderleftside = Circle(Point(drawxcoord,drawycoord+10),10) #
                cylinderleftside.setFill(color)
                cylinderleftside.setOutline(color)
                cylinderleftside.draw(win)

                cylinderrightside = Circle(Point(drawxcoord+10,drawycoord+10),10)
                cylinderrightside.setFill(color)
                cylinderrightside.setOutline(color)
                cylinderrightside.draw(win)

                cylinderbody = Rectangle(Point(drawxcoord,drawycoord),Point(drawxcoord+10,drawycoord+20))
                cylinderbody.setFill(color)
                cylinderbody.setOutline(color)
                cylinderbody.draw(win)
                
                drawxcoord = drawxcoord + 50    #This is needed to set the cursor for the next half of the row 
        else:
            for i in range(1):
                singlecircle = Circle(Point(drawxcoord+30,drawycoord+10),10) # Lower end 0 - Upper end 20
                singlecircle.setFill(color)
                singlecircle.setOutline(color)
                singlecircle.draw(win)

                cylinderleftside = Circle(Point(drawxcoord,drawycoord+10),10) #
                cylinderleftside.setFill(color)
                cylinderleftside.setOutline(color)
                cylinderleftside.draw(win)

                cylinderrightside = Circle(Point(drawxcoord+10,drawycoord+10),10)
                cylinderrightside.setFill(color)
                cylinderrightside.setOutline(color)
                cylinderrightside.draw(win)

                cylinderbody = Rectangle(Point(drawxcoord,drawycoord),Point(drawxcoord+10,drawycoord+20))
                cylinderbody.setFill(color)
                cylinderbody.setOutline(color)
                cylinderbody.draw(win)
                
                drawxcoord = drawxcoord + 50    #This is needed to set the cursor for the next half of the row 
  
def circledrawlinepat2(drawxcoord,drawycoord,color):    #This is the same as the above function just with the circle and oval positions swapped
    drawxcoord = drawxcoord + 10
    for i in range(0,4):
        if i % 2 == 1:
            for i in range(1):
                singlecircle = Circle(Point(drawxcoord,drawycoord+10),10) # Lower end 0 - Upper end 20
                singlecircle.setFill(color)
                singlecircle.setOutline(color)
                singlecircle.draw(win)

                cylinderleftside = Circle(Point(drawxcoord+20,drawycoord+10),10) #
                cylinderleftside.setFill(color)
                cylinderleftside.setOutline(color)
                cylinderleftside.draw(win)

                cylinderrightside = Circle(Point(drawxcoord+30,drawycoord+10),10)
                cylinderrightside.setFill(color)
                cylinderrightside.setOutline(color)
                cylinderrightside.draw(win)

                cylinderbody = Rectangle(Point(drawxcoord+20,drawycoord),Point(drawxcoord+30,drawycoord+20))
                cylinderbody.setFill(color)
                cylinderbody.setOutline(color)
                cylinderbody.draw(win)
                
                drawxcoord = drawxcoord + 50
        else:
            for i in range(1):
                singlecircle = Circle(Point(drawxcoord,drawycoord+10),10) # Lower end 0 - Upper end 20
                singlecircle.setFill(color)
                singlecircle.setOutline(color)
                singlecircle.draw(win)

                cylinderleftside = Circle(Point(drawxcoord+20,drawycoord+10),10) #
                cylinderleftside.setFill(color)
                cylinderleftside.setOutline(color)
                cylinderleftside.draw(win)

                cylinderrightside = Circle(Point(drawxcoord+30,drawycoord+10),10)
                cylinderrightside.setFill(color)
                cylinderrightside.setOutline(color)
                cylinderrightside.draw(win)

                cylinderbody = Rectangle(Point(drawxcoord+20,drawycoord),Point(drawxcoord+30,drawycoord+20))
                cylinderbody.setFill(color)
                cylinderbody.setOutline(color)
                cylinderbody.draw(win)
                
                drawxcoord = drawxcoord + 50


def drawcirclepattern(startxcoord,startycoord,color):   #This is the master function I talked about earlier, the purpose of this is called in the two functions above and use then to draw the 5 rows for the patch
    background = Rectangle(Point(startxcoord,startycoord),Point(startxcoord+100,startycoord+100))   #This is the code for the background as seen in my stair drawing function
    background.setFill("White")
    background.setOutline("White")
    background.draw(win)
    for i in range(0,5):    #Each row is 20px high because of the circles with radius 10 - meaning we need 5 loops to cover 100x100px
        if i % 2 == 1:      #This is another piece of code i made that alternates the two designs based on whether I is even or not as it goes from 0 to 5
            circledrawlinepat1(startxcoord,startycoord,color)
        else:
            circledrawlinepat2(startxcoord,startycoord,color)
        startycoord = startycoord + 20  #goes 20px down 5x so the patch gets covered and the rows aren't drawn on top of one another

#These are the arrays that tell my program what design and color each patch is. The first digit is the design (f for final number and p for penultimate)
#The second of these is the color that must be used for it where: 0 = PRIMARY - 1 = SECOND - 2 = TERTIARY - these are also conveniently the index numbers of the respective values in my global list usrcolors
list_5x5grid = ["f0","f0","f0","f0","f0","p1","f0","f0","f0","p2","p1","p1","f0","p2","p2","p1","f0","f0","f0","p2","f0","f0","f0","f0","f0"]
list_7x7grid = ["f0","f0","f0","f0","f0","f0","f0","p1","f0","f0","f0","f0","f0","p2","p1","p1","f0","f0","f0","p2","p2","p1","p1","p1","f0","p2","p2","p2","p1","p1","f0","f0","f0","p2","p2","p1","f0","f0","f0","f0","f0","p2","f0","f0","f0","f0","f0","f0","f0"]
list_9x9grid = ["f0","f0","f0","f0","f0","f0","f0","f0","f0","p1","f0","f0","f0","f0","f0","f0","f0","p2","p1","p1","f0","f0","f0","f0","f0","p2","p2","p1","p1","p1","f0","f0","f0","p2","p2","p2","p1","p1","p1","p1","f0","p2","p2","p2","p2","p1","p1","p1","f0","f0","f0","p2","p2","p2","p1","p1","f0","f0","f0","f0","f0","p2","p2","p1","f0","f0","f0","f0","f0","f0","f0","p2","f0","f0","f0","f0","f0","f0","f0","f0","f0","f0"]

if gridsize == 5:   #This tells the program what array to use based on what window size the user wants and entered earlier. 
    grid_list_use = list_5x5grid
elif gridsize == 7:
    grid_list_use = list_7x7grid
elif gridsize == 9:
    grid_list_use = list_9x9grid

def drawentiregrid(gridsize,usrcolors):     #This is a function that calls all of the functions that draw the individual patches - this essentially stitches them all together
    list_index = 0  #   This is the increment - I define it here because I need it for ues in a nested for loop 

    for i in range(0,gridsize):     #This is the first of two loops - this one moves the target patch coord down 1 row until it reaches the bottom
        for c in range(0,gridsize):     #This is the second of the two loops - this one moves the target patch coord across 1 row until it reaches the right of the screen

            if grid_list_use[list_index][1] == "0":     #I use subtargeting on the list - I grab the second character of the list value I'm reading. The second character tells the program what color it needs to be.
                color = usrcolors[0]    #0 means the primary color
            elif grid_list_use[list_index][1] == "1":   #I use subtargeting on the list - I grab the second character of the list value I'm reading. The second character tells the program what color it needs to be.
                color = usrcolors[1]    #1 means the second color
            elif grid_list_use[list_index][1] == "2":   #I use subtargeting on the list - I grab the second character of the list value I'm reading. The second character tells the program what color it needs to be.
                color = usrcolors[2]    #2 means the tertiary color

            print("Color is %s" % color)    #This is for the developer and user to confirm what colors has been entered

            if list_index >= gridsize**2:    #This makes the code check all of the values in the array. gridsize**2 represents the length of the array grid_list_use.
                print("Topped out ")        #This tells the user that the code has reached it's end
            elif grid_list_use[list_index][0] == "f":   #This checks if the patch that is currently being drawn needs to be the Penultimate of Final digit design.
                drawsteps(c*100,i*100,color)    #This calls the final patch design
            elif grid_list_use[list_index][0] == "p":   #This checks if the patch that is currently being drawn needs to be the Penultimate of Final digit design.
                drawcirclepattern(c*100,i*100,color)    #This calls the penultimate patch design
            else:
                print("done")

            list_index = list_index + 1     #This increments the counter I use for my grid_list_use position by one
            print(list_index)       #This prints the position of my counter

userinputs(usrcolors,color)     #This calls the userinputs function
drawentiregrid(gridsize,usrcolors)     #This calls the main drawing function

time.sleep(60)      #My linux DE and VSCode require a sleep statement at the end to keep the window open, otherwise the window closes immediately after it finishes drawing.