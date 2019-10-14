import matplotlib.pyplot as plt
from datetime import datetime
from pylab import show
import pandas as pd
import pygal
import numpy as np
import csv
pd.plotting.register_matplotlib_converters()
filename = "activity.csv"
dates, steps,intervals = [], [],[]
mydict = {}
with open(filename) as f:
    reader = csv.reader(f)
    headrow = next(reader)
    for row in reader:
        step = row[0]
        if step != "NA":
            steps.append(step)
            date = datetime.strptime(row[1],"%Y-%m-%d")
            dates.append(date)
            interval = row[2]
            intervals.append(interval)
    value = np.array(steps).astype(np.float)
    datepo = np.array(intervals).astype(np.float)
    plt.plot(datepo,value)
    plt.ylabel("steps")
    plt.xlabel("intervals")
    plt.title("histogram")
    plt.show()

