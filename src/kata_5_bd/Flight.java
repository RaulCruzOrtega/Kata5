package kata_5_bd;

import java.time.DayOfWeek;
import java.time.LocalTime;

class Flight {
private final DayOfWeek dayofweek;
private final LocalTime departureTime;
private final int departureDelay;
private final LocalTime arrivalTime;
private final int arrivalDelay;
private final int duration;
private final int distance;
private final boolean cancelled;
private final boolean diverted;

    public Flight(DayOfWeek dayofweek, LocalTime departureTime, int departureDelay, LocalTime arrivalTime, int arrivalDelay, int duration, int distance, boolean cancelled, boolean diverted) {
        this.dayofweek = dayofweek;
        this.departureTime = departureTime;
        this.departureDelay = departureDelay;
        this.arrivalTime = arrivalTime;
        this.arrivalDelay = arrivalDelay;
        this.duration = duration;
        this.distance = distance;
        this.cancelled = cancelled;
        this.diverted = diverted;
    }

    public DayOfWeek getDayofweek() {
        return dayofweek;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public int getDepartureDelay() {
        return departureDelay;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public int getArrivalDelay() {
        return arrivalDelay;
    }

    public int getDuration() {
        return duration;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public boolean isDiverted() {
        return diverted;
    }

}
