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
            date2 = int(datetime.strptime(date,"%Y-%m-%d").day)
            interval = int(row[2])

            dicts.setdefault(str(date),[])
            dicts[str(date)].append(int(steps))

            dictInterval.setdefault(interval,[])
            dictInterval[interval].append(int(steps))
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
print(f'Mean:{statistics.mean(listTotal)} \nMedian:{statistics.median(sorted(listTotal))}')
