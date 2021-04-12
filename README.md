# CricketTournament
This project is based on basic functionality for cricket tournament which happens between teams. There is a match between 2 teams and based on the highest score between them the winner is declare and at last we can have one tournament winner among this teams.

Note :
 1) To run the program run CricketTournment.java and enter required  fields in console
 2) The program should contains even number of teams for tournamnet
 3) The match between the teams happen by entering run or wicket for each team into the match
 4) After one match gets over the second match between other 2 teams starts.
 5) Winner of each match is been declare after each match
 
 --------------------------------------------------------------------------
 There are few constraints that are currently not handled due to time constraint :
 
 1) If wicket goes more then 10 than application will throw exception.
 2) If proper option to start match and also for which team to choose for batting for that match is not selected then appplication will print a message and need to run the program again.
 3) If runs enter is not 0,1,2,3,4,or 6 then run for that ball get skipped with a message.
 4) Match is played statically for 20 balls and runs(0,1,2,3,4 or 6) for each ball needs to be entered and for wicket enter -1.
 5) If by mistake 2 time enter is clicked while entering run then application will throw exception for that team and start match for another team.

NOTE :
Currently as there is no database I have added only match for first phase of tournamnet and made changes into objects only.Once database is there we can complete all the matches required for tournamnet with minor changes.


I have covered happy sceanrios for match between teams and the winner is been declared.If every input is entered correctly it will run and give result successfully.
