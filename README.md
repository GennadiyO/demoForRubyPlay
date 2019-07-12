# demoForRubyPlay

REST API:

1. To register new visit for specific night club<br>
            http://\<domain>:8080/api/visits/register?userName=\<userName>&nightClubName=\<nightClubName><br>
        Example:<br>
            http://localhost:8080/api/visits/register?userName=firstUser&nightClubName=firstNightClub<br>
            
2. To get the information about all visitors of some night-club<br>
            http://\<domain>:8080/api/nightClubs/show/allVisitors?nightClubName=\<nightClubName><br>
        Example:<br>
            http://localhost:8080/api/nightClubs/show/allVisitors?nightClubName=thirdNightClub<br>
            
3. To get the information of all night clubs which user has visited already<br>
            http://\<domain>:8080/api/visitor/show/visitedNightClubs?userName=\<userName><br>
        Example:<br>
            http://localhost:8080/api/visitor/show/visitedNightClubs?userName=firstUser<br>

4. To get the information of all night clubs which user hasn't visited yet<br>
            http://\<domain>:8080/api/visitor/show/notVisitedNightClubs?userName=\<userName><br>
        Example:<br>
            http://localhost:8080/api/visitor/show/notVisitedNightClubs?userName=firstUser
            
5. To get the information about all visitors who visited more than 2 different night club<br>
            http://\<domain>:8080/api/nightClubs/show/visitorsWithMoreThan2DiffNightClubs<br>
        Example:<br>
            http://localhost:8080/api/nightClubs/show/visitorsWithMoreThan2DiffNightClubs<br>
