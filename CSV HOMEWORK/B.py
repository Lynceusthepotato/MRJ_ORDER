import matplotlib.pyplot as plt
from datetime import datetime
import statistics
import csv

dicts = {}
dictInterval = {}
filename = "activity.csv"
with open(filename) as f:
    reader = csv.reader(f)
    headrow = next(reader)
    for row in reader:
        steps = row[0]
        if steps != "NA":
            date = row[1]
            stepss.append(steps)
            date2 = int(datetime.strptime(date,"%Y-%m-%d").day)
            interval = int(row[2])

            dicts.setdefault(str(date),[])
            dicts[str(date)].append(int(steps))

            dictInterval.setdefault(interval,[])
            dictInterval[interval].append(int(steps))

meaninterval = [] 
for i in dictInterval.keys():
    meaninterval.append(statistics.mean(dictInterval.get(i)))
plt.plot(meaninterval)
plt.title("Histogram")
plt.xlabel("5 min interval")
plt.ylabel("average all day")
plt.show()
print("The max number of steps taken", max(meaninterval))
