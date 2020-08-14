const cors = require('cors')
var express = require('express');
var app = express();
const bodyParser = require('body-parser');
const url = require('url');
const querystring = require('querystring');

app.use(cors({
        credentials: true
}))

app.get('/', function (req, res) {
   
    var sql = require("mssql");

    // config for your database
    var config = {//////////////////////////////////////////////////////////////You will need to change these to the credential for the server
        user: 'javaUser',
        password: '',
        server: '192.168.1.73', 
        database: 'StateBills' ///////////////////////////////////////////////////////////////////////
    };
    //192.168.1.73
    //70.171.162.251:1945
    // connect to your database
    sql.connect(config, function (err) {
    
        if (err) console.log(err);

        // create Request object
        var request = new sql.Request();
           
        // query to the database and get the records
        request.query('SELECT * from CombinedTable', function (err, recordset) {
        //request.query('select * from CombinedTable', function (err, recordset) {    
            
            if (err) console.log(err)

            // send records as a response
            res.send(recordset);
            
        });
    });
});


app.get('/query/:query/year/:year', function (req, res) {
    
    var query = req.params.query;
    var year = req.params.year;
   
    var sql = require("mssql");

    // config for your database
    var config = {//////////////////////////////////////////////////////////////You will need to change these to the credential for the server
        user: 'javaUser',
        password: '',
        server: '192.168.1.73', 
        database: 'StateBills' ///////////////////////////////////////////////////////////////////////
    };
    //192.168.1.73
    //70.171.162.251:1945
    // connect to your database
    sql.connect(config, function (err) {
    
        if (err) console.log(err);

        // create Request object
        var request = new sql.Request();
         
        var input = "SELECT * from CombinedTable where Description LIKE " + "'%" +  query + "%'"

        if(year != '*')
        {
            input += 'AND Update Date <= ' + year 
        }

        // query to the database and get the records
        request.query(input, function (err, recordset) {
        //request.query('select * from CombinedTable', function (err, recordset) {    
            
            if (err) console.log(err)

            // send records as a response
            res.send(recordset);
            
        });
    });
});

var server = app.listen(5000, function () {
    console.log('Server is running..');
    
});

