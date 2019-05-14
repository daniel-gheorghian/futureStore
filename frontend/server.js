(function ()
{
    "use strict";

    var express = require( 'express' );
    var morgan = require( 'morgan' );
    var proxy = require( 'express-http-proxy' );
    var thePort = 5001;

    var app = express();

    app.use( express.static( "src" ) );
    app.use( morgan( 'dev' ) );
    app.use( '/api',
             createProxy( 'localhost',
                          5000,
                          '/api' ) );

    app.listen( thePort,
                'localhost' );
    console.log( "Server is Listening on port " + thePort );

    function getPath ( req )
    {
        return require( 'url' ).parse( req.url ).path;
    }

    function createProxy ( hostname, port, path )
    {
        return proxy( hostname + ":" + port,
                      {
                          proxyReqPathResolver: function ( req )
                          {
                              return path + getPath( req );
                          }
                      } );
    }
})();