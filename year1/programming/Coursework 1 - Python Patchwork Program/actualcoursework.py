##########################
# Edward Gray
# UP939720
# Programming Coursework 1 - Patchwork Program
##########################
from graphics import *
import time

global usrcolors
usrcolors = []
global color
color = ""

i = 0
while i < 1:
    gridsize = int(input("What sized grid do you want? Enter 5, 7 or 9: "))
    if gridsize in [5,7,9]:
        print("Good Input %i - Continuing..." % gridsize)
        i = 1
    else:
        print("Something was wrong - please re-enter your choice...")

#ROBUST CODE!
def userinputs(usrcolors, color):
    i = 0
    

    while i < 3:
        color_inital = str(input("Please enter the initial of color number %i: " %i))
        if color_inital == "r":
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
        else:
            i = i - 1
            print("There was an error - please enter your color again...")
        
        i = i + 1

        
        print(usrcolors)   

win = GraphWin("Coursework",gridsize*100,gridsize*100)

def drawsteps(startxcoord,startycoord,color):
    bg = Rectangle(Point(startxcoord,startycoord),Point(startxcoord+100,startycoord+100))
    bg.setFill("White")
    bg.setOutline("White")
    bg.draw(win)

    drawycoord = startycoord + 90
    drawxcoord = startxcoord
    for i in range(0,10):
        stepdraw = Rectangle(Point(drawxcoord,drawycoord),Point(startxcoord+100,startycoord+100))
        stepdraw.setFill(color)
        stepdraw.setOutline(color)
        stepdraw.draw(win)

        drawxcoord = drawxcoord + 10
        drawycoord = drawycoord - 10

def circledrawlinepat1(drawxcoord,drawycoord,color):
    for i in range(0,4):
        if i % 2 == 1:
            circle = Circle(Point(drawxcoord,drawycoord+10),10)
            circle.setFill(color)
            circle.setOutline(color)
            circle.draw(win)
            drawxcoord = drawxcoord + 10
        else:
            for i in range(0,10):
                circle = Circle(Point(drawxcoord+10,drawycoord+10),10)
                circle.setFill(color)
                circle.setOutline(color)
                circle.draw(win)
                drawxcoord = drawxcoord + 1
            drawxcoord = drawxcoord + 30
  
def circledrawlinepat2(drawxcoord,drawycoord,color):
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


def drawcirclepattern(startxcoord,startycoord,color):
    background = Rectangle(Point(startxcoord,startycoord),Point(startxcoord+100,startycoord+100))
    background.setFill("White")
    background.setOutline("White")
    background.draw(win)
    for i in range(0,5):
        if i % 2 == 1:
            circledrawlinepat1(startxcoord,startycoord,color)
            pass
        else:
            circledrawlinepat2(startxcoord,startycoord,color)
            pass
        startycoord = startycoord + 20

#0 = PRIM - 1 = SECOND - 2 = TERT
list_5x5grid = ["f0","f0","f0","f0","f0","p1","f0","f0","f0","p2","p1","p1","f0","p2","p2","p1","f0","f0","f0","p2","f0","f0","f0","f0","f0"]
list_7x7grid = ["f0","f0","f0","f0","f0","f0","f0","p1","f0","f0","f0","f0","f0","p2","p1","p1","f0","f0","f0","p2","p2","p1","p1","p1","f0","p2","p2","p2","p1","p1","f0","f0","f0","p2","p2","p1","f0","f0","f0","f0","f0","p2","f0","f0","f0","f0","f0","f0","f0"]
list_9x9grid = ["f0","f0","f0","f0","f0","f0","f0","f0","f0","p1","f0","f0","f0","f0","f0","f0","f0","p2","p1","p1","f0","f0","f0","f0","f0","p2","p2","p1","p1","p1","f0","f0","f0","p2","p2","p2","p1","p1","p1","p1","f0","p2","p2","p2","p2","p1","p1","p1","f0","f0","f0","p2","p2","p2","p1","p1","f0","f0","f0","f0","f0","p2","p2","p1","f0","f0","f0","f0","f0","f0","f0","p2","f0","f0","f0","f0","f0","f0","f0","f0","f0","f0"]

if gridsize == 5:
    grid_list_use = list_5x5grid
elif gridsize == 7:
    grid_list_use = list_7x7grid
elif gridsize == 9:
    grid_list_use = list_9x9grid

def drawentiregrid(gridsize,usrcolors):
    list_index = 0

    prim_color = usrcolors[0]
    scnd_color = usrcolors[1]
    tert_color = usrcolors[2]

    for i in range(0,gridsize):
        for c in range(0,gridsize):        

            if grid_list_use[list_index][1] == "0":
                color = prim_color
            elif grid_list_use[list_index][1] == "1":
                color = scnd_color
            elif grid_list_use[list_index][1] == "2":
                color = tert_color

            print("Color is %s" % color)

            if list_index > gridsize**2:
                print("Topped out ")
            elif grid_list_use[list_index][0] == "f":
                drawsteps(c*100,i*100,color)
            elif grid_list_use[list_index][0] == "p":
                drawcirclepattern(c*100,i*100,color)
            else:
                print("done")

            list_index = list_index + 1
            print(list_index)

userinputs(usrcolors,color)
drawentiregrid(gridsize,usrcolors)

time.sleep(60)