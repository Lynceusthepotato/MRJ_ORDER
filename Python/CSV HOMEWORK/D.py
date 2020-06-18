import matplotlib.pyplot as plt
from datetime import datetime
import statistics
import csv

dicts = {}
dictInterval = {}
dictIntervalWeekDays = {}
dictIntervalWeekEnds = {}

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

            if date2 % 7 == 0:
                dictIntervalWeekEnds.setdefault(interval,[]) # D is with this stuff
                dictIntervalWeekEnds[interval].append(int(steps))
            else:
                dictIntervalWeekDays.setdefault(interval,[])
                dictIntervalWeekDays[interval].append(int(steps))
listWeekdays = []
listWeekends = []
for i in dictIntervalWeekDays.keys():
    listWeekdays.append(statistics.mean(dictIntervalWeekDays.get(i)))
for i in dictIntervalWeekEnds.keys():
    listWeekends.append(statistics.mean(dictIntervalWeekEnds.get(i)))
something = []
for i in dictInterval.keys():
    something.append(i)
plt.plot(something,listWeekdays,c="blue")
plt.plot(something,listWeekends,c="orange")
plt.title("activity pattern")
plt.xlabel("interval")
plt.ylabel("number of steps")
plt.legend(["WeekDays","WeekEnds"])
plt.show()

