# multi-db-location-service-broker

# Quickstart
1. Clone the repo
2. cd into the repo
3. execute: ./gradlew clean assemble
4. target you cf instance
5. execute: cf push
6. execute: cf create-service-broker db-broker user password <uri to service broker app>
7. execute: cf enable-service-access db-broker (You could add which plan should be available for which org)
8. execute: cf marketplace

Griffon:multi-db-location-service-broker dflick$ cf marketplace
Getting services from marketplace in org pivotal / space development as admin...
OK

service      plans                                 description   
db-broker    location-x, location-y, location-z*   Provides db connection strings  

9. execute: create service db-broker location-x mydbconnection
10. push the app of your choice and bind the service
11. execute: cf env <app> 

Griffon:groovy dflick$ cf env app
Getting env variables for app app in org pivotal / space development as admin...
OK

System-Provided:
{
 "VCAP_SERVICES": {
  "db-broker": [
   {
    "credentials": {
**     "uri": "oracle://root:secret@dbserver.location_x.com:1521/mydatabase"
    },
    "label": "db-broker",
    "name": "mydbconnection",
    "plan": "location-x",
    "tags": [
     "db-broker",
     "uri"
    ]
   }
  ]
 }
}

