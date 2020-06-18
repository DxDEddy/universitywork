from graphics import *
import time

win = GraphWin("Coursework",500,500)

def trianglegriddraw(startxcoord,startycoord):  #Each side 20px
    print("Drawing code 3")
    y_mod = 0
    background = Rectangle(Point(startxcoord,startycoord),Point(startxcoord+100,startycoord+100))
    background.setFill("White")
    background.setOutline("White")
    background.draw(win)
    for x in range(0,5):    #Each Column
        y_mod = y_mod + 20      
        trianglerefcoordx = startxcoord
        trianglerefcoordy = startycoord
        trianglerefcoordy = trianglerefcoordy + y_mod
        
        if x % 2 == 1:
            for i in range(0,6):
                x_mod = 20
                triangleleftpoint = Point(trianglerefcoordx-10,trianglerefcoordy)
                triangletoppoint = Point(triangleleftpoint.getX()+10,triangleleftpoint.getY()-20)
                trianglerightpoint = Point(triangleleftpoint.getX()+20,triangleleftpoint.getY())

                fulltriangle = Polygon(triangleleftpoint,triangletoppoint,trianglerightpoint)
                fulltriangle.setFill("Red")
                fulltriangle.draw(win)

                trianglerefcoordx = trianglerefcoordx + x_mod
        else:
            for i in range(0,5):
                x_mod = 20
                triangleleftpoint = Point(trianglerefcoordx,trianglerefcoordy) #Origin of triangle
                triangletoppoint = Point(triangleleftpoint.getX()+10,triangleleftpoint.getY()-20)
                trianglerightpoint = Point(triangleleftpoint.getX()+20,triangleleftpoint.getY())

                fulltriangle = Polygon(triangleleftpoint,triangletoppoint,trianglerightpoint)
                fulltriangle.setFill("Red")
                fulltriangle.draw(win)
                trianglerefcoordx = trianglerefcoordx + x_mod

def squarediaglinedraw(startxcoord,startycoord):

    bg = Rectangle(Point(startxcoord,startycoord),Point(startxcoord+100,startycoord+100))
    bg.setFill("White")
    bg.setOutline("White")
    bg.draw(win)

    refxcoord = startxcoord
    refycoord = startycoord + 100

    for i in range(0,10):
        test = Rectangle(Point(refxcoord,refycoord),Point(refxcoord+10,refycoord-10))
        test.setFill("Red")
        test.draw(win)
        refycoord = refycoord - 10
        refxcoord = refxcoord + 10  

def drawentiregrid(ycoord):
    for c in range(0,5):    #This is for the 5 Vertical Rows
        xcoord = 0
        for i in range(0,5):    #This draws the 5 patches on each row

            if i % 2 != 1:  #This if statement is for alternating the rows for my sample pattern  
                if c % 2 == 1: #Every other row this IF statement will alternate it for my 
                    trianglegriddraw(xcoord,ycoord)
                else:
                    squarediaglinedraw(xcoord,ycoord)
            else:
                if c % 2 == 1:
                    squarediaglinedraw(xcoord,ycoord)
                else:
                    trianglegriddraw(xcoord,ycoord)

            xcoord = xcoord + 100   #One it draws the right patch it moves to the next section and the loop repeats to draw the right patch
        ycoord = ycoord + 100   #Once the drawing loop is completed it moves down to the next row
    

### Draw actual pattern
def drawactualpattern():
    size = int(input("What size do you want the patchwork to be? 5, 7 or 9."))
    for i in range(0,size):
        pass
        
#(7-5)/2 and (9-5)/2)

drawentiregrid(0)


time.sleep(87)