This application for oauth server with properties file based
------------------------------------------------------------- 
spring:
  security:
    user:
      name: krish
      password: krish123
      roles: ADMIN,USER
    
    
security:    
   oauth2:
      client:
        client-id: mobile 
        client-secret: pin
        access-token-validity-seconds: 3600
        authorized-grant-types: refresh_token,authorization_code,password,client_credentials
        scope: READ,WRITE
      authorization:
         check-token-access: permitAll
        

This get Token::::::: http://localhost:8282/oauth/token

basic Authication 
username:mobile
passowrd:pin


payload:
{
applivation_Content_type: xwww-fromurluncoder
grant_type:password
username:krish
password:krish1234

}
responces:
--------
{
    "access_token": "c8f08bee-0aaa-4d41-9762-398346de3a86",
    "token_type": "bearer",
    "expires_in": 43199,
    "scope": "READ WRITE"
}


This for acess Appliaction url: http://localhost:8282/oauth/check_token?token=c8f08bee-0aaa-4d41-9762-398346de3a86

basic Authication 
username:mobile
passowrd:pin


payload:
{
applivation_Content_type: xwww-fromurluncoder
grant_type:password
username:krish
password:krish1234

}

responces
----------

{
    "active": true,
    "exp": 1590189363,
    "user_name": "suraga",
    "authorities": [
        "CAN_WRITE",
        "CAN_READ"
    ],
    "client_id": "web",
    "scope": [
        "READ",
        "WRITE"
    ]
}


