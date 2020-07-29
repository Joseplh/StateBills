
var express = require('express');
var app = express();

app.get('/', function (req, res) {
   
    var sql = require("mssql");

    // config for your database
    var config = {//////////////////////////////////////////////////////////////You will need to change these to the credential for the server
        user: 'javaUser',
        password: '',
        server: 'localhost', 
        database: 'StateBills' ///////////////////////////////////////////////////////////////////////
    };

    // connect to your database
    sql.connect(config, function (err) {
    
        if (err) console.log(err);

        // create Request object
        var request = new sql.Request();
           
        // query to the database and get the records
        //request.query('select * from CombinedTable Where Document=LB310A', function (err, recordset) {
        request.query('select * from CombinedTable', function (err, recordset) {    
            
            if (err) console.log(err)

            // send records as a response
            res.send(recordset);
            
        });
    });
});

var server = app.listen(5000, function () {
    console.log('Server is running..');
    console.log('Go to localhost:5000 to check connection')
});

