var page = require("webpage").create()
var url = 'http://www.taobao.com'

// use eog to open picture in the terminal
page.open(url, function(status){
	page.render('taobao.jpeg', {format: 'jpeg', quality: '100'}, function(msg){console.log("hi render")})
})

page.onConsoleMessage = function(msg) {
	console.log('cookie is following' + msg)
}

