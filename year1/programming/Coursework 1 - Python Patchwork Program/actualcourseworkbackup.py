from graphics import *
import time


gridsize = input("What sized grid do you want? Enter 5, 7 or 9: ")

global color
color = "orange"


usrcolors = input("Please enter the 3 colors you would like seperated by commas (eg. red,blue,green)")
arr_usercolors = usrcolors.split(",")



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

def circledrawlinepat1(drawxcoord,drawycoord):
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
            for i in range(0,10):
                circle = Circle(Point(drawxcoord+10,drawycoord+10),10)
                circle.setFill(color)
                circle.setOutline(color)
                circle.draw(win)
                drawxcoord = drawxcoord + 1
            drawxcoord = drawxcoord + 30
        else:
            circle = Circle(Point(drawxcoord,drawycoord+10),10)
            circle.setFill(color)
            circle.setOutline(color)
            circle.draw(win)
            drawxcoord = drawxcoord + 10

def drawcirclepattern(startxcoord,startycoord):
    background = Rectangle(Point(startxcoord,startycoord),Point(startxcoord+100,startycoord+100))
    background.setFill("White")
    background.setOutline("White")
    background.draw(win)
    for i in range(0,5):
        if i % 2 == 1:
            circledrawlinepat1(startxcoord,startycoord)
        else:
            circledrawlinepat2(startxcoord,startycoord,color)
        startycoord = startycoord + 20


#0 = PRIM - 1 = SECOND - 2 = TERT
list_5x5grid = ["f","f","f","f","f","p","f","f","f","p","p","p","f","p","p","p","f","f","f","p","f","f","f","f","f"]
list_7x7grid = ["f","f","f","f","f","f","f","p","f","f","f","f","f","p","p","p","f","f","f","p","p","p","p","p","f","p","p","p","p","p","f","f","f","p","p","p","f","f","f","f","f","p","f","f","f","f","f","f","f"]
list_9x9grid = ["f","f","f","f","f","f","f","f","f","p","f","f","f","f","f","f","f","p","p","p","f","f","f","f","f","p","p","p","p","p","f","f","f","p","p","p","p","p","p","p","f","p","p","p","p","p","p","p","f","f","f","p","p","p","p","p","f","f","f","f","f","p","p","p","f","f","f","f","f","f","f","p","f","f","f","f","f","f","f","f","f","f"]

if gridsize == 5:
    grid_list_use = list_5x5grid
elif gridsize == 7:
    grid_list_use = list_7x7grid
elif gridsize == 9:
    grid_list_use = list_9x9grid




    prim_colors = ["0","1","2","3","4","6","7","8","11","15","16","17","19","20","21","22","23","24"]
    scnd_colors = ["5","10","11","15"]
    tert_colors = ["9","13","14","19"]



print("length = %i" % len(grid_list_use) )

def drawentiregrid(gridsize):
    list_index = 0
    for i in range(0,gridsize):
        for c in range(0,gridsize):
            if list_index > gridsize**2:
                print("Topped out ")
            elif grid_list_use[list_index] == "f":
                drawsteps(c*100,i*100,color)
            elif grid_list_use[list_index] == "p":
                drawcirclepattern(c*100,i*100)
            else:
                print("done")

            list_index = list_index + 1
            print(list_index)

drawentiregrid(gridsize)




time.sleep(60)