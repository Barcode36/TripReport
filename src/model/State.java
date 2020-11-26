package model;

import util.DbConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class State {
    private String stateCode;
    private String stateName;

    public State() {
    }

    public static State getState(String stateCode) {
        try {
            // Create state
            State state = new State();

            // Execute sql
            ResultSet rs = DbConn.getConn().prepareStatement("select * from State where stateCode = '" + stateCode + "'").executeQuery();

            // Fill out trip
            rs.next();
            state = rsToState(rs);

            return state;
        } catch (SQLException e) {
            return null;
        }
    }

    public static List<State> getAllState() {
        try {
            // Create list
            List<State> states = new ArrayList<State>();

            // Execute sql
            ResultSet rs = DbConn.getConn().prepareStatement("select * from State").executeQuery();

            // Fill out list
            while(rs.next()){
                states.add(rsToState(rs));
            }

            return states;
        } catch (SQLException e) {
            return null;
        }
    }

    private static State rsToState(ResultSet rs) throws SQLException {
        State state = new State();

        state.stateCode = rs.getString("stateCode");
        state.stateName = rs.getString("stateName");

        return state;
    }

    @Override
    public String toString() {
        return "State{" +
                "stateCode='" + stateCode + '\'' +
                ", stateName='" + stateName + '\'' +
                '}';
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getStateName() {
        return stateName;
    }
}

