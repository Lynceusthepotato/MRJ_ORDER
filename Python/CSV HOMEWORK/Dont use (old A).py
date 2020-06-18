import matplotlib.pyplot as plt
from datetime import datetime
from pylab import show
import pandas as pd
import pygal
import numpy as np
import csv
pd.plotting.register_matplotlib_converters()
filename = "activity.csv"
dates, steps = [], []
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
    value = np.array(steps).astype(np.float)
    datepo = np.array(dates)
    bars = plt.bar(datepo, value, 1)
    for bar in bars:
        bar.set_edgecolor("black")
    plt.ylabel("steps")
    plt.xlabel("date")
    plt.title("histogram")
    plt.yticks([0, 100, 300, 500, 700, 800, 1000])
    plt.show()
    means = np.mean(value) #i dont think this is correct
    medians = np.median(value) #i know this is wrong
    print(means,medians)

