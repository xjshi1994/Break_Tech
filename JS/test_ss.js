var system = require('system');
var args = system.args;

// Set credentials and paths
var endpoint = 'superset/dashboard/5/?preselect_filters=%7B"56"%3A%7B"__from"%3A""%2C"__to"%3A""%7D%7D';
var username = args[1];
var password = args[2];

var page = require('webpage').create();

page.viewportSize = {
    width: 1920,
    height:1080
};

const BASE_URL = 'http://10.132.1.4:8088/';

page.open(BASE_URL + 'login/', function(status) {
    var csrf_token = page.evaluate(function () {
	console.log(csrf_token)
        return document.querySelector('#csrf_token').value;
    });

    // Login
    loginBody = 'username=' + username + '&password=' + password + '&csrf_token=' + csrf_token;
    page.open(BASE_URL + 'login/', 'POST', loginBody,  function () {

        // Navigate to a dashboard
        page.open(BASE_URL + endpoint, function() {
                setTimeout(function () {
                    page.render('dashboard2.jpg');
                    phantom.exit();
                }, 5000);
        });
    });
});
