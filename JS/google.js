var system = require('system')
var page = require('webpage').create()

var arg1 = system.args[1]
var url = 'http://www.baidu.com'
var steps = [
  function() {
	console.log("logging in google!")
	page.open(url)
 },
 function() {
 	console.log("doing search!")
	page.evaluate(function(arg1) {
		console.log(arg1)
		document.querySelector('input[name="wd"]').value = arg1
		document.querySelector('form').submit()
	}, arg1)
 },
 function() {
 	page.evaluate(function(){
		console.log("get the result back")
		console.log('first search result title is ' + document.querySelector('h2 a').text)
	})	
 },

 function() {
	console.log('capturing the pic')
	page.zoomFactor = 5;
	page.render('result.jpg', {format: 'jpg', quality: '100'})
 }
]

var stepindex = 0
var loading = false
setInterval(executeRequestsStepByStep, 50)

function executeRequestsStepByStep(){
  if (loading == false && steps[stepindex]) {
    steps[stepindex]()
    stepindex++
  }
  if (!steps[stepindex]) {
    phantom.exit()
  }
}

page.onLoadStarted = function() { loading = true }
page.onLoadFinished = function() { loading = false }
page.onConsoleMessage = function(msg) { console.log(msg) }
