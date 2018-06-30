system = require('system')
var page = require('webpage').create()
var page2 = require('webpage').create()
var username = system.args[1]
var password = system.args[2]
var url = 'http://127.0.0.1:8088/login/'
var url2 = 'http://127.0.0.1:8088/superset/dashboard/7/?preselect_filters=%7B%7D'
var steps = [
// log in website
 function() {
 	console.log('home page  website')
	page.open(url, function(status) {
		console.log(status)
	})
 },
// input username and password
 function() {
	console.log('logging in......')
	page.evaluate(function(usr, pwd) {
		console.log('usr is ' + usr)
		console.log('pwd is ' + pwd)
		document.querySelector('input[name="username"]').value = usr
		document.querySelector('input[name="password"]').value = pwd
		document.querySelector('form').submit()
	
	
	}, username, password)

 },
 function() {
	console.log('hah')
	page.open(url2, function(status){ 
			console.log('cap success')
			setTimeout(function(){
				page.zoomFactor = 0.25
				page.render('superset2.jpg', {format: 'jpg', quality: '100'})
			}, 6000)
	})
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
