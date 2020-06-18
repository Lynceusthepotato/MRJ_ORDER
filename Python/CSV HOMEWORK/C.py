import matplotlib.pyplot as plt
from datetime import datetime
import pandas as pd
import statistics
import csv

filename = pd.read_csv("activity.csv")
filename.isnull()
filename.isnull().sum()
print("The NA on the data","\n",filename.isnull().sum())
modifiedsteps = filename.fillna(int(float(30))) #<<< change here to change the NA
modifiedsteps.isnull().sum()
modifiedsteps.to_csv("newactivity.csv",index = False)
modifiedfilename = ("newactivity.csv")
dicts = {}
dictInterval = {}
dictIntervalWeekDays = {}
dictIntervalWeekEnds = {}
with open(modifiedfilename) as f:
    reader = csv.reader(f)
    headrow = next(reader)
    for row in reader:
        steps = row[0]
        if steps != "NA":
            date = row[1]
            date2 = int(datetime.strptime(date, "%Y-%m-%d").day)
            interval = int(row[2])

            dicts.setdefault(str(date), [])
            dicts[str(date)].append(int(float(steps)))

            dictInterval.setdefault(interval, [])
            dictInterval[interval].append(int(float(steps)))
listDate = []
listTotal = []
listAve = []

for i in dicts.keys():
    listDate.append(i)
    listTotal.append(sum(dicts.get(i)))
    listAve.append(statistics.mean(dicts.get(i)))

plt.hist(listTotal, edgecolor="black",linewidth=0.5)
plt.title("Histogram")
plt.xlabel("Steps per day")
plt.ylabel("Frequency")
plt.yticks(range(0,25,5))
plt.show()
print(f'Mean:{statistics.mean(listTotal)} \nMedian:{statistics.median(sorted(listTotal))} ')

