# @author Konstantin Pankov kspzel@gmail.com

inputFile = open("keywords.txt", "r")
buf = inputFile.readlines()
inputFile.close()
buf.sort()
last = buf.pop()
outputFile = open("keywords.jj", "w")
outputFile.write("TOKEN: \n{\n ")
for line in buf:
    outputFile.write(" < " + line.strip("\n").upper() + ": \"" + line.strip("\n") + "\" >\n|")
outputFile.write(" < " + last.strip("\n").upper() + ": \"" + last.strip("\n") + "\" >\n}\n")
outputFile.close()
