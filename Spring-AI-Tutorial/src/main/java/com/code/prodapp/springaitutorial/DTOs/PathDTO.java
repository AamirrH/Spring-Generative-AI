package com.code.prodapp.springaitutorial.DTOs;


public record PathDTO(
        Long pathNumber,
        double distance,
        double timeToReach
) {
    @Override
    public String toString() {
        return "PathDTO{" +
                "pathNumber=" + pathNumber +
                ", distance=" + distance +
                ", timeToReach=" + timeToReach +
                '}';
    }
}
