const cors = require('cors')
var express = require('express');
var app = express();

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

    // connect to your database
    sql.connect(config, function (err) {
    
        if (err) console.log(err);

        // create Request object
        var request = new sql.Request();
           
        // query to the database and get the records
        request.query('SELECT TOP 10 * from CombinedTable', function (err, recordset) {
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

