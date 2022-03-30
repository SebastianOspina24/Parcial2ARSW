/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.clickrace.model;

/**
 *
 * @author hcadavid
 */
public class RaceParticipant implements Comparable<RaceParticipant>{

    int number;
    Boolean winner = false;

    public RaceParticipant() {
    }

    public RaceParticipant(int number) {
        this.number = number;
    }
    

    public RaceParticipant(int number, Boolean winner) {
        this.number = number;
        this.winner = winner;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.number;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RaceParticipant other = (RaceParticipant) obj;
        if (this.number != other.number) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(RaceParticipant o) {
        return o.getNumber()-this.getNumber();
    }


    
}
