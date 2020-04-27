    var pusher = require("pusher")
    var express = require("express")
    var Pusher = require("pusher")
    var bodyParser = require("body-parser")
    var pusher = new Pusher({
        appId: "app_id",
        key: "app_key",
        secret: "app_secrete",
        cluster: "app_cluster"
      });
    var app = express();
    app.use(bodyParser.json());
    app.use(bodyParser.urlencoded({ extended: false }));

    app.post('/location', (req, res,next)=>{

        var longitude = req.body.longitude;
        var latitude = req.body.latitude;
        var username = req.body.username;

        pusher.trigger('feed', 'location', {longitude, latitude,username});
        res.json({success: 200});
    });
    app.listen(4040, function () {
        console.log('Listening on 4040')
      })