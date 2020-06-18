row_color_array = [0,0,1,0,0]

for i in range(0,5): #This is for drawing a row
    print("I is now: %i" % i)
    print("Array value at index I is now: %i" % row_color_array[i])

    if row_color_array[i] == 0:
        patch_color = "primarycolor"
    elif row_color_array[i] == 1:
        patch_color = "secondarycolor"
    else:
        patch_color = "tertiarycolor"

