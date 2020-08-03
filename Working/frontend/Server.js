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
<<<<<<< HEAD:Working/frontend/src/Server.js
        //request.query('select * from CombinedTable Where Document=\'LB310A\'', function (err, recordset) {
        request.query('select * from CombinedTable where Description LIKE \'%Fish%\'', function (err, recordset) {    
=======
        request.query('SELECT TOP 10 * from CombinedTable', function (err, recordset) {
        //request.query('select * from CombinedTable', function (err, recordset) {    
>>>>>>> eb5de9cb062582b5b1054af3f9d759ec05275bf7:Working/frontend/Server.js
            
            if (err) console.log(err)

            // send records as a response
            res.send(recordset);
            
        });
    });
});

var server = app.listen(5000, function () {
    console.log('Server is running..');
    
});

