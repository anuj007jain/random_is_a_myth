package com.Algorithms_2_Coursera.Week3;

import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BaseballEliminationUsingMyMethods {

    private int noOfTeams;
    private Map<String, Integer> teamsToIndex;
    private Map<Integer, String> indexToTeam;
    private int[][] currentTable;
    private int[][] remainingGames;
    private Iterable<String>[] certificateOfEliminationForTeam;
    int V;

    // create a baseball division from given filename in format specified below
    public BaseballEliminationUsingMyMethods(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        noOfTeams = Integer.parseInt(line);
        teamsToIndex = new HashMap<>();
        indexToTeam = new HashMap<>();
        currentTable = new int[noOfTeams][3];
        remainingGames = new int[noOfTeams][noOfTeams];
        certificateOfEliminationForTeam = new Iterable[noOfTeams];
        V = 2 + (noOfTeams - 1) + combinations(noOfTeams - 1, 2);

        for (int i = 0 ; i < noOfTeams ; i++) {
            line = reader.readLine();
            String[] teamData = line.split("\\s+");
            teamsToIndex.put(teamData[0], i);
            indexToTeam.put(i, teamData[0]);
            currentTable[i][0] = Integer.parseInt(teamData[1]);
            currentTable[i][1] = Integer.parseInt(teamData[2]);
            currentTable[i][2] = Integer.parseInt(teamData[3]);
            for (int j = 0 ; j < noOfTeams ; j++) {
                remainingGames[i][j] = Integer.parseInt(teamData[4+j]);
                remainingGames[j][i] = Integer.parseInt(teamData[4+j]);
            }
        }
    }

    private int combinations(int n, int r) {
        int num = 1;
        int n_r = n - r;
        while (n > 1) {
            num *= n--;
        }
        int den = 2;
        while (n_r > 1) {
            den *= n_r--;
        }
        return num / den;
    }

    // number of teams
    public int numberOfTeams() {
        return noOfTeams;
    }

    // all teams
    public Iterable<String> teams() {
        return teamsToIndex.keySet();
    }

    // number of wins for given team
    public int wins(String team) throws IllegalArgumentException{
        if (!((Set<String>) teams()).contains(team)) {
            throw  new IllegalArgumentException();
        }
        return currentTable[teamsToIndex.get(team)][0];
    }

    // number of losses for given team
    public int losses(String team) {
        if (!((Set<String>) teams()).contains(team)) {
            throw  new IllegalArgumentException();
        }
        return currentTable[teamsToIndex.get(team)][1];
    }

    // number of remaining games for given team
    public int remaining(String team) {
        if (!((Set<String>) teams()).contains(team)) {
            throw  new IllegalArgumentException();
        }
        return currentTable[teamsToIndex.get(team)][2];
    }

    // number of remaining games between team1 and team2
    public int against(String team1, String team2) {
        if (!((((Set<String>) teams()).contains(team1)) && (((Set<String>) teams()).contains(team2)))){
            throw  new IllegalArgumentException();
        }
        return remainingGames[teamsToIndex.get(team1)][teamsToIndex.get(team2)];
    }

    // is given team eliminated?
    public boolean isEliminated(String team) {
        if (!((Set<String>) teams()).contains(team)) {
            throw  new IllegalArgumentException();
        }
        //check trivial elimination from other teams
        Set<String> certificateOfElimination = new HashSet<>();
        for (int teamVertex = 0 ; teamVertex < numberOfTeams() ; teamVertex++) {
            if (team.equals(indexToTeam.get(teamVertex))) {
                continue;
            } else {
                if (wins(indexToTeam.get(teamVertex)) > wins(team) + remaining(team)) {
                    certificateOfElimination.add(indexToTeam.get(teamVertex));
                }
            }
        }
        int capacityFromSource = 0;
        FordFulkerson.FlowNetwork fn = new FordFulkerson.FlowNetwork(V);
        int teamIndex = teamsToIndex.get(team);
        Map<FFNode, Integer> ffNodeToffId = new HashMap<>();
        Map<Integer, FFNode> ffIdToffNode = new HashMap<>();
        FFNode sourceNode = new FFNode("SOURCE");
        ffNodeToffId.put(sourceNode, 0);
        ffIdToffNode.put(0, sourceNode);
        FFNode sinkNode = new FFNode("SINK");
        ffNodeToffId.put(sinkNode, V - 1);
        ffIdToffNode.put(V - 1, sinkNode);
        int noOfTeamVertices = numberOfTeams() - 1;

        int k = 0;
        for (int teamVertex = 0 ; teamVertex < numberOfTeams() ; teamVertex++) {
            if (teamVertex == teamIndex) {
                continue;
            }
            FFNode node = new FFNode("TEAM_VERTEX", teamVertex);
            ffNodeToffId.put(node, (V - noOfTeamVertices - 1) + k);
            ffIdToffNode.put((V - noOfTeamVertices - 1) + k++, node);
            if (certificateOfElimination.contains(indexToTeam.get(teamVertex))) {
                fn.addEdge(new FordFulkerson.FlowEdge(ffNodeToffId.get(new FFNode("TEAM_VERTEX", teamVertex)),
                        ffNodeToffId.get(new FFNode("SINK")),
                        Double.POSITIVE_INFINITY));
            } else {
                fn.addEdge(new FordFulkerson.FlowEdge(ffNodeToffId.get(new FFNode("TEAM_VERTEX", teamVertex)),
                        ffNodeToffId.get(new FFNode("SINK")),
                        wins(team) + remaining(team) - wins(indexToTeam.get(teamVertex)) > 0 ?
                                wins(team) + remaining(team) - wins(indexToTeam.get(teamVertex)) : 0));
            }
        }

        k = 0;
        for (int teamVertex1 = 0 ; teamVertex1 < numberOfTeams() ; teamVertex1++) {
            if (teamVertex1 == teamIndex) {
                continue;
            }
            for (int teamVertex2 = teamVertex1 + 1 ; teamVertex2 < noOfTeams ; teamVertex2++) {
                if (teamVertex2 == teamIndex) {
                    continue;
                }
                FFNode node = new FFNode("GAME_VERTEX", teamVertex1, teamVertex2);
                ffNodeToffId.put(node, 1 + k);
                ffIdToffNode.put(1 + k++, node);
                //source to game vertex
                fn.addEdge(new FordFulkerson.FlowEdge(ffNodeToffId.get(new FFNode("SOURCE")),
                        ffNodeToffId.get(new FFNode("GAME_VERTEX", teamVertex1, teamVertex2)),
                        against(indexToTeam.get(teamVertex1), indexToTeam.get(teamVertex2))));
                capacityFromSource += against(indexToTeam.get(teamVertex1), indexToTeam.get(teamVertex2));
                //game vertex to team vertex
                fn.addEdge(new FordFulkerson.FlowEdge(ffNodeToffId.get(new FFNode("GAME_VERTEX", teamVertex1, teamVertex2)),
                        ffNodeToffId.get(new FFNode("TEAM_VERTEX", teamVertex1)),
                        Double.POSITIVE_INFINITY));
                fn.addEdge(new FordFulkerson.FlowEdge(ffNodeToffId.get(new FFNode("GAME_VERTEX", teamVertex1, teamVertex2)),
                        ffNodeToffId.get(new FFNode("TEAM_VERTEX", teamVertex2)),
                        Double.POSITIVE_INFINITY));
            }
        }
        FordFulkerson ff = new FordFulkerson(ffNodeToffId.get(new FFNode("SOURCE")),
                ffNodeToffId.get(new FFNode("SINK")), fn);
        if (ff.flow() == capacityFromSource && certificateOfElimination.size() == 0) {
            return false;
        }
        for (Integer cutVertex : ff.minCut()) {
            if (ffIdToffNode.get(cutVertex).type == "TEAM_VERTEX") {
                certificateOfElimination.add(indexToTeam.get(ffIdToffNode.get(cutVertex).vertex0));
            }
        }
        certificateOfEliminationForTeam[teamIndex] = certificateOfElimination;
        return true;

    }

    private class FFNode {
        String type;
        Integer vertex0;
        Integer vertex1;

        public FFNode(String type) {
            this.type = type;
        }

        public FFNode(String type, int vertex0) {
            this.type = type;
            this.vertex0 = vertex0;
        }

        public FFNode(String type, int vertex0, int vertex1) {
            this.type = type;
            this.vertex0 = vertex0;
            this.vertex1 = vertex1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FFNode ffNode = (FFNode) o;
            if (type.equals("SOURCE") || type.equals("SINK")) {
                return Objects.equals(type, ffNode.type);
            }
            if (type.equals("TEAM_VERTEX")) {
                return Objects.equals(type, ffNode.type) &&
                        Objects.equals(vertex0, ffNode.vertex0);
            }
            return Objects.equals(type, ffNode.type) &&
                    Objects.equals(vertex0, ffNode.vertex0) &&
                    Objects.equals(vertex1, ffNode.vertex1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, vertex0, vertex1);
        }
    }

    // subset R of teams that eliminates given team; null if not eliminated
    public Iterable<String> certificateOfElimination(String team) {
        return certificateOfEliminationForTeam[teamsToIndex.get(team)];
    }

    public static void main(String[] args) throws IOException {
        BaseballEliminationUsingMyMethods division = new BaseballEliminationUsingMyMethods(args[0]);
        for (String team : division.teams()) {
            if (division.isEliminated(team)) {
                StdOut.print(team + " is eliminated by the subset R = { ");
                for (String t : division.certificateOfElimination(team)) {
                    StdOut.print(t + " ");
                }
                StdOut.println("}");
            }
            else {
                StdOut.println(team + " is not eliminated");
            }
        }
    }

}
