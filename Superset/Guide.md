# Problems
## 1. unhashable type: 'dict'
Main Idea: choose the column set the agg func to each of them before entering the page of visualization. Select the duplicate column if more than one function for one column.
> for example ,if you want both sum and avg of creditAmount in dual line graph
* `select creditAmount, creditAmount as _creditAmount`
* click 'Visualize'
* chooese for each column choose agg func sum, avg
* select dual line -> choose sum_creditAmount, avg__creditAmount
## 2. Word cloud
> for example , if you want draw the word cloud of Grade rating
* select creditRating from ProDatalog
* in the series blank ,choose the creditRating
* **IMPORTANT** After adding to the dashboard, if there is some values missing. It is because graph is not big enough to show the word cloud. _SOLUTION_: 1. change the font size of the word 2. enlarge the graph in the dashboard.

