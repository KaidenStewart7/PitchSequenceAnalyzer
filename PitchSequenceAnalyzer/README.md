# BaseballPowerRankingsGenerator

This project creates a BaseballPowerRankingsGenerator component. This component includes a kernel interface with contracts for the primary methods, another interface for contracts for the secondary methods, an abstract class to implement the secondary methods and to override methods from the Object class, and a kernel class to override the methods from the Standard interface as well as create a representation for the BaseabllPowerRankingsGenerator and to implement the kernel methods.

The main use of this component is to generate MLB Power Rankings. The input file should list each team's stats with one empty line in between and two at the end and the team's stats should be in the format:

Team Name
Team Wins
Team Losses
Team's Division Wins (The total number of wins for all team's in the division)
Team's Division Losses (The total number of losses for all team's in the division)
Team Wins Last 10 Games
Team Losses Last 10 Games
Team Point Differential

The output file will have the data listed at the top and then a numbered list of the teams with their strength ratings ordered from the highest strength rating to the lowest strength rating.