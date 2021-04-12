# Requirements

- java 8
- gradle

# API

This project run as per default on localhost:8080

## calculate

    /api/calculate

This endpoint expects a json object via a POST request. The json should represent a valid bowling game. 
If an invalid json or game representation is sent a http 400 response is sent back with a description of the error.

### Body structure

The endpoint expects an Object with a field "frames", the value if the field is a list of list of integers. 

The outer list represents the whole game and should have 10 elements.

The inner lists represents individual frames and should have 1, 2 integer values in them. 
3 values are possible for the 10-th frame.

The integers represent pins impacted by a single roll.

Json example:

    {
       "frames" : [[1,2], [3,4], [3,4], [3,4], [3,4], [3,4], [3,4], [3,4], [3,4], [3,7,6]]  
    }

### response

If a valid request is sent the response would have a single field "overallPoints" with the total points for the game.

Example:

    {
        "overallPoints": 75
    }


If an invalid request is sent an error message would be displayed.

# Swagger API Documentation
Is accessible at 

    /swagger-ui.html