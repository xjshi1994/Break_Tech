# Problems
## 1. unhashable type: 'dict'
Main Idea: choose the column set the agg func first before entering the page of visualization
> for example ,if you want both sum and avg of creditAmount
* `select creditAmount, creditAmount as _creditAmount`
* click 'Visualize'
* chooese for each column choose agg func sum, avg
* select dual line -> choose sum_creditAmount, avg__creditAmount


